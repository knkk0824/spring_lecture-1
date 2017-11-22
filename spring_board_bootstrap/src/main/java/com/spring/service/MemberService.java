package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberService {
	
	List<MemberVO> getMemberList()throws SQLException;
	MemberVO getMemberById(String userid)throws SQLException;
	
	int insertMember(MemberVO member) throws SQLException;
	int updateMember(MemberVO member) throws SQLException;
	int deleteMember(String userid)throws SQLException;
	
	
}









