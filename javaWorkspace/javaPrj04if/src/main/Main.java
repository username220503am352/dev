package main;

public class Main {

	public static void main(String[] args) {
		
		//제어문 > 조건문
		
		// if
		// else
		// else if
		// 조건식
		
		/*
		 * [문법]
		 * if(조건식){실행할 내용}
		 * else if(조건식){실행할 내용}
		 * else {실행할 내용}
		 * 
		 * 조건에 맞으면, 해당 블록 실행
		 * 조건에 맞지 않으면, 다음 블록으로 넘어감
		 * */
		
		// 어떤 값이, 양수인지 음수인지 0인자 판단 가능
		
		System.out.println("===== 제어문 테스트 =====");
		
		int x = 0;
		
		if(x > 0)
		{                   
			System.out.println("x 는 양수입니다.");
		}
		else if(x == 0) 
		{
			System.out.println("x 는 0입니다.");
		}
		else 
		{
			System.out.println("x 는 음수입니다.");
		}
		
	}

}








