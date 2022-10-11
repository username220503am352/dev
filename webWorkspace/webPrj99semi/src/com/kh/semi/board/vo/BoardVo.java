package com.kh.semi.board.vo;

public class BoardVo {
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", type=" + type + ", category=" + category + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", hit=" + hit + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", status=" + status + "]";
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String no, String type, String category, String title, String content, String writer, String hit,
			String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.type = type;
		this.category = category;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	private String no;
	private String type;
	private String category;
	private String title;
	private String content;
	private String writer;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
}
