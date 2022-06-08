package main;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		
		System.out.println("===== 반복문 =====");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//입력받은 숫자에 10을 곱한 값 출력
			int x = sc.nextInt();
			
			//단, 음수를 입력받으면 아무 값도 출력하지 않는다.
			if(x < 0) {
				System.out.println("컨티뉴 ~~~~~");
				continue;
			}
			
			System.out.println(x*10);
			
		}

	}//main

}//class






















