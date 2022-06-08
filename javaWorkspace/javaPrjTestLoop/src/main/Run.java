package main;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		// 가위바위보 게임
		System.out.println("===== 가위바위보 게임=====");
		
		//도구 생성
		Scanner sc = new Scanner(System.in);
		
		//사용자가 뭐 낼지 입력 받기
		System.out.print("가위,바위,보 중에 하나를 선택하세요 : ");
		String user = sc.nextLine();
		
		//컴퓨터의 패 선택
		//랜던숫자 뽑기 (1~3)
		int r = (int) Math.random()*3+1;
		//랜덤 값에 따라 컴퓨터 패 선택하기
		String com = "";
		if(r == 1) {
			com = "가위";
		}else if(r == 2) {
			com = "바위";
		}else if(r == 3) {
			com = "보";
		}
		
		//승패 판단
		if(com.equals("가위")) 
		{
			if(user.equals("가위")) {
				System.out.println("비김");
			}else if(user.equals("바위")) {
				System.out.println("사용자 승리!");
			}else if(user.equals("보")) {
				System.out.println("컴퓨터 승리!");
			}
		}
		else if(com.equals("바위")) 
		{
			if(user.equals("가위")) {
				System.out.println("컴퓨터 승리 !");
			}else if(user.equals("바위")) {
				System.out.println("비김");
			}else if(user.equals("보")) {
				System.out.println("사용자 승리!");
			}
		}
		else if(com.equals("보")) 
		{
			if(user.equals("가위")) {
				System.out.println("사용자 승리!");
			}else if(user.equals("바위")) {
				System.out.println("컴퓨터 승리!");
			}else if(user.equals("보")) {
				System.out.println("비김!");
			}
		}
		
	}//main

}//class

















