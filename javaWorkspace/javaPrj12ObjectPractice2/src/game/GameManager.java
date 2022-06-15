package game;

import mob.Pokemon;

public class GameManager {

	public void gameStart(Pokemon p1, Pokemon p2) {
		System.out.println("===== 포켓몬 게임 시작 =====");
		System.out.println("당신의 포켓몬 정보 : ");
		System.out.println(p1);
		System.out.println("상대방 포켓몬 정보 : ");
		System.out.println(p2);
	}
	
}
