package main;

import student.Student;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("=== 오브젝트 ===");
		
		//학생 1명 만들고
		//데이터 집어넣고
		//데이터 출력
		Student s = new Student();
		s.name = "심원용";
		s.age = 20;
		s.score = 100;
		
		System.out.println("s.name : " + s.name);
		System.out.println("s.age : " + s.age);
		System.out.println("s.score : " + s.score);
		
		Student s2 = new Student();
		s2.name = "심투용";
		s2.age = 21;
		s2.score = 200;
		
		System.out.println("s2.name : " + s2.name);
		System.out.println("s2.age : " + s2.age);
		System.out.println("s2.score : " + s2.score);
		
		//메소드 확인
		s.hello();
		s.student();
		
		
		
		

	}//main

}//class
































