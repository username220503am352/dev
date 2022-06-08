package codeup;

import java.util.Scanner;

public class Problem1171 {

	public static void main(String[] args) {
		
		//1171
		//다른 방법으로 푸셔도 괜찮습니다 ~ 정답만 맞추시면 됩니다 ㅎㅎ
		Scanner sc = new Scanner(System.in);
		
		int grade = sc.nextInt();
		int classNo = sc.nextInt();
		int num = sc.nextInt();
		
		System.out.print(grade);
		
		if(classNo >= 10) {
			System.out.print(classNo);
		}else {
			System.out.print("0" + classNo);
		}
		
		if(num >= 100) {
			System.out.print(num);
		}else if(num >= 10) {
			System.out.print("0" + num);
		}else {
			System.out.print("00" + num);
		}
		
	}//main

}//class

































