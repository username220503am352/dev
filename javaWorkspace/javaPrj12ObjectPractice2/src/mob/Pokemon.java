package mob;

public class Pokemon {

	//data
	//이름 공격력 hp
	private String name;
	private int atk;
	private int hp;
	
	//method
	//공격하기 회피하기 도망가기 
	public void attack() {
		System.out.println("공격 ~");
	}
	
	public void evade() {
		System.out.println("피함ㅋ");
	}
	
	public void giveUp() {
		System.out.println("도망감ㅠㅠ");
	}
	
	//getter/setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", atk=" + atk + ", hp=" + hp + "]";
	}
	
	
	
	
	
	
	
	
}//class







































