package codeup;

import java.util.Scanner;

public class Problem1170 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.print(a);
		System.out.print(b);
		if(c > 9) {
			System.out.print(c);
		}else {
			System.out.print("0" + c);
		}
		

	}//main

}//class




































