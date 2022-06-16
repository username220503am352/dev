package mob;

public class Pokemon {
	
	//생성자 : 클래스명(..){}
	//생성자 오버로딩 가능
	
	//기본생성자(JVM이 만들어줌, 아무런 생성자도 없는 경우에만)
	public Pokemon() {
		System.out.println("포켓몬 생성자 호출됨 ...");
	}
	
	//매개변수가 있는 생성자
	public Pokemon(String name, int hp, int atk) {
		System.out.println("매개변수가 있는 생성자 호출됨 ~~~");
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	//data
	//이름 공격력 hp
	private String name;
	private int atk;
	private int hp;
	
	//method
	//공격하기 회피하기 도망가기 
	public void attack() {
		System.out.println(name + " 의 공격 !!! ");
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







































