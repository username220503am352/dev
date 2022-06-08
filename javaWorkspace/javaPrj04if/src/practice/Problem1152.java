package practice;

import java.util.Scanner;

public class Problem1152 {

	public static void main(String[] args) {

		/*
		 * 10보다 작은 정수가 입력되면 small 을 출력, 그 이상의 수가 입력되면 big 을 출력하시오.
		 */
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if(x < 10) {
			System.out.println("small");
		}else {
			System.out.println("big");
		}
		
	}

}
