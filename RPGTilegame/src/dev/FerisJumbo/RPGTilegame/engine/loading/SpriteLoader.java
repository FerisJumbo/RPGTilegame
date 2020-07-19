package dev.FerisJumbo.RPGTilegame.engine.loading;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This loads the spritesheets that should be located in rsc/textures/worlds/
 * @author Cole Gartner
 *
 */
public class SpriteLoader {
	
	private BufferedImage spriteSheet;

	/**
	 * Constructor of the SpriteLoader by taking a path and loading it in
	 * @param sheet
	 */
	public SpriteLoader(String path) {
		this.spriteSheet = loadImage(path);
	}
	
	/**
	 * Used to crop certain portions of the spritesheet
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
	
	/**
	 * Returns the spritesheet to the constructor so other classes
	 * can use it (Assets)
	 * @param path
	 * @return
	 */
	private BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(SpriteLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
		return null;
	}

}
