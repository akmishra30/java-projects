package com.makhir.java.patterns.creational.singleton;

/**
 * This class shows static block initialization singleton instance.
 * */
public class StaticBlockApproach {
	
	private static StaticBlockApproach instance;
	
	private StaticBlockApproach(){}
	
	static {
		try {
			instance = new StaticBlockApproach();
		} catch (Exception e) {
			throw new RuntimeException("Runtime exception while creating instance");
		}
	}
	
	public static StaticBlockApproach getInstance(){
		return instance;
	}

}
