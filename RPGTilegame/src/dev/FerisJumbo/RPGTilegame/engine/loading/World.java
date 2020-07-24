package dev.FerisJumbo.RPGTilegame.engine.loading;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.KeyManager;
import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.object.entities.Player;
import dev.FerisJumbo.RPGTilegame.engine.object.entities.Skeleton;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;
import dev.FerisJumbo.RPGTilegame.engine.utils.Util;
import dev.FerisJumbo.RPGTilegame.tiles.DirtTile;
import dev.FerisJumbo.RPGTilegame.tiles.GrassTile;
import dev.FerisJumbo.RPGTilegame.tiles.NoTile;
import dev.FerisJumbo.RPGTilegame.tiles.StoneWall;

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
	private Player player; // Player object
	private Camera cmr; // Camera object
	
	private Skeleton skel; // TEST Enemy
	
	/**
	 * Constructor of World and takes a path to load data from
	 * @param path
	 */
	public World(String path, int winWidth, int winHeight) {
		loadData(path);
		this.cmr = new Camera(winWidth, winHeight, mWidth, mHeight, 0 , 0);
		this.player = new Player(cmr, Assets.player, spawnX * Tile.TILE_WIDTH,
				spawnY * Tile.TILE_HEIGHT, 64, 64);
		
		// TEST Enemy
		this.skel = new Skeleton(cmr, Assets.enemy, 0, 0, 64, 64);
		
		storeData();
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
	 * Used to store the file data to memory for quick easy access
	 */
	public void storeData() {
		cmr.update(player);
		Tile.allTiles = new ArrayList<Tile>();
		Tile.nonPassables = new ArrayList<Tile>();
		
		// Will store the tile data in the Tile object for quick loading
		for (int y = 0; y < mHeight; y++) {
			for (int x = 0; x < mWidth; x++) {
				int tileNum = tileMap[x][y];
				if (tileNum == 1) {
					new DirtTile(x, y, cmr);
				}
				else if (tileNum == 2) {
					new GrassTile(x, y, cmr);
				}
				else if (tileNum == 3) {
					new StoneWall(x, y, cmr);
				}
				else {
					new NoTile(x, y, cmr);
				}
			}
		}
	}
	
	/**
	 * Update method of World
	 */
	public void update(KeyManager km) {
		player.update(km);
		cmr.update(player);
		
		// TEST Enemy
		skel.targetEntity(player);
		skel.update();
	}
	
	/**
	 * Render method of World
	 * @param g
	 */
	public void render(Graphics g) {
		// Loops through all the tiles to update their position
		// relative to the camera
		for (Tile t : Tile.allTiles) {
			t.render(g);
		}
		
		// TEST Enemy
		skel.render(g);
		
		player.render(g);
	}

}
