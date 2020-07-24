package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * The enemy class is for enemy creation and stores the ai to target the player
 * @author Cole Gartner
 *
 */
public abstract class Enemy extends Entity {

	/**
	 * Constructor of enemy
	 * @param img
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Enemy(Camera cmr, BufferedImage img, int x, int y, int width, int height) {
		super(cmr, img, x, y, width, height);
	}
	
	/**
	 * Enemy AI that targets the player
	 * @param e
	 */
	public void targetEntity(Entity e) {
		// Checks to see if the entity is x amount away from this enemy
		if (Math.abs(e.getPosx() - vecx) < 5 * Tile.TILE_WIDTH &&
				Math.abs(e.getPosy() - vecy) < 5 * Tile.TILE_HEIGHT) {
			if (e.getPosx() > vecx) {
				velx = speed;
			}
			else if (e.getPosx() < vecx) {
				velx = -speed;
			}
			else {
				velx = 0;
			}
			
			if (e.getPosy() > vecy) {
				vely = speed;
			}
			else if (e.getPosy() < vecy) {
				vely = -speed;
			}
			else {
				vely = 0;
			}
		}
		else {
			velx = 0;
			vely = 0;
		}
	}


}
