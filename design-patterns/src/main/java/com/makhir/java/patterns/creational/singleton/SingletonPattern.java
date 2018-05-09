package com.makhir.java.patterns.creational.singleton;

/**
 * Example for singleton design pattern
 * */
public class SingletonPattern {
	public static void main(String[] args) {
		//showEagerApproach();
		
		showStaticApproach();
		
		//lazyInitializationApproach();
	}
	
	private static void showEagerApproach(){
		
		System.out.println("Creating singleton object with eager approach.");
		
		EagerInitializationApproach obj1, obj2;
		
		obj1 = EagerInitializationApproach.getInstnce();
		obj2 = EagerInitializationApproach.getInstnce();
		
		System.out.println("Object 1 hascode : " + obj1.hashCode());
		System.out.println("Object 2 hascode : " + obj2.hashCode());
	}
	
	
	private static void showStaticApproach(){
		
		System.out.println("Creating singleton object with static block approach.");
		
		StaticBlockApproach obj1, obj2;
		
		obj1 = StaticBlockApproach.getInstance();
		obj2 = StaticBlockApproach.getInstance();
		
		System.out.println("Object 1 hascode : " + obj1.hashCode());
		System.out.println("Object 2 hascode : " + obj2.hashCode());
	}
	
	private static void lazyInitializationApproach(){
		
		System.out.println("Creating singleton object with lazy initialization approach.");
		
		LazyInitializationApproach obj1, obj2;
		
		obj1 = LazyInitializationApproach.getInstance();
		obj2 = LazyInitializationApproach.getInstance();
		
		System.out.println("Object 1 hascode : " + obj1.hashCode());
		System.out.println("Object 2 hascode : " + obj2.hashCode());
	}
}
