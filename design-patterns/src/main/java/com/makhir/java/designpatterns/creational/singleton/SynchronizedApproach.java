package com.makhir.java.designpatterns.creational.singleton;

public class SynchronizedApproach {
	private static SynchronizedApproach instance;

	private SynchronizedApproach() {
	}
	
	public static synchronized SynchronizedApproach getInstance(){
		if(instance == null)
			instance = new SynchronizedApproach();
		return instance;
	}
}
