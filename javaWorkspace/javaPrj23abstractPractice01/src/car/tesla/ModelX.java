package car.tesla;

import car.Car;

public class ModelX extends Car{

	@Override
	public void go() {
		System.out.println("전기의 힘으로 ... 출발 ... !");
	}

	@Override
	public void stop() {
		System.out.println("전기차 브레이크 밟음 ...");
	}

}
