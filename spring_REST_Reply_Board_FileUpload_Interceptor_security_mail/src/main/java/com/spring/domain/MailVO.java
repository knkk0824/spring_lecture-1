package com.spring.domain;

import java.util.Arrays;
import java.util.Date;

public class MailVO {
	private int mno;
	private String from;
	private String to;
	private String title;
	private String content;
	private Date sendDate;
	private String uid;
	
	private String[] files;
	
	public MailVO(){}
	public MailVO(int mno, String from, String to, String title,
			String content, Date sendDate, String uid, String[] files) {
		super();
		this.mno = mno;
		this.from = from;
		this.to = to;
		this.title = title;
		this.content = content;
		this.sendDate = sendDate;
		this.uid = uid;
		this.files = files;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
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
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "MailVO [mno=" + mno + ", from=" + from + ", to=" + to
				+ ", title=" + title + ", content=" + content + ", sendDate="
				+ sendDate + ", uid=" + uid + ", files="
				+ Arrays.toString(files) + "]";
	}
	
	
		
}
