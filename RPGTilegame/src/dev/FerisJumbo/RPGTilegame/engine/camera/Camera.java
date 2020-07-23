package dev.FerisJumbo.RPGTilegame.engine.camera;

import dev.FerisJumbo.RPGTilegame.engine.object.entities.Player;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * Houses all of the components of the camera object to keep the window in full
 * display of the actual map and keep white spaces of the screen
 * @author Cole Gartner
 *
 */
public class Camera {
	
	private int wWidth, wHeight; // Width and height of the window
	private int mWidth, mHeight; // Width and height of the map
	private int xOffset = 0, yOffset = 0; // x and y offset used in Tile generation

	/**
	 * Constructor of the camera to calculate offset of a tile or player
	 * @param wWidth
	 * @param wHeight
	 * @param mWidth
	 * @param mHeight
	 * @param xo
	 * @param yo
	 */
	public Camera(int wWidth, int wHeight,
			int mWidth, int mHeight, int xo, int yo) {
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		this.mWidth = mWidth;
		this.mHeight = mHeight;
		this.xOffset = xo;
		this.yOffset = yo;
	}
	
	/**
	 * Update method of camera, used to set the x and y offset
	 * @param p
	 */
	public void update(Player p) {
		xOffset = p.getPosx() + (p.getWidth() / 2) -  wWidth / 2;
		yOffset = p.getPosy() + (p.getHeight() / 2) -  wHeight / 2;
	}
	
	/**
	 * Returns the x offset, but also checks the map width to make sure
	 * no white space is seen on the map
	 * @return
	 */
	public int getXOffset() {
		if (xOffset <= 0) { // Checks to see if max or min method should be used
			return Math.max(xOffset, 0);
		} else {
			return Math.min(xOffset, mWidth * Tile.TILE_WIDTH - wWidth);
		}
	}
	
	/**
	 * Returns the y offset, but also checks the map height to make sure
	 * no white space is seen on the map
	 * @return
	 */
	public int getYOffset() {
		if (yOffset <= 0) { // Checks to see if max or min method should be used
			return Math.max(yOffset, 0);
		} else {
			return Math.min(yOffset, mHeight * Tile.TILE_HEIGHT - wHeight);
		}
	}

}
