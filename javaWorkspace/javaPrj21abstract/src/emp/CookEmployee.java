package emp;

public class CookEmployee extends Employee{
	
	//data
	
	//method
	public void cook() {
		System.out.println("요리중 ....");
	}
	
	@Override
	public void clean() {
		System.out.println("주방 청소 ...");
	}
	
	

}
