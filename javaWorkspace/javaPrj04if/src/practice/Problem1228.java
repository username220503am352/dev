package practice;

import java.util.Scanner;

public class Problem1228 {

	public static void main(String[] args) {
		/*
		키와 몸무게를 입력받고 (정수 X, 실수O)
		비만도 수치를 계산하여,
		아래 표를 참고하여 비만도 등급을 출력
		
		표준몸무게 = 	(실제 키 - 100) * 0.9
		비만도 = 	(실제 몸무게 - 표준몸무게)  * 100 / 표준 몸무게
		
		등급	비만도 수치
		10이하	정상
		10초과 20이하	과체중
		20 초과	비만
		 */
		
		//1. 키, 몸무게 입력받기 (실수 double)
		Scanner sc = new Scanner(System.in);
		
		double height = sc.nextDouble();
		double weight = sc.nextDouble();
		
		//2. 표준 몸무게 계산
		double sw = (height - 100) * 0.9;
		
		//3. 비만도 수치 계산
		double bmi = (weight - sw)  * 100 / sw;
		
		//4. 수치에 따라 등급 출력
		if(bmi <= 10) {
			System.out.println("정상");
		}else if(bmi <= 20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}
		
	}//main

}//class

















