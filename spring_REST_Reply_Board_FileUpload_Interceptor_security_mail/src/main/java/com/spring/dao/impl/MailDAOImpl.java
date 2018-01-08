package com.spring.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dao.MailDAO;
import com.spring.domain.MailVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public class MailDAOImpl implements MailDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	private static final String NAMESPACE = "MailMapper";

	@Override
	public void insertMail(MailVO mail) throws SQLException {
		sqlSession.update(NAMESPACE + ".insertMail", mail);
	}

	@Override
	public void deleteMail(int mno) throws SQLException {
		sqlSession.update(NAMESPACE + ".deleteMail", mno);
	}

	@Override
	public List<MailVO> selectMailList() throws SQLException {
		List<MailVO> mailList = sqlSession.selectList(NAMESPACE
				+ ".selectMailList", null);
		return mailList;
	}

	@Override
	public MailVO selectMailByMno(int mno) throws SQLException {
		MailVO mail =(MailVO)sqlSession.selectOne(NAMESPACE + ".selectMailByMno",
				mno);
		return mail;
	}

	@Override
	public List<MailVO> selectMailListCriteria(Criteria cri)
			throws SQLException {

		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<MailVO> mailList = sqlSession.selectList(NAMESPACE
				+ ".selectMailList", null, rowBounds);
		return mailList;
	}

	@Override
	public List<MailVO> selectSearchList(SearchCriteria cri) {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<MailVO> mailList = sqlSession.selectList(NAMESPACE
				+ ".selectSearchMailList", cri, rowBounds);
		return mailList;
	}

	@Override
	public int selectSearchListCount(SearchCriteria cri) throws SQLException {
		int listCount=(Integer)sqlSession.selectOne(
				NAMESPACE+".selectSearchMailCount",cri);
		return listCount;
	}
	
	@Override
	public void increaseViewCnt(int mno) throws SQLException{
		sqlSession.update(NAMESPACE+".increaseViewCnt",mno);
	}

	@Override
	public void insertAttach(String fullName,int mno) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("fullname", fullName);
		paramMap.put("mno", mno);
		
		sqlSession.update(NAMESPACE+".insertAttach",paramMap);		
	}
	
	@Override
	public int selectMaxMno()throws SQLException{
		return (Integer)sqlSession.selectOne(NAMESPACE+".selectMaxMno",null);
	}

	@Override
	public List<String> selectAttach(int mno) throws SQLException {
		List<String> files=sqlSession.selectList(NAMESPACE+".selectAttach",
				mno);
		return files;
	}	

	@Override
	public void deleteAttach(int mno) throws SQLException {
		sqlSession.update(NAMESPACE+".deleteAttach",mno);
	}

	
	

}









