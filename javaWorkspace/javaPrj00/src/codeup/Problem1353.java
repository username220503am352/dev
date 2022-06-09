package codeup;

import java.util.Scanner;

public class Problem1353 {

	public static void main(String[] args) {
		
		//삼각형 출력하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//일단 사각형부터
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				//조건판단하여 * 출력
				if(j <= i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		

	}//main

}//class





















































