package com.kh.semi.board.vo;

public class CategoryVo {
	
	
	
	public CategoryVo() {
	}
	public CategoryVo(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	private String no;
	private String name;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + "]";
	}
	
	

}

