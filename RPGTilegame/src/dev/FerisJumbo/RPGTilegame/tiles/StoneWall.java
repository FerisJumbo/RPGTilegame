package dev.FerisJumbo.RPGTilegame.tiles;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * A wall, its that simple
 * @author Cole Gartner
 *
 */
public class StoneWall extends Tile {

	/**
	 * Constructor for wall
	 * @param sprite
	 * @param x
	 * @param y
	 * @param cmr
	 * @param passable
	 */
	public StoneWall(int x, int y, Camera cmr) {
		super(Assets.stoneWall, x, y, cmr, false);
	}

}
