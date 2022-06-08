package var;

public class CastingTest {

	public static void main(String[] args) {
		
		/*
		 * 형 변환
		 * 
		 * 둘 중 큰 타입을 따라간다
		 * 
		 * 묵시적형변환 :
		 * 서로 다른 타입은 연산이 불가하지만, 컴퓨터가 알아서 변환해준다.
		 * 
		 * 명시적형변환 :
		 * 강제로 타입을 변환시킴
		 * 대상 앞에다가, 변환시킬 타입을 명시해주면 됨
		 * ex ) (long) 값
		 * ==> 값이 long 타입으로 변환됨
		 * 
		 */
		
		int a = 10;
		long b = 20;
		
		System.out.println(a+b); //int 와 long 연산은 컴퓨터가 long으로 묵시적 형변환 해줌

	}

}
















