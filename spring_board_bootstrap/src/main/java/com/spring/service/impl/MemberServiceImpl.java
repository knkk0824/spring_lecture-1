package com.spring.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList=memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public MemberVO getMemberById(String userid) throws SQLException {
		MemberVO member=memberDAO.selectMemberById(userid);
		return member;
	}

	@Override
	public int insertMember(MemberVO member) throws SQLException {
		int result=memberDAO.insertMember(member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException {
		int result=memberDAO.updateMember(member);
		return result;
	}

	@Override
	public int deleteMember(String userid) throws SQLException {
		int result=memberDAO.deleteMember(userid);
		return result;
	}

}
