package com.spring.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(propagation=Propagation.REQUIRED,
			       rollbackFor={Exception.class})
	@Override
	public void createBoard(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
		
		String[]files = board.getFiles();
		
		int bno=boardDAO.selectMaxBno();
		
		if(files==null) return;
		for(String fileName:files){
			boardDAO.insertAttach(fileName,bno);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED,
				   rollbackFor={Exception.class})
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
		
		int bno=board.getBno();
		boardDAO.deleteAttach(bno);
		
		String[] files=board.getFiles();
		System.out.println(board);
		if(files==null){return;}
		for(String fileName:files){
			boardDAO.replaceAttach(fileName, bno);
		}
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,
			       rollbackFor={Exception.class})
	@Override
	public void deleteBoard(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
		boardDAO.deleteAttach(bno);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
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

	@Override
	public List<String> getAttach(int bno) throws SQLException {
		List<String> fileNames=boardDAO.selectAttach(bno);
		return fileNames;
	}

}



