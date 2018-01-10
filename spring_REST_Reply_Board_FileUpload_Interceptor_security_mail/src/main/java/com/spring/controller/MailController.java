package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.spring.domain.UserVO;
import com.spring.service.MailService;
import com.spring.service.UserService;

@Controller
@RequestMapping("/smail")
public class MailController {

	@Autowired
	private MailSender sender;

	@Autowired
	private MailService service;

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailDAO mailDAO;	

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		List<MailVO> mailList = service.readSearchMailList(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.readSearchMailListCount(cri));

		model.addAttribute("list", mailList);
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readMail", method = RequestMethod.GET)
	public void read(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("mno") int mno, Model model) throws Exception {
		model.addAttribute(service.readMailByMno(mno));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("mno") int mno, SearchCriteria cri,
			RedirectAttributes rttr) throws Exception {

		service.deleteMail(mno);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/smail/list";
	}

	@RequestMapping(value = "/mailForm", method = RequestMethod.GET)
	public void mailForm(HttpSession session,Model model) throws Exception {
		String uid=(String)session.getAttribute("loginUser");
		UserVO user=userService.getUserByID(uid);
		model.addAttribute("user",user);
	}

	@RequestMapping(value = "/mailSend", method = RequestMethod.POST)
	public String registPOST(HttpServletRequest request,
			HttpServletResponse response, MailRequest mailReq) throws Exception {
		JavaMailSender mailSender = (JavaMailSender) sender;

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,
				"utf-8");
		
		System.out.println(mailReq);
		
		messageHelper.setSubject(mailReq.getTitle());

		messageHelper.setText(mailReq.getContent(), true);
		messageHelper.setFrom(mailReq.getFrom(), "운영자");
		messageHelper.setTo(new InternetAddress(mailReq.getTo()));


		for (String filePath : mailReq.getFiles()) {
			
			String front = filePath.substring(0,12);
			String end=filePath.substring(14);			
			File file=new File(uploadPath+(front+end).replace('/',File.separatorChar));			
			String fileName=end.split("_")[1];

			messageHelper.addAttachment(fileName, file);
		}
		
		System.out.println(message);
		
		mailSender.send(message);
		MailVO mail=mailReq.toMailVO();
		service.createMail(mail);
		return "/smail/mailSuccess";
	}

	@RequestMapping("/getAttach/{mno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("mno") int mno)
			throws Exception {
		return service.getAttach(mno);
	}

}
