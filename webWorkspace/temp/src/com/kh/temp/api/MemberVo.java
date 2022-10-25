package com.kh.temp.api;

public class MemberVo {
	
	
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String pwd;

}
