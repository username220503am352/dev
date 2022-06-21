package main;

import person.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 객체 배열 =====");
		
		Person[] personArr = new Person[5];
		personArr[0] = new Person("심원용", "한국", 20, 'M');
		personArr[1] = new Person("심투용", "두국", 21, 'F');
		personArr[2] = new Person("심삼용", "세국", 22, 'M');
		personArr[3] = new Person("심사용", "네국", 23, 'F');
		personArr[4] = new Person("심오용", "다섯국", 24, 'M');
		
		for(int i = 0; i < personArr.length; i++) {
			System.out.println(personArr[i]);
		}
		
//		System.out.println(personArr[0]);
//		System.out.println(personArr[1]);
//		System.out.println(personArr[2]);
//		System.out.println(personArr[3]);
//		System.out.println(personArr[4]);
		
		
		

	}//main

}//class







































