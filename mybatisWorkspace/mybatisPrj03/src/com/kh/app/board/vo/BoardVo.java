package com.kh.app.board.vo;

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
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + "]";
	}
	public BoardVo(String title, String content, String enrollDate) {
		super();
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String title;
	private String content;
	private String enrollDate;

}
