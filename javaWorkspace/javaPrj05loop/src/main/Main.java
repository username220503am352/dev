package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 반복문 =====");
		
		/*
		 * 반복문
		 * 
		 * while(조건식){실행내용}
		 * 
		 * do{실행내용} while(조건식);
		 * 
		 * for(초기식;조건식;증감식){실행내용}
		 * 
		 * break : 반복문 탈출
		 * continue : 반복문 처음으로 돌아감
		 */
		
		
		//0. 입력받기 위한 도구 생성
		Scanner sc = new Scanner(System.in);
		while(true) {
			//숫자 입력받기
			
			//1. 실제입력받기
			int x = sc.nextInt();
			//숫자 출력하기
			System.out.println("입력받은 x의 값 ::: " + x);
			//만약에, 음수가 입력되면 ? 반복문 종료하기
			if(x < 0) {
				break;
			}
		}
		
		

	}//main

}//class




























