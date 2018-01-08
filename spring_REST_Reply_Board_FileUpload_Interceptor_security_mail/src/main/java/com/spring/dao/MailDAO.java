package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.MailVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface MailDAO {

	void insertMail(MailVO mail) throws SQLException;

	void deleteMail(int mno) throws SQLException;

	List<MailVO> selectMailList() throws SQLException;

	MailVO selectMailByMno(int mno) throws SQLException;

	List<MailVO> selectMailListCriteria(Criteria cri) 
			throws SQLException;
	void increaseViewCnt(int mno) throws SQLException;
	
	//검색조건의 동적 쿼리문
	List<MailVO> selectSearchList(SearchCriteria cri) 
			throws SQLException;
	int selectSearchListCount(SearchCriteria cri)	
			throws SQLException;
	
	// 파일 추가/삭제
	void insertAttach(String fullName,int mno)throws SQLException;
	int selectMaxMno()throws SQLException;
	List<String> selectAttach(int mno) throws SQLException;
	void deleteAttach(int mno)throws SQLException;
}











