package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface BoardService {

	void createBoard(BoardVO board) throws SQLException;

	void updateBoard(BoardVO board) throws SQLException;

	void deleteBoard(int bno) throws SQLException;

	List<BoardVO> readBoardList() throws SQLException;

	BoardVO readBoardByBno(int bno) throws SQLException;

	List<BoardVO> readBOardListCriteria(Criteria cri) 
			throws SQLException;
	
	List<BoardVO> readSearchBoardList(SearchCriteria cri) 
			throws SQLException;
	int readSearchBoardListCount(SearchCriteria cri)
			throws SQLException;
	BoardVO increaseViewCntForReadBoard(int bno) throws SQLException;
}













