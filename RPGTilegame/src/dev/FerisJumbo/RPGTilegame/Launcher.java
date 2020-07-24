package dev.FerisJumbo.RPGTilegame;

import dev.FerisJumbo.RPGTilegame.engine.GameEngine;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

public class Launcher {
	
	private static String GAMENAME = "RPG Game";
	private static  char VERSIONMOD = 'a'; // Alpha
	private static String VERSION = "0.1.4";

	public static void main(String[] args) {
		// Creates a new game instance
		GameEngine gm = new GameEngine((GAMENAME + " " + VERSIONMOD + VERSION),
								12 * Tile.TILE_WIDTH,
								8 * Tile.TILE_HEIGHT, 32);
		
		// Starts the game thread
		gm.start();
	}

}
