package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.test.dto.MemberVO;

public interface MemberService {
	
	List<MemberVO> getMemberList()throws SQLException;
	
}
