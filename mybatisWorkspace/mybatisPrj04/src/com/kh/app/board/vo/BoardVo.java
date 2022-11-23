package com.kh.app.board.vo;

import java.sql.Timestamp;

public class BoardVo {
	
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
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public BoardVo(String title, String content, Timestamp enrollDate) {
		super();
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + "]";
	}
	private String title;
	private String content;
	private Timestamp enrollDate;

}
