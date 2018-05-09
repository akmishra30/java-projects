package com.makhir.java.patterns.creational.factory;

public class FactoryPattern {
	
	public static Car getCar(String type) {
		Car car = null;

		switch (type) {
		case "AUDI":
			car = new Audi("500", "Sedan", "2010");
			break;
		case "BMW":
			car = new Bmw("XF500", "SUV", "2012");
			break;
		default:
			break;
		}

		return car;
	}
}
