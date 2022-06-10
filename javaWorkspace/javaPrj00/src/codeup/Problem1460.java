package codeup;

import java.util.Scanner;

public class Problem1460 {

	public static void main(String[] args) {
		
		//2차원 배열 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		
		int x = 1;
		
		for(int i = 0 ; i < n; ++i) {
			for(int j = 0 ; j < n; ++j) {
				a[i][j] = x++;
			}
		}
		
		//출력
		for(int i = 0; i < n; ++i) {
			for(int j = n-1; j >= 0; j--) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
	}//main

}//class



























