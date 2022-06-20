package main;

import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import mob.Turtle;

public class Main {

	public static void main(String[] args) {
		//포켓몬 생성
		Pokemon pikachu = new Pikachu();
		Pokemon pairi = new Pairi();
		Pokemon turtle = new Turtle();
		
		//포켓몬 배열 생성
		Pokemon[] pArr = new Pokemon[3];
		pArr[0] = pikachu;
		pArr[1] = pairi;
		pArr[2] = turtle;
		
		//모든 포켓몬 몸통 박치기
		for(int i = 0 ; i < pArr.length; i++) {
			pArr[i].bodyAttack();
		}
//		pikachu.bodyAttack();
//		pairi.bodyAttack();
//		turtle.bodyAttack();
		
		//모든 포켓몬 스킬 사용
		pikachu.skill01();
		pairi.skill01();
		turtle.skill01();
		
		
		
		
	}//main

}//class




















