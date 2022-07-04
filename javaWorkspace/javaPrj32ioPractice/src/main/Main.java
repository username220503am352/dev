package main;

import java.util.Scanner;

public class Main {
	
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("===== 입출력 연습 =====");
		
		//선택지 보여주기
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		//선택값 입력받기
		String input = sc.nextLine();
		
		if("1".equals(input)) {
			//1. 회원가입 처리
			new MemberJoin().join();
		}else if("2".equals(input)){
			//2. 로그인 처리
			new MemberLogin().login();
		}
		
		
		

	}

}
