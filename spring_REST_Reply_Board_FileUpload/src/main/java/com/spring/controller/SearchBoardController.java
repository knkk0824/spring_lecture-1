package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri,
						 Model model) throws Exception{
		List<BoardVO> boardList=service.readSearchBoardList(cri);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.readSearchBoardListCount(cri));
		
		model.addAttribute("list",boardList);
		model.addAttribute("pageMaker",pageMaker);
		
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void read(@ModelAttribute("cri")SearchCriteria cri,
					 @RequestParam("bno")int bno,
					 Model model)throws Exception{
		model.addAttribute(service.increaseViewCntForReadBoard(bno));
	} 
	
	@RequestMapping(value="/modifyPageForm",method=RequestMethod.GET)
	public String modifyPageForm(@ModelAttribute("cri")SearchCriteria cri,
							   int bno, Model model)throws Exception{
		model.addAttribute(service.readBoardByBno(bno));
		return "sboard/modifyPage";
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.POST)
	public String modifyPage(BoardVO board, SearchCriteria cri,
							 RedirectAttributes rttr)throws Exception{
		service.updateBoard(board);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/sboard/list";
	}	
	
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String remove(@RequestParam("bno")int bno, SearchCriteria cri,
						 RedirectAttributes rttr)throws Exception{
		
		service.deleteBoard(bno);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/sboard/list";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registGET()throws Exception{}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registPOST(BoardVO board,
						     RedirectAttributes rttr)throws Exception{
		
		service.createBoard(board);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping("/getAttach/{bno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("bno")int bno)
								throws Exception{
		return service.getAttach(bno);
	}
	
}











