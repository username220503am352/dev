package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	
	public void testMethod() {
		//Map > HashMap
		/*
		 * key, value 쌍으로 데이터 저장
		 * key 중복 불가능
		 * value 중복 가능
		 */
		
		Map hm = new HashMap();
		
		//값 넣기 (키, 값)
		hm.put("one","apple");
		hm.put("two","apple");
		hm.put("two","멜론");
		hm.put("three","tomato");
		
		
		
		System.out.println("---------------");
		
		//해당 키가 존재하는지 확인
		System.out.println(hm.containsKey("four"));
		
		//해당 값이 존재하는지 확인
		System.out.println(hm.containsValue("kiwi"));
		
		//비어있는지 확인
		System.out.println(hm.isEmpty());
		
		//전체 지우기
		//hm.clear();
		
		//데이터 지우기
		hm.remove("one");
		
		//몇개의 요소가 존재하는지 갯수 확인
		System.out.println(hm.size());
		
		System.out.println("-----------------");
		//값 꺼내기
		System.out.println(hm.get("one"));
		System.out.println(hm.get("two"));
		System.out.println(hm.get("three"));
		System.out.println(hm.get("four"));
		
		
		
		
	}//method

}//class





































