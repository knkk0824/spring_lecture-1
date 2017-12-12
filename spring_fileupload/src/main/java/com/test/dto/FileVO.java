package com.test.dto;

public class FileVO {
	private int fno;
	private String title;
	private String uploadpath;
	private String filename;
	private int filesize;
	
	public FileVO(){}
	public FileVO(int fno, String title, String uploadpath, String filename,
			int filesize) {
		super();
		this.fno = fno;
		this.title = title;
		this.uploadpath = uploadpath;
		this.filename = filename;
		this.filesize = filesize;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	@Override
	public String toString() {
		return "FileVO [fno=" + fno + ", title=" + title + ", uploadpath="
				+ uploadpath + ", filename=" + filename + ", filesize="
				+ filesize + "]";
	}
	
	
	
	
}
