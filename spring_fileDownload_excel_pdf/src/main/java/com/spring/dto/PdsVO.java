package com.spring.dto;

import java.util.Date;

public class PdsVO {
	String fileName;
	Date indate;
	String writer;
	String content;
	
	public PdsVO(){};
	public PdsVO(String fileName, Date indate, String writer, String content) {
		super();
		this.fileName = fileName;
		this.indate = indate;
		this.writer = writer;
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PdsVO [fileName=" + fileName + ", indate=" + indate
				+ ", writer=" + writer + ", content=" + content + "]";
	}
	
	
	
	
	
}
