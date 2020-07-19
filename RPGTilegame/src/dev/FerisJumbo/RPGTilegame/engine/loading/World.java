package dev.FerisJumbo.RPGTilegame.engine.loading;

import java.awt.Graphics;

import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;
import dev.FerisJumbo.RPGTilegame.engine.utils.Util;
import dev.FerisJumbo.RPGTilegame.tiles.DirtTile;
import dev.FerisJumbo.RPGTilegame.tiles.GrassTile;
import dev.FerisJumbo.RPGTilegame.tiles.NoTile;

/**
 * Loads and stores world data like tile type and position
 * 
 * Every map.txt file has to have the width and height of the map,
 * the starting location of the player, and then the actual map
 * itself with numbers indicating what tile to load.
 * @author Cole Gartner
 *
 */
public class World {
	
	private int mWidth, mHeight; // Width and height of the map
	private int spawnX, spawnY; // Player spawn point on the map
	private int[][] tileMap; // Multidimensional array that stores tile data to load the world

	/**
	 * Constructor of World and takes a path to load data from
	 * @param path
	 */
	public World(String path) {
		loadData(path);
	}
	
	// Loads the data into this World object
	public void loadData(String path) {
		String file = Util.loadFileAsString(path);
		// This houses all the integers from the loaded file
		String[] tokens = file.split("\\s+");
		this.mWidth = Util.parseInt(tokens[0]);
		this.mHeight = Util.parseInt(tokens[1]);
		this.spawnX = Util.parseInt(tokens[2]);
		this.spawnY = Util.parseInt(tokens[3]);
		
		// Initializes the tileMap multidimensional array with the
		// exact width and height of the map
		tileMap = new int[mWidth][mHeight];
		// This loop essentially locates the x, y coordinate of the
		// map tiles that were located in the file
		for (int y = 0; y < mHeight; y++) {
			for (int x = 0; x < mWidth; x++) {
				tileMap[x][y] = Util.parseInt(tokens[(x + y * mWidth) + 4]);
			}
		}
	}
	
	/**
	 * Update method of World
	 */
	public void update() {
		
	}
	
	/**
	 * Render method of World
	 * @param g
	 */
	public void render(Graphics g) {
		for (int y = 0; y < mHeight; y++) {
			for (int x = 0; x < mWidth; x++) {
				int tileNum = tileMap[x][y];
				if (tileNum == 1) {
					new DirtTile(x, y).render(g);
				}
				else if (tileNum == 2) {
					new GrassTile(x, y).render(g);
				}
				else {
					new NoTile(x, y).render(g);
				}
			}
		}
	}
	
	

}
