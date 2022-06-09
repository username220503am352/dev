package codeup;

import java.util.Scanner;

public class Problem1403 {

	public static void main(String[] args) {

		//배열 두번 출력하기
		//정수를 n개 입력받고, n개의 정수들을 2번 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//n개의 변수 만들기
		int[] ar = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(ar[i]);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(ar[i]);
		}
		 
		
		
	}//main

}//class





































