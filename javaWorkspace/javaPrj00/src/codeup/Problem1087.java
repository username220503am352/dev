package codeup;

import java.util.Scanner;

public class Problem1087 {

	public static void main(String[] args) {
		
		//1부터 누적해서 더하기, 입력값 나오면 그만
		
		//입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//1부터 누적해서 더하기
		int sum = 0;
		for(int i = 1 ; true; ++i) {
			sum += i;	//위랑 같은 코드
			//sum 이 n이상이면, 반복문 그만
			if(sum >= n) {
				break;
			}
		}
		System.out.println(sum);
		//입력값 나오면 그만
		//현재까지 누적한 값 출력
		
		
		
		
		
		
		

	}//main

}//class























