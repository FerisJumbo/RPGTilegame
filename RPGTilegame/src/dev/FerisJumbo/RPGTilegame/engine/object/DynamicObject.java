package dev.FerisJumbo.RPGTilegame.engine.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * This is the base abstract for everything in the game that
 * is not a tile
 * @author Cole Gartner
 *
 */
public abstract class DynamicObject {

	protected BufferedImage sprite;
	
	protected int vecx, vecy; // Vector x and y
	protected int width, height;
	
	/**
	 * Creates a new Dynamic object
	 * @param img
	 * @param x
	 * @param y
	 */
	public DynamicObject(BufferedImage img, int x, int y, int width, int height) {
		this.sprite = img;
		this.vecx = x;
		this.vecy = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Update method
	 */
	public abstract void update();
	
	/**
	 * Render method
	 * @param g
	 */
	public abstract void render(Graphics g);

	// Getters and Setters \\
	
	public int getPosx() {
		return vecx;
	}

	public void setPosx(int posx) {
		this.vecx = posx;
	}

	public int getPosy() {
		return vecy;
	}

	public void setPosy(int posy) {
		this.vecy = posy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
