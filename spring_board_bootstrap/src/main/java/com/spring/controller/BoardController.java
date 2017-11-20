package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.BoardVO;
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
}










