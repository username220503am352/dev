package var;

public class Main {

	public static void main(String[] args) {

		/*
		 * 변수
		 * 
		 * 변수 ? 변하는 수  
		 * 
		 * [문법]
		 * 변수타입 변수명 = 값;
		 * 
		 * [타입]
		 * boolean : 논리 (true / false)
		 * 
		 * char : 문자
		 * String : 문자열
		 * 
		 * (1byte) byte : 정수 : 표현범위 : -128 ~ +127 (256)
		 * (2byte) short : 정수 : 표현범위 :  -3만 ~ 3만 (65536)
		 * (4byte) int : 정수 : 표현범위 : -21억 ~ +21억 (42억)
		 * (8byte) long : 정수 : 표현범위 : 넓~~~음
		 * 
		 * (4byte) float : 실수 : 표현범위 : 소수점 아래 ?번째 자리
		 * (8byte) double : 실수 : 표현범위 : 소수점 아래 ?번째 자리
		 * 
		 * 오버플로우 : 한바퀴 도는거
		 * 
		 * */
		
		//문자 (문자하나)
		char abc = 's';
		System.out.println(abc);
		
		//문자열 (문자여러개)
		String sss = "xzcd1231!@#!@#23sfkjlashdfkjhsadlkjfhdfasl;dhflkjsadf";
		System.out.println(sss);
		
		//참or거짓
		boolean b = true;
		System.out.println(b);
		
		//정수(기본값 : int)
		byte by = 1;
		short s = 2;
		int age = 20;
		long l = 100L; //숫자 뒤에 붙는 L 대소문자 상관 없음
		
		//실수(기본값 : double)
		double height = 183.7;
		float weight = 88.8F;//숫자 뒤에 붙는 F 대소문자 상관 없음
		
		
		
	}

}







