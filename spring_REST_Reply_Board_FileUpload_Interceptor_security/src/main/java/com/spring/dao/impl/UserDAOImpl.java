package com.spring.dao.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.spring.dao.UserDAO;
import com.spring.domain.UserVO;

public class UserDAOImpl implements UserDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	@Override
	public UserVO selectUserById(String uid) throws SQLException {
		UserVO user=(UserVO)sqlSession.selectOne("UserMapper.selectUserById",uid);
		System.out.println(user);
		return user;
	}

}
