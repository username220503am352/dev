package main;

public class MethodTest {

	public void test01(){
		System.out.println("테스트01 메소드 호출됨 ...");
	}
	
	public void test02() {
		System.out.println("테스트02 메소드 호출됨 ...");
	}
	
	public void test03() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	}
	
	public void gugu() {
		for(int i = 2; i <= 9; ++i) {
			for(int j = 1; j<= 9; ++j) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
	}
	
	public void printNum(int x) {
		System.out.println(x);
	}
	
	//정수 하나 전달받고, +1 해준 값 출력
	public void plusOne(int n) {
		System.out.println(n+1);
	}
	
	
}//class



























