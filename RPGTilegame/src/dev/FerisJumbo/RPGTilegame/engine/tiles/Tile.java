package dev.FerisJumbo.RPGTilegame.engine.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
	
	public static ArrayList<Tile> allTiles = new ArrayList<Tile>();
	public static ArrayList<Tile> nonPassables = new ArrayList<Tile>();
	
	protected BufferedImage sprite; // sprite image of the tile
	
	protected int x, y; // position
	protected int width, height;
	protected Rectangle collisionBox; // colliding box
	protected boolean passable; // Whether collision should occur
	
	protected Camera cmr;

	/**
	 * Constructor for all tiles
	 * @param sprite
	 * @param x
	 * @param y
	 * @param passable
	 */
	public Tile(BufferedImage sprite, int x, int y, Camera cmr, boolean passable) {
		this.cmr = cmr;
		this.sprite = sprite;
		this.x = x * TILE_WIDTH;
		this.y = y * TILE_HEIGHT;
		this.width = TILE_WIDTH;
		this.height = TILE_HEIGHT;
		this.passable = passable;
		this.collisionBox = new Rectangle(x, y, width, height);
		
		allTiles.add(this);
		if (!passable) {
			nonPassables.add(this);
		}
	}
	
	/**
	 * Returns whether or not the tile should be able to
	 * be passed over by an entity
	 * @return
	 */
	public boolean isPassable() {
		return passable;
	}
	
	/**
	 * Update method for Tiles
	 */
	public void update() {
		collisionBox = new Rectangle(x, y, width, height);
	}
	
	/**
	 * Render method for Tiles
	 * @param g
	 */
	public void render(Graphics g) {
		g.drawImage(sprite, x - cmr.getXOffset(),
				y - cmr.getYOffset(), width, height, null);
	}

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

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public void setCollisionBox(Rectangle collisionBox) {
		this.collisionBox = collisionBox;
	}

}
