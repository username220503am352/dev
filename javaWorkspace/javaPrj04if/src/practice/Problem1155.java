package practice;

import java.util.Scanner;

public class Problem1155 {

	public static void main(String[] args) {
		
		/*
		 * 정수 하나 입력받고,
			7의 배수이면 7의배수 하고 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if(x%7 == 0) {
			System.out.println("7의 배수입니다.");
		}else {
			System.out.println("아님");
		}

	}//main

}//class















