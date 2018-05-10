package com.makhir.java.patterns.behavioral.template;

public class TestTemplatePattern {
	public static void main(String[] args) {
		GameTemplate cricket = new CricketGame();
		cricket.play();
		
		GameTemplate football = new FootballGame();
		football.play();
		
	}
}
