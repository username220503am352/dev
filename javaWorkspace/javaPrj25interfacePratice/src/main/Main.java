package main;

import mob.Agumon;
import mob.Digimon;
import mob.DigimonAction;
import mob.Padak;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 인터페이스 연습 =====");
		
		Digimon agumon = new Agumon();
		agumon.setName("아구몬");
		agumon.setType("백신");
		Digimon padak = new Padak();
		padak.setName("파닥몬");
		padak.setType("백신,데이터");
		
		System.out.println(agumon);
		System.out.println(padak);
		
		agumon.sayHello();
		agumon.attack();
		agumon.skill();
		padak.sayHello();
		padak.attack();
		padak.skill();
		
		if(agumon instanceof Padak) {
			System.out.println("ㅇㅋ");
		}else {
			System.out.println("ㄴㄴ");
		}

	}//main

}//class





















