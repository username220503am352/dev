package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PracticeMap {
	
	public void test() {
		
		//맵 만들고, 모든 key, 모든 value 확인
		Map map = new HashMap();
		
		map.put("one", "apple");
		map.put("two", "banana");
		map.put("three", "tomato");
		
		//map 의 모든 key 확인
		Set ks = map.keySet();
		for(Object x : ks) {
			System.out.println(x);
			System.out.println(map.get(x));
		}
		
	}//method
	
	public void test2() {
		
		Map map = new HashMap();
		
		//데이터 넣기
		map.put("apple", "red");
		map.put("banana", "yellow");
		map.put("grape", "purple");
		
		//모든 데이터 확인
		Set<Map.Entry> es = map.entrySet();
		for(Map.Entry x : es) {
			System.out.println(x.getKey());
			System.out.println(x.getValue());
		}
		
	}//test2
	
	public void test3() {
		Map map = new HashMap();
		
		//데이터 넣기
		map.put("apple", "red");
		map.put("banana", "yellow");
		map.put("grape", "purple");
		
	}

}//class




























