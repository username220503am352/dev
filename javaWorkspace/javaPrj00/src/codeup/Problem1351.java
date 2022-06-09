package codeup;

import java.util.Scanner;

public class Problem1351 {

	public static void main(String[] args) {
		
		//구구단 출력하기 2
		//시작 단, 끝 단 입력받아서 출력
		
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		for(int i = start; i <= end; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
		

	}

}
