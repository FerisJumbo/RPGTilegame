package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.object.DynamicObject;

/**
 * Creates an abstract Entity
 * @author Cole Gartner
 *
 */
public abstract class Entity extends DynamicObject {
	
	protected int velx, vely; // Tracks velocity of Entity

	/**
	 * Creates a new Entity
	 * @param img
	 * @param x
	 * @param y
	 */
	public Entity(BufferedImage img, int x, int y, int width, int height) {
		super(img, x, y, width, height);
		velx = 0;
		vely = 0;
	}
	
	// Moves the entity with its velocity
	protected void move() {
		vecx += velx;
		vecy += vely;
		velx = 0;
		vely = 0;
	}

	// Getters and Setters \\
	
	public int getVelx() {
		return velx;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public int getVely() {
		return vely;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}

}
