package main;

import car.Car;
import car.GreenCar;
import car.RedCar;
import car.WhatCar;

public class Main {

	public static void main(String[] args) {
		
		Car c1 = new RedCar();
		c1.setBrand("애플");
		c1.setColor("빨강");
		c1.setSpeed(100);
		
		Car c2 = new GreenCar();
		c2.setBrand("구글");
		c2.setColor("파랑");
		c2.setSpeed(200);
		
		Car c3 = new WhatCar();
		c3.setBrand("엘지");
		c3.setColor("검정");
		c3.setSpeed(300);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		c1.go();
		c2.go();
		c3.go();
		

	}//main

}//class


























