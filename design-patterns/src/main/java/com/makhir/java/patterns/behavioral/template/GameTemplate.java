package com.makhir.java.patterns.behavioral.template;

public abstract class GameTemplate {
	abstract void initializeGame();
	
	abstract void startPlay();
	
	abstract void endPlay();
	
	public final void play(){
		initializeGame();
		
		startPlay();
		
		endPlay();
	}
}
