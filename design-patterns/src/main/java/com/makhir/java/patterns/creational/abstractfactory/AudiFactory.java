package com.makhir.java.patterns.creational.abstractfactory;

public class AudiFactory implements AbstractFactory{

	private String modelName;
	private String varient;
	private String launchYear;
	
	public AudiFactory(String modelName, String varient, String launchYear) {
		this.modelName = modelName;
		this.varient = varient;
		this.launchYear = launchYear;
	}

	@Override
	public Car createCar() {
		return new Audi(modelName, varient, launchYear);
	}

}
