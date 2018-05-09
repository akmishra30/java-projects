package com.makhir.java.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;

public class BreakingSingleton {
	public static void main(String[] args) {
		ThreadSafeApproach ins1 = ThreadSafeApproach.getInstance();
		ThreadSafeApproach ins2 = null;
		
		System.out.println("Ins1 hashcode : " + ins1.hashCode());
		
		try {
			Constructor[] constList = ThreadSafeApproach.class.getDeclaredConstructors();
			
			for (Constructor constructor : constList) {
				constructor.setAccessible(true);
				ins2 = (ThreadSafeApproach) constructor.newInstance();
				break;
			}
			System.out.println("Ins2 hashcode : " + ins2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
