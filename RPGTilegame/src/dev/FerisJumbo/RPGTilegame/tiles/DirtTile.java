package dev.FerisJumbo.RPGTilegame.tiles;

import java.awt.Graphics;

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

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}

}
