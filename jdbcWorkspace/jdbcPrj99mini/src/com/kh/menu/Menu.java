package com.kh.menu;

import com.kh.main.Main;
import com.kh.util.InputUtil;

public class Menu {
	
	public int showMenu() {
		
		System.out.println("\n\n----- 메인 메뉴 -----");
		if(Main.loginMember != null) {
			//로그인 O
			System.out.println(Main.loginMember.getNick() + " 님 환영합니다.");
			System.out.println("3. 게시글 작성");
			System.out.println("4. 게시글 목록 조회");
		}else {
			//로그인 X
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 게시글 작성");
			System.out.println("4. 게시글 목록 조회");
		}
		
		System.out.println("9. 프로그램 종료");
		
		
		
		return InputUtil.getInt();
	}//method
	
	
	/*
	 * 게시판 상세조회 관련 메뉴
	 */
	public int showBoardDetailMenu() {
		System.out.print("조회할 글 번호 (0번은 메인메뉴) : ");
		return InputUtil.getInt();
	}

}//class










































