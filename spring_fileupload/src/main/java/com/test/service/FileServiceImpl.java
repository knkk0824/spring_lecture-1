package com.test.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.test.dao.FileDAO;
import com.test.dto.FileVO;

public class FileServiceImpl implements FileService {
	
	
	private FileDAO dao;
	public void setDao(FileDAO dao){
		this.dao=dao;
	}
	
	
	@Override
	public void addFile(FileVO vo) throws SQLException {
		dao.insertFile(vo);

	}

}
