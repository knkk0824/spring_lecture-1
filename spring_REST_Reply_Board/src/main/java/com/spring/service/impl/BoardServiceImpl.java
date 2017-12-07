package com.spring.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.BoardDAO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;
import com.spring.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO){
		this.boardDAO=boardDAO;
	}
	
	@Override
	public void createBoard(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> readBoardList() throws SQLException {
		List<BoardVO> boardList=boardDAO.selectBoardList();
		return boardList;
	}

	@Override
	public BoardVO readBoardByBno(int bno) throws SQLException {
		BoardVO board=boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public List<BoardVO> readBoardListCriteria(Criteria cri)
			throws SQLException {
		List<BoardVO> boardList=boardDAO.selectBoardListCriteria(cri);
		return boardList;
	}

	@Override
	public List<BoardVO> readSearchBoardList(SearchCriteria cri)
			throws SQLException {
		List<BoardVO> boardList=boardDAO.selectSearchList(cri);
		return boardList;
	}

	@Override
	public int readSearchBoardListCount(SearchCriteria cri) throws SQLException {
		int countList=boardDAO.selectSearchListCount(cri);
		return countList;
	}

	@Override
	public BoardVO increaseViewCntForReadBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		BoardVO board=boardDAO.selectBoardByBno(bno);		
		return board;		
	}

}



