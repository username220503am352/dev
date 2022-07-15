package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("===== JDBC TEST =====");
		
		Scanner sc = new Scanner(System.in);
		EmployeeController ec = new EmployeeController();
		
		System.out.println("1. 전체 사원 조회");
		System.out.println("2. 사원 검색(아이디)");
		
		String input = sc.nextLine();
		
		switch(input) {
		case "1" : 
			ec.selectEmployeeList(); break;
		case "2" : 
			System.out.print("사원번호:");
			String empId = sc.nextLine();
			ec.selectEmployeeById(empId); break;
		}
		
		
		
	}//main

}//class






















