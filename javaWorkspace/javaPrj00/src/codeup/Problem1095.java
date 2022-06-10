package codeup;

import java.util.Scanner;

public class Problem1095 {

	public static void main(String[] args) {
		
		//출석3 (가장 빠른 번호 출력)
		
		//기록할 메모장 만들기
		int[] memo = new int[24];
		
		Scanner sc = new Scanner(System.in);
		//n을 입력받기
		int n = sc.nextInt();
		//n개의 출석번호 입력받기
		for(int i = 0 ; i < n; i++) {
			int num = sc.nextInt();
			memo[num] = 1;
		}
		
		//제일 빠른 번호 출력
		for(int i = 1; i <= 23; i++) {
//			만약에, memo[i] == 1 라면?
//					i 번 학생이 가장 빠른 번호
			if(memo[i] == 1) {
				System.out.println(i);
				break;
			}
		}
		
		

	}//main

}//class






































