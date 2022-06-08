package codeup;

import java.util.Scanner;

public class Problem1252 {

	public static void main(String[] args) {
		
		//a 부터 b 까지 출력하기
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//큰 수 구분
		if(a < b) {
			// a < b 
			for(int i = a; i <= b; i++) 
			{
				System.out.println(i);
			}
		}else {
			// a > b 
			for(int i = b; i <= a; i++) 
			{
				System.out.println(i);
			}
		}
		
		
		
		
		

	}//main

}//class




































