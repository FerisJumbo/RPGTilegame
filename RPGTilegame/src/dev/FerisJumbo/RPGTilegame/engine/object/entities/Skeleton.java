package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;

/**
 * Test Class for enemies, might not be in release
 * @author Cole Gartner
 *
 */
public class Skeleton extends Enemy{

	public Skeleton(Camera cmr, BufferedImage img, int x, int y, int width, int height) {
		super(cmr, img, x, y, width, height);
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, vecx - cmr.getXOffset(),
				vecy - cmr.getYOffset(), width, height, null);
	}

}
