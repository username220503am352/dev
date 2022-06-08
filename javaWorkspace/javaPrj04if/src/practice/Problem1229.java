package practice;

import java.util.Scanner;

public class Problem1229 {

	public static void main(String[] args) {
		/*
		 https://codeup.kr/problem.php?id=1229
		링크의 표를 참고하여
		비만도 를 계산하고, 
		비만도 등급을 출력
		 */

		//1. 키, 몸무게 입력받기 (실수 double)
		Scanner sc = new Scanner(System.in);
		
		double height = sc.nextDouble();
		double weight = sc.nextDouble();
		
		//2. 표준 몸무게 계산
		double sw;
		if(height < 150) 
		{
			// (실제 키 - 100)
			sw = height - 100;
		}
		else if(height < 160) 
		{
			// (실제 키 - 150) /2 + 50
			sw = (height - 150) /2 + 50;
		}
		else 
		{
			// (실제 키 - 100) * 0.9
			sw = (height - 100) * 0.9;
		}
		
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
