package com.makhir.java.patterns.behavioral.template;

public class CricketGame extends GameTemplate {

	@Override
	void initializeGame() {
		System.out.println("Initializing cricket game.");
	}

	@Override
	void startPlay() {
		System.out.println("Starting cricket game.");
	}

	@Override
	void endPlay() {
		System.out.println("Ending cricket game.");
	}

}
