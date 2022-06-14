package cafe.main;

import cafe.emp.CookEmp;
import cafe.emp.CounterEmp;

public class CafeMain {

	public static void main(String[] args) {
		
		CounterEmp counter01 = new CounterEmp();
		counter01.nick = "철수";
		counter01.salary = 11000;
		
		CookEmp cook01 = new CookEmp();
		cook01.nick = "영희";
		cook01.salary = 13000;
		
		counter01.welcome();
		

	}//main

}//class
































