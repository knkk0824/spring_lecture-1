package com.spring.domain;

public class UserVO {
	
	private String uid;
	private String upwd;
	private String uname;
	private int upoint;
	
	public UserVO(){}
	public UserVO(String uid, String upwd, String uname, int upoint) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uname = uname;
		this.upoint = upoint;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upwd=" + upwd + ", uname=" + uname
				+ ", upoint=" + upoint + "]";
	}
	
	
}






