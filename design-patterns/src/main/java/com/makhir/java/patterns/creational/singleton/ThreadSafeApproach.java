package com.makhir.java.patterns.creational.singleton;

public class ThreadSafeApproach {
	private static ThreadSafeApproach instance;

	private ThreadSafeApproach() {
		if(ThreadSafeApproach.instance != null) //To avoid creation of object from reflection as well.
			throw new InstantiationError("It's singleton object. You can't create new instance.");
	}
	
	
	public static ThreadSafeApproach getInstance(){
		if(instance == null){
			synchronized (ThreadSafeApproach.class) {
				if(instance == null)
					instance = new ThreadSafeApproach();
			}
		}
		return instance;
	}
}
