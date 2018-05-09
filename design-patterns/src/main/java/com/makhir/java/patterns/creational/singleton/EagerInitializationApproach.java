package com.makhir.java.patterns.creational.singleton;

/**
 * This is simple and easy approach for singleton design pattern.
 * */
public class EagerInitializationApproach {
	private static final EagerInitializationApproach instance = new EagerInitializationApproach();
	
	private EagerInitializationApproach(){}
	
	public static EagerInitializationApproach getInstnce(){
		System.out.println("Inside getInstnce");
		return instance;
	}
}
