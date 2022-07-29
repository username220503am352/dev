package com.kh.menu;

import com.kh.main.Main;
import com.kh.util.InputUtil;

public class Menu {
	
	public int showMenu() {
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
		
		
		
		return InputUtil.getInt();
	}

}//class
