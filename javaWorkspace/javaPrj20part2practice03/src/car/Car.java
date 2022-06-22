package car;

public class Car {
	
	//(기본)생성자
	public Car() {
		
	}
	
	//생성자
	public Car(String color, int speed, String brand) {
		this.color = color;
		this.speed = speed;
		this.brand = brand;
	}
	
	//data
	private String color;
	private int speed;
	private String brand;
	
	//method
	public void go() {
		System.out.println(color + brand + " 자동차 " + speed + "속도로 이동");
	}
	
	public void stop() {
		System.out.println("멈춰");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", brand=" + brand + "]";
	}

	
	

}//class


























