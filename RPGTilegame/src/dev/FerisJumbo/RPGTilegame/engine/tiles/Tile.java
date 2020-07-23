package dev.FerisJumbo.RPGTilegame.engine.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;

/**
 * Houses the abstract to all Tile classes
 * @author Cole Gartner
 *
 */
public abstract class Tile {
	
	// The width and height of all tiles in the game
	public static final int TILE_WIDTH = 64,
							TILE_HEIGHT = 64;
	
	protected BufferedImage sprite; // sprite image of the tile
	
	protected int x, y; // position
	protected int width, height;
	protected boolean passable; // Whether collision should occur

	/**
	 * Constructor for all tiles
	 * @param sprite
	 * @param x
	 * @param y
	 * @param passable
	 */
	public Tile(BufferedImage sprite, int x, int y, Camera cmr, boolean passable) {
		this.sprite = sprite;
		this.x = x * TILE_WIDTH - cmr.getXOffset();
		this.y = y * TILE_HEIGHT - cmr.getYOffset();
		this.width = TILE_WIDTH;
		this.height = TILE_HEIGHT;
		this.passable = passable;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isPassable() {
		return passable;
	}
	
	/**
	 * Update method for Tiles
	 */
	public abstract void update();
	
	/**
	 * Render method for Tiles
	 * @param g
	 */
	public abstract void render(Graphics g);

	// Getters and Setters \\
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
