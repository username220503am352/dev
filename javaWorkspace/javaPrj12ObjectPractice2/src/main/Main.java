package main;

import battle.BattleManager;
import game.GameManager;
import mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		Pokemon p1 = new Pokemon();
		p1.setName("피카츄");
		p1.setHp(100);
		p1.setAtk(30);
		
		Pokemon p2 = new Pokemon();
		p2.setName("파이리");
		p2.setHp(100);
		p2.setAtk(25);
		
		//게임 시작
		GameManager gm = new GameManager();
		gm.gameStart(p1, p2);
		
		//배틀 시작
		BattleManager bm = new BattleManager();
		bm.battleStart(p1, p2);
		
	}//main

}//class

































