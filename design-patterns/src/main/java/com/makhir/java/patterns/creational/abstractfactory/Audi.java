package com.makhir.java.patterns.creational.abstractfactory;

public class Audi extends Car {
	
	private String modelName;
	private String varient;
	private String launchYear;
	
	public Audi(String modelName, String varient, String launchYear) {
		this.modelName = modelName;
		this.varient = varient;
		this.launchYear = launchYear;
	}

	@Override
	public String getModelName() {
		return this.modelName;
	}

	@Override
	public String getVarient() {
		return this.varient;
	}

	@Override
	public String getLaunchYear() {
		return this.launchYear;
	}

}
