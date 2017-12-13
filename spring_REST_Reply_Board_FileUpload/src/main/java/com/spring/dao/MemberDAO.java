package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberDAO {
	
	List<MemberVO> selectMemberList()throws SQLException;
	MemberVO selectMemberById(String userid)throws SQLException;
	
	int insertMember(MemberVO member)throws SQLException;
	int updateMember(MemberVO member)throws SQLException;
	int deleteMember(String userid)throws SQLException;
}








