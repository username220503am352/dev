package main;

import person.Person;

public class Main {

	public static void main(String[] args) {
		
		final double PI_VALUE = 3.14;
		
		System.out.println("===== Object Practice =====");
		
		Person p1 = new Person();
		
		p1.setAddr("테헤란로123길");
		p1.setAge(20);
		p1.setBirth(20021231);
		p1.setGender('M');
		p1.setName("심원용");
		
		//출력
		System.out.println(p1.getAddr());
		System.out.println(p1.getAge());
		System.out.println(p1.getBirth());
		System.out.println(p1.getGender());
		System.out.println(p1.getName());
		
		
		

	}//main

}//class































