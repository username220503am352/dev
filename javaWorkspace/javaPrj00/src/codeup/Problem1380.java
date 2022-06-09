package codeup;

import java.util.Scanner;

public class Problem1380 {

	public static void main(String[] args) {
		
		//두 주사위의 합이 n이 되도록 하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//모든 경우의 수 구하기
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {
				
				if(i+j == n) {
					System.out.println(i + " " + j);
				}
				
			}
		}
		
		//해당 경우에서, 합이 n이 되면
		//현재 주사위 값 출력
		

	}//main

}//class




































