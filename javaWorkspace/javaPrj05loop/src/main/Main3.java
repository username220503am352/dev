package main;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		System.out.println("===== 반복문 =====");
		
		//for
		//while, 초기식, 조건식, 증감식
		
		//사용자로부터 입력받은 숫자 만큼
		//hello world 출력
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		//짝수번째 헬로월드 안나오게
		for(int i = 0 ; i < x; ++i) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i + "번 째 hello world");
		}

	}//main

}//class
















