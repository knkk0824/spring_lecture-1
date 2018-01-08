package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.MailVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface MailService {

	void createMail(MailVO mail) throws SQLException;

	void deleteMail(int mno) throws SQLException;

	List<MailVO> readMailList() throws SQLException;

	MailVO readMailByMno(int mno) throws SQLException;

	List<MailVO> readMailListCriteria(Criteria cri) 
			throws SQLException;
	
	List<MailVO> readSearchMailList(SearchCriteria cri) 
			throws SQLException;
	int readSearchMailListCount(SearchCriteria cri)
			throws SQLException;
	MailVO increaseViewCntForReadMail(int mno) throws SQLException;
	
	List<String> getAttach(int mno)throws SQLException;
}













