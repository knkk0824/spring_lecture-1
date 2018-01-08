package com.spring.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MailDAO;
import com.spring.domain.MailVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;
import com.spring.service.MailService;

public class MailServiceImpl implements MailService {

	private MailDAO mailDAO;
	public void setMailDAO(MailDAO mailDAO){
		this.mailDAO=mailDAO;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,
			       rollbackFor={Exception.class})
	@Override
	public void createMail(MailVO mail) throws SQLException {
		mailDAO.insertMail(mail);
		
		String[]files = mail.getFiles();
		
		int bno=mailDAO.selectMaxMno();
		
		if(files==null) return;
		for(String fileName:files){
			mailDAO.insertAttach(fileName,bno);
		}
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,
			       rollbackFor={Exception.class})
	@Override
	public void deleteMail(int bno) throws SQLException {
		mailDAO.deleteMail(bno);
		mailDAO.deleteAttach(bno);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
	@Override
	public List<MailVO> readMailList() throws SQLException {
		List<MailVO> mailList=mailDAO.selectMailList();
		return mailList;
	}

	@Override
	public MailVO readMailByMno(int bno) throws SQLException {
		MailVO mail=mailDAO.selectMailByMno(bno);
		return mail;
	}

	@Override
	public List<MailVO> readMailListCriteria(Criteria cri)
			throws SQLException {
		List<MailVO> mailList=mailDAO.selectMailListCriteria(cri);
		return mailList;
	}

	@Override
	public List<MailVO> readSearchMailList(SearchCriteria cri)
			throws SQLException {
		List<MailVO> mailList=mailDAO.selectSearchList(cri);
		return mailList;
	}

	@Override
	public int readSearchMailListCount(SearchCriteria cri) throws SQLException {
		int countList=mailDAO.selectSearchListCount(cri);
		return countList;
	}

	@Override
	public MailVO increaseViewCntForReadMail(int bno) throws SQLException {
		mailDAO.increaseViewCnt(bno);
		MailVO mail=mailDAO.selectMailByMno(bno);		
		return mail;		
	}

	@Override
	public List<String> getAttach(int bno) throws SQLException {
		List<String> fileNames=mailDAO.selectAttach(bno);
		return fileNames;
	}

}



