package practice;

import java.util.Scanner;

public class Problem1154 {

	public static void main(String[] args) {

		/*
		 * 정수 2개를 입력받고,
		 * 큰수 - 작은수 결과를 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x > y) {
			System.out.println(x-y);
		}else {
			System.out.println(y-x);
		}
		
		
	}//main

}//class













