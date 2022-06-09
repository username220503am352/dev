package codeup;

import java.util.Scanner;

public class Problem1402 {

	public static void main(String[] args) {

		//거꾸로 출력하기
		//n개의 데이터를 입력의 역순으로 출력한다.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] ar = new int[n];
		
		//입력받기
		for(int i = 0 ; i < n; ++i) {
			ar[i] = sc.nextInt();
		}
		
		//출력하기
		for(int i = n-1 ; i >= 0; i--) {
			System.out.print(ar[i] + " ");
		}
		
		
		
		
	}//main

}//class





































