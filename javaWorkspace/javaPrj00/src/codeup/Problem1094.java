package codeup;

import java.util.Scanner;

public class Problem1094 {

	public static void main(String[] args) {
		
		//출석 2번문제
		//출석 n 번 부를건데, 부른 번호들을 거꾸로 출력
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] memo = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			int num = sc.nextInt();
			memo[i] = num;
		}
		
		for(int i = n-1; i >= 0; i--) {
			System.out.print(memo[i] + " ");
		}
		

	}//main

}//class




































