package com.kh.app;

public class MemberVo {
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", nick=" + nick + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public MemberVo(String id, String nick) {
		super();
		this.id = id;
		this.nick = nick;
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String nick;

}
