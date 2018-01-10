package com.spring.domain;

public class UserVO {
	
	private String uid;
	private String upwd;
	private String uname;
	private int upoint;
	private String enabled;
	private String uemail;
	
	public UserVO(){}
	public UserVO(String uid, String upwd, String uname, int upoint,
			String enabled, String uemail) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uname = uname;
		this.upoint = upoint;
		this.enabled = enabled;
		this.uemail = uemail;
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
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upwd=" + upwd + ", uname=" + uname
				+ ", upoint=" + upoint + ", enabled=" + enabled + ", uemail="
				+ uemail + "]";
	}
	
	
	
	
}






