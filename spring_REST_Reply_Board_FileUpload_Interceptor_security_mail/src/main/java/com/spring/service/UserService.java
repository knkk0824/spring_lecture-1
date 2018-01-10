package com.spring.service;

import java.sql.SQLException;

import com.spring.domain.UserVO;

public interface UserService {
	
	UserVO login(String uid)throws SQLException;	
	
	UserVO getUserByID(String uid)throws SQLException;
}
