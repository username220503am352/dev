package com.kh;

public class Main {

	public static void main(String[] args) {
		System.out.println("===== 쓰레드 =====");
		
		//방법1
		Thread t1 = new Thread( ()->{
			for(int i = 1; i <= 100; ++i) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " : " + i);
			}
		} );
		t1.start();
		
		//방법2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i <= 100; ++i) {
					String name = Thread.currentThread().getName();
					System.out.println(name + " : " + i);
				}
			}
		});
		t2.start();
		
		//방법3
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i <= 100; ++i) {
					String name = Thread.currentThread().getName();
					System.out.println(name + " : " + i);
				}
			}
		};
		Thread t3 = new Thread(r);
		t3.start();
		
		//방법4
		Thread t4 = new Thread(new MyRunner());
		t4.start();
		
		
		//기본
		for(int i = 1; i <= 100; ++i) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + i);
		}
		
	}//main

}//class
























