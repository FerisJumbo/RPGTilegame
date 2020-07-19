package dev.FerisJumbo.RPGTilegame;

import dev.FerisJumbo.RPGTilegame.engine.GameEngine;

public class Launcher {
	
	private static String GAMENAME = "RPG Game";
	private static  char VERSIONMOD = 'a'; // Alpha
	private static String VERSION = "0.1.2";

	public static void main(String[] args) {
		// Creates a new game instance
		GameEngine gm = new GameEngine((GAMENAME + " " + VERSIONMOD + VERSION),
								600, 400, 32);
		
		// Starts the game thread
		gm.start();
	}

}
