package main;

import java.util.Scanner;

public class GameController {
	
	public void printInfo() {
		//게임 안내
		System.out.println("===== UP DOWN 게임 =====");
		System.out.println("컴퓨터가 생각한 숫자를 맞추면 이기는 게임입니다.");
		System.out.println("안내메세지");
		System.out.println("어쩌구");
		System.out.println("저쩌구");
	}
	
	public int scanUserNum() {
		//사용자로부터 숫자 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int user = sc.nextInt();
		return user;
	}
	
	public boolean judge(int u, int c, int cnt) {
		//입력받은 결과 판단하고 출력문 실행
		if(u > c) {
			System.out.println("DOWN");
			return false;
		}else if(u < c) {
			System.out.println("UP");
			return false;
		}else {
			System.out.println("정답!");
			System.out.println("시도횟수 : " + cnt);
			return true;
		}
	}

}//class

























