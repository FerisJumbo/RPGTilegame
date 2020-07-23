package dev.FerisJumbo.RPGTilegame.tiles;

import java.awt.Graphics;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * No Tile Found Class
 * Used as placeholder or if their is no Tile made for the map yet
 * @author Cole Gartner
 *
 */
public class NoTile extends Tile {

	/**
	 * No Tile Constructor
	 * @param x
	 * @param y
	 */
	public NoTile(int x, int y, Camera cmr) {
		super(Assets.none, x, y, cmr, true);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}

}
