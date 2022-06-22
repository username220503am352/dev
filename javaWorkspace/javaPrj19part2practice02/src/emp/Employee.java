package emp;

public class Employee {
	
	//메뉴판 보여주기
	public void showMenu() {
		System.out.println("===== Menu =====");
		System.out.println("1. 상하이");
		System.out.println("2. 타워버거");
		System.out.println("3. 불새버거");
		System.out.println("4. 와퍼");
	}
	
	//주문 접수 말하기
	public void sayMenu(int m) {
		switch(m) {
		case 1 : System.out.println("상하이 주문 완료"); break;
		case 2 : System.out.println("타워 주문 완료"); break;
		case 3 : System.out.println("불새 주문 완료"); break;
		case 4 : System.out.println("와퍼 주문 완료"); break;
		}
	}

}//class































