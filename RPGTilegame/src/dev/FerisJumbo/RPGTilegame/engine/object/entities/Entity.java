package dev.FerisJumbo.RPGTilegame.engine.object.entities;

import java.awt.image.BufferedImage;

import dev.FerisJumbo.RPGTilegame.engine.camera.Camera;
import dev.FerisJumbo.RPGTilegame.engine.object.DynamicObject;
import dev.FerisJumbo.RPGTilegame.engine.tiles.Tile;

/**
 * Creates an abstract Entity
 * @author Cole Gartner
 *
 */
public abstract class Entity extends DynamicObject {
	
	protected int velx, vely; // Tracks velocity of Entity

	protected int speed; // Speed of the entity

	/**
	 * Creates a new Entity
	 * @param img
	 * @param x
	 * @param y
	 */
	public Entity(Camera cmr, BufferedImage img, int x, int y, int width, int height) {
		super(cmr, img, x, y, width, height);
		this.velx = 0;
		this.vely = 0;
		this.speed = 1;
	}
	
	// Moves the entity with its velocity
	protected void move() {
		collisionDetection();
		vecx += velx;
		vecy += vely;
		velx = 0;
		vely = 0;
	}
	
	/**
	 * Collision detection math and logic
	 */
	protected void collisionDetection() {
		for (Tile t : Tile.nonPassables) {
			// This if statement checks for both right and left sides
			// of the entity and non passable tile to determine whether
			// the velocity of x should be 0
			if ((vecx + width + velx > t.getX() &&
					vecx + velx < t.getX() + t.getWidth()) &&
					(vecy + height > t.getY() &&
					vecy < t.getY() + t.getHeight())) {
				velx = 0;
			}
			
			// This if statement checks for both top and bottom sides
			// of the entity and non passable tile to determine whether
			// the velocity of y should be 0
			if ((vecy + height + vely > t.getY() &&
					vecy + vely < t.getY() + t.getHeight()) &&
					(vecx + width > t.getX() &&
					vecx < t.getX() + t.getWidth())) {
				vely = 0;
			}
		}
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
