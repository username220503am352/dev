package collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
	
	public void testMethod() {
		
		Queue q = new LinkedList();
		/*
		 * FIFO 구조 (First In First Out)
		 */
		
		//데이터 넣기
		q.offer("one");
		q.offer("two");
		q.offer("three");
		
		System.out.println(q.size());
		
		//처음 데이터 읽기
		System.out.println(q.peek());
		System.out.println(q.peek());
		System.out.println(q.peek());
		System.out.println(q.size());
		
		//처음 데이터 꺼내기(읽고 삭제하기)
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.size());
		
	}//method

}//class


































