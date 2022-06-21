package menu;

public class Menu {
	
	public Menu(int price, int time) {
		this.price = price;
		this.time = time;
	}
	
	private int price;
	private int time;
	
	public int getPrice() {
		return price;
	}
	public int getTime() {
		return time;
	}

}
