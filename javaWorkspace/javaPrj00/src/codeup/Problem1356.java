package codeup;

import java.util.Scanner;

public class Problem1356 {

	public static void main(String[] args) {
		
		//길이가 n인 사각형 출력하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				//첫번쨰 행,마지막 행, 첫번째 열, 마지막 열
				if(i == 1 || i == n || j == 1 || j == n) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		

	}//main

}//class



























