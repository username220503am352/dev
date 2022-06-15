package practice;

public class Food {
	
	private String menu;
	private int price;
	private int cal;
	private char isDouble;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	public char getIsDouble() {
		return isDouble;
	}
	public void setIsDouble(char isDouble) {
		this.isDouble = isDouble;
	}
	
	public void printInfo() {
		//값 출력
		System.out.println(cal);
		System.out.println(isDouble);
		System.out.println(menu);
		System.out.println(price);
	}
	
	public String getInfo() {
		String s = cal + " / " + isDouble + " / " + menu + " / " + price;
		return s;
	}
	
	public String toString() {
		return "Food [menu=" + menu + ", price=" + price + ", cal=" + cal + ", isDouble=" + isDouble + "]";
	}
	
	
	

}//class









