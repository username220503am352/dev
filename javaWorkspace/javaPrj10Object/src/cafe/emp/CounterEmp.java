package cafe.emp;

public class CounterEmp {
	
	//데이터
	public String nick;
	public int salary;
	
	//인사하기
	public void welcome() {
		System.out.println("어서오세요 ~~~ ");
		System.out.println(nick + "입니다.");
	}
	
	//메뉴안내
	public void showMenu() {
		System.out.println("메뉴는 메뉴판 보세요 ~");
	}
	
	//주문받기
	public void receiveOrder() {
		System.out.println("주문받기 ~~~");
	}
	
	//계산하기
	public void calc() {
		System.out.println("계산하기 ~~~");
	}
	
	//음료 준비 안내
	public void notice() {
		System.out.println("음료 나왔습니다.");
	}

}//class























