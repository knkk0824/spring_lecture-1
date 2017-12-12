package com.test.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.dto.FileVO;

public class FileDAOImpl implements FileDAO{
	
	private SqlSession session;
	public void setSession(SqlSession session){
		this.session=session;
	}
	
	@Override
	public void insertFile(FileVO vo) throws SQLException {
		session.update("FileUploadMapper.insertFile",vo);		
	}

}
