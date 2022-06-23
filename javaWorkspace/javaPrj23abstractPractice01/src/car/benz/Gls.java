package car.benz;

import car.Car;

public class Gls extends Car{

	@Override
	public void go() {
		System.out.println("휘발유의 힘으로 ... 출발 ... !");
	}

	@Override
	public void stop() {
		System.out.println("휘발유차 브레이크 밟음 ...");
	}
	
}
