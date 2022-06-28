package main;

import java.util.Map;

import mob.Pikachu;
import person.Trainer;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 포켓몬 =====");
		
		Trainer t = new Trainer("지우", 1);
		
		//포켓몬 생성
		Pikachu p = new Pikachu("피카츄", 7, 3, 100);
		
		//포켓몬 주머니에 넣기
		t.addPokemon(p);
//		Map pocket = t.getPocket();
//		pocket.put(p.getName(), p);
		
		
		System.out.println(t.getPokemonCnt());
		

	}//main

}//class



































