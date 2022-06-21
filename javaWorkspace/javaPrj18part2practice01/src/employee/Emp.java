package employee;

import main.Main;

public class Emp {
	
	public Emp(String nick) {
		this.nick = nick;
	}

	private String nick;
	
	public void sayWelcome() {
		System.out.println(nick + ": 환영합니다~^^ 주문은 키오스크에서 진행해주세요 ~");
	}

}
