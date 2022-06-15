package main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== method =====");
		
		/*
		 * <메소드>
		 * 
		 * [문법]
		 * 접근제한자 리턴타입 메소드명(파라미터1, 파라미터2, ...){실행내용}
		 * 
		 * method 이름은 camelCase 로 작성
		 * 가능한 작은 작업단위로 작성 (재사용성, 명확성)
		 * 메소드명은 가능한 동사형태로 작성할 것
		 */
		
		int a = 100;
		
		MethodTest mt = new MethodTest();
//		mt.test01();
//		mt.test02();
//		mt.test03();
//		mt.gugu();
//		mt.printNum(a);
//		mt.plusOne(10);
		
//		MethodReturnTest mrt = new MethodReturnTest();
//		int result = mrt.test01();
//		System.out.println(result);
		
//		MethodFuncTest mft = new MethodFuncTest();
//		int r = mft.testMethod(30);
//		System.out.println(r);
		
		MethodConsumeTest mct = new MethodConsumeTest();
//		mct.testMethod(10);
		mct.plus(20, 30);
		
		
		

	}//main

}//class


































