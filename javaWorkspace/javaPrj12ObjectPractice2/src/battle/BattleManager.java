package battle;

import mob.Pokemon;

public class BattleManager {
	
	public void battleStart(Pokemon user, Pokemon enemy) {
		
		boolean isFinish = false;
		
		do {
			//공격하기
			user.attack();
			calcDamage(enemy, user);
			//판단
			isFinish = checkDead(enemy);
			
			//공격하기
			enemy.attack();
			calcDamage(user, enemy);
			//판단
			isFinish = checkDead(user);
		}while(!isFinish);
		
		System.out.println("배틀 종료 ~~~");
		
	}//battleStart
	
	//데미지 계산
	public void calcDamage(Pokemon defender, Pokemon attacker) {
		int result = defender.getHp() - attacker.getAtk();; 
		defender.setHp(result);
	}
	
	//체력 0 이하 인지 판단
	public boolean checkDead(Pokemon p) {
		if(p.getHp() <= 0) {
			System.out.println(p.getName() + " 죽음...ㅜㅜ");
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	

}//class






























