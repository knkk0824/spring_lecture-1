package com.spring.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dao.MemberDAO;
import com.spring.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="MemberMapper.";
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList
		=sqlSession.selectList(NAMESPACE+"selectMemberList",null);
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String userid) throws SQLException {
		MemberVO member=
				sqlSession.selectOne(NAMESPACE+"selectMemberById",userid);
		return member;
	}

	@Override
	public int insertMember(MemberVO member) throws SQLException {
		int result=sqlSession.update(NAMESPACE+"insertMember",member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException {
		int result=sqlSession.update(NAMESPACE+"updateMember",member);
		return result;
	}

	@Override
	public int deleteMember(String userid) throws SQLException {
		int result=sqlSession.update(NAMESPACE+"deleteMember",userid);
		return result;
	}

}
