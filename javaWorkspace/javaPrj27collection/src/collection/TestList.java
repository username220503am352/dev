package collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	
	public void testMethod() {
		// List > ArrayList
		/*
		 * 순서 있음 (인덱스)
		 * 중복 가능
		 */
		List al = new ArrayList(); //리스트 생성
		
		//값 넣기
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		al.add(50);
		al.add(50);
		
		
		
		
		//값이 존재하는지 확인
		System.out.println(al.contains(70));
		
		//몇개의 요소가 있는지 확인(배열의 length 역할)
		System.out.println(al.size());
		
		//인덱스를 활용해서 요소 삭제
		al.remove(3);
		
		//값을 활용해서 요소 삭제
		al.remove(new Integer(10));
		
		//요소의 인덱스 확인 (중복값이 있어도 처음 발견된 인덱스 리턴)
		System.out.println(al.indexOf(50));
		
		//요소의 인덱스 확인 (뒤에서)
		System.out.println(al.lastIndexOf(50));
		
		//특정 인덱스의 값 바꾸기
		al.set(0, 99);
		
		//리스트의 모든 요소 제거
		//al.clear();
		
		//리스트가 비어있는지 확인
		System.out.println(al.isEmpty());
		
		//특정 인덱스에 값 추가
		al.add(3, 777);
		
		System.out.println("----------------------");
		
		//값 확인
		for(int i = 0 ; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		//값을 삭제하면, 인덱스도 변한다 (당겨짐)
		//System.out.println(al.get(2));
		
		
	}//method

}//class


























