package dev.FerisJumbo.RPGTilegame.engine;

import java.awt.Graphics;

/**
 * Creates the abstract for state classes to tell the game what
 * to update and render
 * @author Cole Gartner
 *
 */
public abstract class State {

	public static State currentState = null;
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
