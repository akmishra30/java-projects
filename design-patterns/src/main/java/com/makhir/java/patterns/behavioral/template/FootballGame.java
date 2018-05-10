package com.makhir.java.patterns.behavioral.template;

public class FootballGame extends GameTemplate {

	@Override
	void initializeGame() {
		System.out.println("Initializing football game.");
	}

	@Override
	void startPlay() {
		System.out.println("Starting football game.");
	}

	@Override
	void endPlay() {
		System.out.println("Ending football game.");
	}

}
