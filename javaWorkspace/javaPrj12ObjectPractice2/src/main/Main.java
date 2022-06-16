package main;

import battle.BattleManager;
import game.GameManager;
import mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		
		
		Pokemon p1 = new Pokemon("피카츄", 100, 30);
		
		Pokemon p2 = new Pokemon("파이리", 100, 25);
		
		//게임 시작
		GameManager gm = new GameManager();
		gm.gameStart(p1, p2);
		
		//배틀 시작
		BattleManager bm = new BattleManager();
		bm.battleStart(p1, p2);
		
	}//main

}//class

































