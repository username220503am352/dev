package main;

public class MainSamHang {

	public static void main(String[] args) {
		
		// 양수라면 1 , 음수라면 -1
		
		int x = 0;
		int result = 0;
		
//		if(x > 0) {
//			result = 1;
//		}else {
//			result = -1;
//		}
		
//		result = x > 0 ? 1 : -1;
		result = x > 0 ? 1 : x==0 ? 0:-1;
		
		System.out.println(result);
		
		
	}//main

}//class




















