package dev.FerisJumbo.RPGTilegame.tiles;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * A Dirt Tile
 * @author Cole Gartner
 *
 */
public class DirtTile extends Tile {

	/**
	 * Constructor for a Dirt Tile
	 * @param x
	 * @param y
	 */
	public DirtTile(int x, int y, Camera cmr) {
		super(Assets.dirt, x, y, cmr, true);
	}

}
