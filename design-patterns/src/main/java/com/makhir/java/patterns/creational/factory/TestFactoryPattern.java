package com.makhir.java.patterns.creational.factory;

public class TestFactoryPattern {
	public static void main(String[] args) {
		
		Car audi = FactoryPattern.getCar("AUDI");
		System.out.println("Audi : " + audi.toString());
		
		Car bmw = FactoryPattern.getCar("BMW");
		System.out.println("Bmw : " + bmw.toString());
	}
}
