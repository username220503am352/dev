package codeup;

import java.util.Scanner;

public class Problem1212 {

	public static void main(String[] args) {
		
		//1212
		
		//제일긴거 < 나머지두개합
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//c가 제일 긴 경우
		if(c > a && c > b) 
		{
			if(a+b > c) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		else if(b > a && b > c) 
		{
			if(a+c > b) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		else
		{
			if(b+c > a) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		
		
		int x = 95;
		int y = 1;
		System.out.print(x);
		System.out.print(" ");
		System.out.print(y);
		
		System.out.print(x + " " + y);
		

	}//main

}//class







































