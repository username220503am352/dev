package main;

import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		
		System.out.println("====입력 결과 =====");
		System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
		
		
		
		
	}//main

}//class



