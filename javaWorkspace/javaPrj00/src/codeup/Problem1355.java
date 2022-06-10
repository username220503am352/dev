package codeup;

import java.util.Scanner;

public class Problem1355 {

	public static void main(String[] args) {
		
		// 삼각형 출력하기
		
		//입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//출력
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(i <= j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		

	}//main

}//class











































