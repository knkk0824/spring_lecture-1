package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public String listAll(Model model) throws Exception{
		String url="board/listAll";
		List<BoardVO> boardList=boardService.readBoardList();
		model.addAttribute("list",boardList);
		return url;
	}
	
	@RequestMapping("/readBoard")
	public void readBoard(int bno, Model model)throws Exception{
		/*String url="board/readBoard";*/
		BoardVO board=boardService.readBoardByBno(bno);
		model.addAttribute(board);
		/*return url;*/
	}
	
	@RequestMapping(value="/modifyBoard",method=RequestMethod.GET)
	public void modifyBoard(int bno,Model model)throws Exception{
		BoardVO board=boardService.readBoardByBno(bno);
		model.addAttribute(board);
	}
	
	@RequestMapping(value="/modifyBoard",method=RequestMethod.POST)
	public String modifyBoard(BoardVO board,Model model)throws Exception{
		String url="redirect:/board/listAll";
		boardService.updateBoard(board);
		return url;
	}
	
	@RequestMapping(value="/removeBoard",method=RequestMethod.POST)
	public String removeBoard(int bno)throws Exception{
		String url="redirect:/board/listAll";
		boardService.deleteBoard(bno);
		return url;
	}
	
	@RequestMapping(value="/createBoard",method=RequestMethod.GET)
	public String createBoard()throws Exception{
		String url="board/createBoardForm";
		return url;
	}
	
	@RequestMapping(value="/createBoard",method=RequestMethod.POST)
	public String createBoard(BoardVO board)throws Exception{
		String url="redirect:/board/listAll";
		boardService.createBoard(board);
		return url;
	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public String listCri(Criteria cri,Model model) throws Exception{
		String url="board/listAll";
		List<BoardVO> boardList=boardService.readBoardListCriteria(cri);
		model.addAttribute("list",boardList);
		return url;
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPage(@ModelAttribute("cri")Criteria cri,
							Model model)throws Exception{
		
		String url="board/listPage";
		List<BoardVO> boardList
			=boardService.readBoardListCriteria(cri);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.readBoardList().size());
		
		model.addAttribute("list",boardList);
		model.addAttribute("pageMaker",pageMaker);
		
		return url;
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public String readPage(@ModelAttribute("cri")Criteria cri,
						   @RequestParam("bno")int bno,Model model)
						   		throws Exception{
		String url="/board/readPage";
		
		BoardVO board=boardService.readBoardByBno(bno);
		model.addAttribute(board);
		
		return url;
	}
	
	@RequestMapping(value="/modifyPageForm",method=RequestMethod.GET)
	public String modifyPageForm(@RequestParam("bno")int bno,
								 @ModelAttribute("cri")Criteria cri,
								 Model model)throws Exception{
		
		String url="board/modifyPage";
		BoardVO board = boardService.readBoardByBno(bno);
		model.addAttribute(board);		
		
		return url;
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.POST)
	public String modifyPage(BoardVO board, Criteria cri,
							 RedirectAttributes rttr)throws Exception{
		
		boardService.updateBoard(board);		
		//rttr.addFlashAttribute("cri",cri);		
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String removeBoard(Criteria cri,int bno,
							  RedirectAttributes rttr)throws Exception{
		String url="redirect:/board/listPage";
		boardService.deleteBoard(bno);
		rttr.addFlashAttribute("cri",cri);
		return url;
	}
	
	@RequestMapping(value="/createPage",method=RequestMethod.GET)
	public String createPage()throws Exception{
		String url="board/createBoardForm";
		return url;
	}
	
	@RequestMapping(value="/createPage",method=RequestMethod.POST)
	public String createPage(BoardVO board)throws Exception{
		String url="redirect:/board/listPage";
		boardService.createBoard(board);
		return url;
	}
}










