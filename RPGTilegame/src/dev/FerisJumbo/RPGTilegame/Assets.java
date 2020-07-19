package dev.FerisJumbo.RPGTilegame;

import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.loading.SpriteLoader;

public class Assets {
	
	// Width and height of each sprite on the spritesheet
	private static final int width = 32, height = 32;

	// All the textures for the game init here
	public static BufferedImage dirt, grass, none, player, tree;
	
	/**
	 * Initializes the spritesheet and crops the textures to fit
	 * the desired variable
	 */
	public static void init() {
		SpriteLoader sheet1 = new SpriteLoader("/textures/BasicSheet1.png");
		
		dirt = sheet1.crop(0, 0, width, height);
		grass = sheet1.crop(width, 0, width, height);
		none = sheet1.crop(width * 2, 0, width, height);
		player = sheet1.crop(width * 3, 0, width, height);
		tree = sheet1.crop(width * 4, 0, width, height);
		
	}

}
