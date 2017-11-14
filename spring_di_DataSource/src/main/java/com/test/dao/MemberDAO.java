package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> getMemberList()throws SQLException;
}
