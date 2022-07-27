package com.kh.member;

import com.kh.main.Main;
import com.kh.util.InputUtil;

public class MemberController {
	
	/*
	 * 로그인
	 * 
	 * 아이디 , 비번 입력받기
	 * 입력받은 데이터로 디비 조회
	 * 조회 결과에 따라 로직 처리
	 */
	public void login() {
		
		if(Main.loginMember != null) {
			//이미 로그인 O
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		
		System.out.println("----- 로그인 -----");
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();
		
		try {
			MemberVo vo = new MemberDao().login(id, pwd);
			if(vo != null) {
				//로그인 성공
				System.out.println("로그인 성공 !\n\n");
				Main.loginMember = vo;
			}else {
				//로그인 실패
				System.out.println("로그인 실패 !\n\n");
			}
		} catch (Exception e) {
			//로그인 실패
			System.out.println("[에러] 로그인 실패 !\n\n");
			e.printStackTrace();
		}
		
	}

}//class






























