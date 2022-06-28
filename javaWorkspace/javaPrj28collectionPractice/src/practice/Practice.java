package practice;

import java.util.HashSet;
import java.util.Set;

public class Practice {
	
	public void test() {
		Set<String> set = new HashSet<>();
		set.add("chicken");
		set.add("pizza");
		set.add("hamburger");
		set.add("pasta");
		
		//set 의 모든 요소 꺼내기
		for(String x : set) {
			System.out.println(x);
		}
		
		//배열로 꺼내기
		System.out.println("------------------");
		//String[] arr = set.toArray();
//		for(int i = 0 ; i < arr.length; ++i) {
//			System.out.println(arr[i]);
//		}
//		for(String x : arr) {
//			System.out.println(x);
//		}
		
		System.out.println(set);
		
	}//method

}//class































