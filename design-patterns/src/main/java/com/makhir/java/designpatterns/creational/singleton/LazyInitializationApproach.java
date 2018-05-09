package com.makhir.java.designpatterns.creational.singleton;

/**
 * This class shows lazy initialization of instance.
 * */
public class LazyInitializationApproach {
	private static LazyInitializationApproach instance;
	
	private LazyInitializationApproach() {}
	
	public static LazyInitializationApproach getInstance(){
		if(instance == null)
			instance = new LazyInitializationApproach();
		
		return instance;
	}
}
