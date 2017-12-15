package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface BoardDAO {

	void insertBoard(BoardVO board) throws SQLException;

	void updateBoard(BoardVO board) throws SQLException;

	void deleteBoard(int bno) throws SQLException;

	List<BoardVO> selectBoardList() throws SQLException;

	BoardVO selectBoardByBno(int bno) throws SQLException;

	List<BoardVO> selectBoardListCriteria(Criteria cri) 
			throws SQLException;
	void increaseViewCnt(int bno) throws SQLException;
	
	//검색조건의 동적 쿼리문
	List<BoardVO> selectSearchList(SearchCriteria cri) 
			throws SQLException;
	int selectSearchListCount(SearchCriteria cri)	
			throws SQLException;
	
	// 파일 추가/삭제
	void insertAttach(String fullName,int bno)throws SQLException;
	int selectMaxBno()throws SQLException;
	List<String> selectAttach(int bno) throws SQLException;
	void deleteAttach(int bno)throws SQLException;
	void replaceAttach(String fullName,int bno)throws SQLException;
}











