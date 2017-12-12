package com.test.dao;

import java.sql.SQLException;

import com.test.dto.FileVO;

public interface FileDAO {
	
	void insertFile(FileVO vo) throws SQLException;
}
