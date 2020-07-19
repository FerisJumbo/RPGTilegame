package dev.FerisJumbo.RPGTilegame.engine;

import java.awt.Graphics;

public abstract class State {

	public static State currentState = null;
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
