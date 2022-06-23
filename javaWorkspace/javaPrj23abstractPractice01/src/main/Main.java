package main;

import car.Car;
import car.benz.Glc;
import car.benz.Gls;
import car.tesla.Model3;
import car.tesla.ModelX;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 추상메소드 연습 =====");
		
		Car[] carArr = new Car[4];
		carArr[0] = new Model3();
		carArr[1] = new ModelX();
		carArr[2] = new Glc();
		carArr[3] = new Gls();
		// new Car(); //추상클래스라서 객체 생성 불가능
//		for(int i = 0 ; i < 4; ++i) {
//			carArr[i].go();
//		}
		
		//향상된 for문
		for(Car x : carArr) {
			x.go();
		}

	}//main

}//class


























