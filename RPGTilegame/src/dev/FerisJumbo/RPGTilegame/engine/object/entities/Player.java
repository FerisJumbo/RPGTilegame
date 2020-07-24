package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.KeyManager;
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
		super(cmr, img, x, y, width, height);
		this.cmr = cmr;
		this.speed = 2;
	}
	
	private void keyVelocity(KeyManager km) {
		if (km.w) {
			vely = -speed;
		}
		if (km.s) {
			vely = speed;
		}
		if (km.a) {
			velx = -speed;
		}
		if (km.d) {
			velx = speed;
		}
	}

	/**
	 * Updates player
	 * @param km
	 */
	public void update(KeyManager km) {
		keyVelocity(km);
		move();
	}

	/**
	 * Renders player
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, vecx - cmr.getXOffset(),
				vecy - cmr.getYOffset(), width, height, null);
	}

	// Ignore this method
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
