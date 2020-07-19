package dev.FerisJumbo.RPGTilegame;

import dev.FerisJumbo.RPGTilegame.engine.GameEngine;

public class Launcher {

	public static void main(String[] args) {
		GameEngine gm = new GameEngine("RPG Game - a0.1.1", 600, 400, 32);
		gm.start();
	}

}
