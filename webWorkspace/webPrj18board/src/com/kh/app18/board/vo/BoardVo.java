package com.kh.app18.board.vo;

public class BoardVo {
	
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + "]";
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
	public BoardVo() {
		super();
	}
	public BoardVo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	private String title;
	private String content;

}
