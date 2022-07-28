package com.kh.member;

public class MemberVo {
	
	public MemberVo() {
		
	}

	public MemberVo(String no, String id, String pwd, String nick) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	private String no;
	private String id;
	private String pwd;
	private String pwd2;
	private String nick;
	
	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + "]";
	}
	
	

}

