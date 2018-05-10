package com.makhir.java.patterns.creational.abstractfactory;

public class CarAbstractFactory {
	public static Car getCar(AbstractFactory factory){
		return factory.createCar();
	}
}
