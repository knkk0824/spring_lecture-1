package com.test.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {
	
	private String title;
	private MultipartFile f;
	
	public FileCommand(){}
	public FileCommand(String title, MultipartFile f) {
		super();
		this.title = title;
		this.f = f;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getF() {
		return f;
	}
	public void setF(MultipartFile f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		return "FileCommand [title=" + title + ", f=" + f + "]";
	}
	
	/*toFileVO()*/
	public FileVO toFileVO(){
		FileVO vo=new FileVO();
		vo.setFilename(f.getOriginalFilename());
		vo.setTitle(title);
		
		return vo;
	}	
	
}









