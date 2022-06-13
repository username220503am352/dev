package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GameController gc = new GameController();
		gc.printInfo();
		
		//랜덤숫자 만들기 (1~50)
		GameManager gm = new GameManager();
		int random = gm.getRandom();
		
		//시도한 횟수 체크
		int cnt = 0;
		
		while(true) {
			int user = gc.scanUserNum();
			cnt++;
			boolean isFinish = gc.judge(user, random, cnt);
			if(isFinish) {
				break;
			}
		}

	}//main

}//class

































