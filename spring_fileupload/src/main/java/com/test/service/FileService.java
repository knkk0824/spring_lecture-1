package com.test.service;

import java.sql.SQLException;

import com.test.dto.FileVO;

public interface FileService {
	
	void addFile(FileVO vo) throws SQLException;
}
