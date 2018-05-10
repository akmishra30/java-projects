package com.makhir.java.patterns.creational.abstractfactory;

public class BmwFactory implements AbstractFactory{

	private String modelName;
	private String varient;
	private String launchYear;
	
	public BmwFactory(String modelName, String varient, String launchYear) {
		super();
		this.modelName = modelName;
		this.varient = varient;
		this.launchYear = launchYear;
	}

	@Override
	public Car createCar() {
		return new Bmw(modelName, varient, launchYear);
	}
}
