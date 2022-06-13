package codeup;

import java.util.Scanner;

public class Problem1407 {

	public static void main(String[] args) {
		
		//문자열 받아서 공백 제거하고 출력
		
		//문자열 받기
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		//문자열 출력 (공백제거)
		for(int i = 0 ; i < s.length(); i++) {
			if(s.charAt(i) != ' ') {
				System.out.print(s.charAt(i));
			}
		}

	}//main

}//class




































