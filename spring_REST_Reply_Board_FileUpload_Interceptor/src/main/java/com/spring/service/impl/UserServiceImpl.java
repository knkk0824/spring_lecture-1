package com.spring.service.impl;

import java.sql.SQLException;

import com.spring.dao.UserDAO;
import com.spring.domain.UserVO;
import com.spring.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	@Override
	public UserVO login(String uid)throws SQLException{
		UserVO user=userDAO.selectUserById(uid);
		return user;
	}
}








