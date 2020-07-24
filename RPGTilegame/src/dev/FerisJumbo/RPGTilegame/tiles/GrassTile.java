package dev.FerisJumbo.RPGTilegame.tiles;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * Grass Tile
 * @author Cole Gartner
 *
 */
public class GrassTile extends Tile{

	/**
	 * Constructor for a Grass Tile
	 * @param x
	 * @param y
	 */
	public GrassTile(int x, int y, Camera cmr) {
		super(Assets.grass, x, y, cmr, true);
	}

}
