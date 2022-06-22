package main;

import java.util.Scanner;

import emp.Employee;

public class Main {

	public static void main(String[] args) {
		
		//햄버거 주문받기
		
		//메뉴판 보여주기
		Employee emp = new Employee();
		emp.showMenu();
		
		//입력받기
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		
		//입력받은 내용 출력
		emp.sayMenu(menu);

	}//main
	
}//class














