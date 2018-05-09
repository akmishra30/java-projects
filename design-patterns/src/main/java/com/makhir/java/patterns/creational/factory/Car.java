package com.makhir.java.patterns.creational.factory;

public abstract class Car {
	public abstract String getModelName();
	public abstract String getVarient();
	public abstract String getLaunchYear();
	
	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("ModelName: ").append(this.getModelName());
		message.append("\nVarient: ").append(this.getVarient());
		message.append("\nLaunchYear: ").append(this.getLaunchYear());
		return message.toString();
	}
}
