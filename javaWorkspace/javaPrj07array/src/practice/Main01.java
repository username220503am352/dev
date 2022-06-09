package practice;

public class Main01 {

	public static void main(String[] args) {
		
		System.out.println("===== 배열 =====");
		
		int[] a = new int[10];
		
		// a 라는 배열에 10 , 20, 30 ~ 100 까지 값을 넣고,
		// a 배열의 모든 값을 출력해보기
		
		for(int i = 0; i < 10; i++) {
			a[i] = i*10+10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(a[i]);
		}
		
		

	}//main

}//class












