package codeup;

import java.util.Scanner;

public class Problem1093 {

	public static void main(String[] args) {
		
		//우리반 23명 (1~23)
		//출석을 n 번 부를건데,
		//각 학생 출석불린 횟수 출력

		//배열 만들기
		int[] studentArr = new int[24];
		
		//출석 번호 받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			int num = sc.nextInt();
			studentArr[num] += 1;
		}
		
		for(int i = 1; i <= 23; i++) {
			System.out.print(studentArr[i] + " ");
		}
		
		
		

	}//main

}//class




































