package com.test.dto;

public class MemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_email;
	private String mem_role;
	
	
	public MemberVO(){}
	public MemberVO(String mem_id, String mem_pwd, String mem_name,
			String mem_email, String mem_role) {
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.mem_role = mem_role;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_role() {
		return mem_role;
	}
	public void setMem_role(String mem_role) {
		this.mem_role = mem_role;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pwd=" + mem_pwd
				+ ", mem_name=" + mem_name + ", mem_email=" + mem_email
				+ ", mem_role=" + mem_role + "]";
	}
	
	
	
	
	
}
