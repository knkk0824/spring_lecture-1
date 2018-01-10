package com.spring.controller;

import java.util.Arrays;
import java.util.Date;

import com.spring.domain.MailVO;

public class MailRequest {	
	
	private String uid;
	private String title;
	private String content;
	private String from;
	private String to;
	private String[] files;
	
	public MailRequest(){}
	public MailRequest(String uid, String title, String content, String from,
			String to, String[] files) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.from = from;
		this.to = to;
		this.files = files;
	}

	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public MailVO toMailVO(){
		MailVO mail=new MailVO();
		mail.setUid(uid);
		mail.setContent(content);
		mail.setFiles(files);
		mail.setFrom(from);
		mail.setTitle(title);
		mail.setTo(to);
		return mail;
	}
	
		
}








