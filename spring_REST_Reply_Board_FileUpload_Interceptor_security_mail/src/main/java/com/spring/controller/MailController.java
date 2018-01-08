package com.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.MailDAO;
import com.spring.domain.MailVO;
import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.service.MailService;

@Controller
@RequestMapping("/smail")
public class MailController {	
	
	@Autowired
	private MailSender sender;
	
	@Autowired
	private MailService service;
	
	@Autowired
	private MailDAO mailDAO;	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri,
						 Model model) throws Exception{
		List<MailVO> mailList=service.readSearchMailList(cri);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.readSearchMailListCount(cri));
		
		model.addAttribute("list",mailList);
		model.addAttribute("pageMaker",pageMaker);
		
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void read(@ModelAttribute("cri")SearchCriteria cri,
					 @RequestParam("mno")int mno,
					 Model model)throws Exception{
		model.addAttribute(service.readMailByMno(mno));
	} 
		
	
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String remove(@RequestParam("mno")int mno, SearchCriteria cri,
						 RedirectAttributes rttr)throws Exception{
		
		service.deleteMail(mno);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/smail/list";
	}
	
	
	@RequestMapping(value="/mailForm",method=RequestMethod.GET)
	public void mailForm()throws Exception{}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registPOST(MailVO mail, Model model)throws Exception{
		try{
			service.createMail(mail);		
			model.addAttribute("mail",mail);
		}catch(SQLException e){
			throw e;
		}
		
		return "/smail/mailSuccess";
	}
	
	@RequestMapping("/getAttach/{mno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("mno")int mno)
								throws Exception{
		return service.getAttach(mno);
	}
	
}











