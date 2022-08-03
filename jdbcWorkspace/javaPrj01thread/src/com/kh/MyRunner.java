package com.kh;

public class MyRunner implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 100; ++i) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + i);
		}
	}

}
