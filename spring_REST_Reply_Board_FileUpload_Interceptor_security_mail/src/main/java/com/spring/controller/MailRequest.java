package com.spring.controller;

import java.util.Arrays;
import java.util.Date;

public class MailRequest {	
	
	private String title;
	private String content;
	private String from;
	private String to;
	private String[] files;
	
	
	public MailRequest(){}
	
	public MailRequest(String title, String content, String from, String to,
			String[] files) {
		super();
		this.title = title;
		this.content = content;
		this.from = from;
		this.to = to;
		this.files = files;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	
	@Override
	public String toString() {
		return "MailVO [title=" + title + ", content=" + content + ", from="
				+ from + ", to=" + to + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
		
}








