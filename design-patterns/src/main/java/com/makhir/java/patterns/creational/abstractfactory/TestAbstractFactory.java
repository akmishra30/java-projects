package com.makhir.java.patterns.creational.abstractfactory;

public class TestAbstractFactory {
	public static void main(String[] args) {
		Car audi = CarAbstractFactory.getCar(new AudiFactory("AUDI-500", "SUV", "2010"));
		Car bmw = CarAbstractFactory.getCar(new BmwFactory("XF-500", "SUV", "2012"));
		
		System.out.println("Audi : -> " + audi.toString());
		
		System.out.println("Bmw : -> " + bmw.toString());
	}
}
