package com.spring.dao;

import java.sql.SQLException;

import com.spring.domain.UserVO;

public interface UserDAO {
	
	UserVO selectUserById(String uid)throws SQLException;
}
