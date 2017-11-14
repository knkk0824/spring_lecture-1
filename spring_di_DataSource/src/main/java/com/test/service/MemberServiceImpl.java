package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.test.dao.MemberDAO;
import com.test.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memDao;
	public void setMemDao(MemberDAO memDao){
		this.memDao=memDao;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		
		List<MemberVO> memberList=memDao.getMemberList();
				
		return memberList;
	}
	

}






