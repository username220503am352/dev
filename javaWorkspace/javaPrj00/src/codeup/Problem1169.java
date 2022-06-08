package codeup;

import java.util.Scanner;

public class Problem1169 {

	public static void main(String[] args) {
		
		//나이계산2 (2012년 기준)
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		
		int year = 2012 - age +1;
		
		int gender = 0;
		
		if(year < 2000) {
			// 1 출력
			gender = 1;
		}else {
			// 3 출력
			gender = 3;
		}
		
		
		System.out.print(year%100 + " " + gender);
		
		
		
		

	}//main

}//class
