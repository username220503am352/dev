package com.kh.app.board.vo;

public class SearchVo {
	
	private String category;
	private String keyword;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchVo(String category, String keyword) {
		super();
		this.category = category;
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchVo [category=" + category + ", keyword=" + keyword + "]";
	}
	
	

}
