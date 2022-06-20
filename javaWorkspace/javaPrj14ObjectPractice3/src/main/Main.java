package main;

import person.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 연습 =====");
		
		//사람 2명 만들기
		Person p1 = new Person("심원용", 20, 'M');
		
		Person p2 = new Person("심투용", 20, 'F');
		p2.setName("심투용");
		
		p1.sayHello();
		p2.sayHello();

	}//main

}//class















