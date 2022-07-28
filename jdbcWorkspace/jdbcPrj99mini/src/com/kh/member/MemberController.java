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
		
	}//login
	
	
	/*
	 * 회원가입
	 * 
	 * 데이터 입력받기
	 * - 아이디 유효성 검사
	 * - 비밀번호 유효성 검사
	 * - 아이디 중복 검사
	 * 
	 * DB 에 insert 
	 * 
	 * insert 결과에 따라 다음 작업 진행
	 */
	public void join() {
		System.out.println("----- 회원가입 -----");
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();
		System.out.print("비밀번호 확인 : ");
		String pwd2 = InputUtil.sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = InputUtil.sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setNick(nick);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		
		int result = new MemberService().join(vo);
		
		//실행 결과에 따른 응답
		if(result == 1) {
			System.out.println("회원가입 성공 !");
		}else {
			System.out.println("[ERROR:" + result + "] 회원가입 실패 ...");
		}
	}

}//class






























