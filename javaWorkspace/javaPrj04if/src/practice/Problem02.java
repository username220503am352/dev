package practice;

import java.util.Scanner;

public class Problem02 {

	public static void main(String[] args) {
		
		/*
		 * 1. 정수 하나를 입력받고,
		 * 2. 입력받은 정수가 홀수 인지, 짝수 인지 판단
		 */
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
//		System.out.println(x);
		
		if(x % 2 == 1) {
			System.out.println("홀");
		}else {
			System.out.println("짝");
		}

	}//main

}//class











