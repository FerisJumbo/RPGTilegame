package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;

/**
 * Creates a player object from entity
 * @author Cole Gartner
 *
 */
public class Player extends Entity {
	
	private Camera cmr;

	/**
	 * Constructor for player
	 * @param img
	 * @param x
	 * @param y
	 */
	public Player(Camera cmr, BufferedImage img, int x, int y, int width, int height) {
		super(img, x, y, width, height);
		this.cmr = cmr;
	}

	@Override
	public void update() {
		velx = 1;
		vely = 1;
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, vecx - cmr.getXOffset(),
				vecy - cmr.getYOffset(), width, height, null);
	}

}
