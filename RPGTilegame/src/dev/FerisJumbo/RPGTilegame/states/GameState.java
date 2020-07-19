package dev.FerisJumbo.RPGTilegame.states;

import java.awt.Graphics;

import dev.FerisJumbo.RPGTilegame.engine.State;
import dev.FerisJumbo.RPGTilegame.engine.loading.World;

/**
 * The Game state that holds the world and lets the player actually play
 * the game by updating and rendering tasks
 * @author Cole Gartner
 *
 */
public class GameState extends State{
	
	private World world = new World("rsc/world/TestWorld1.txt");

	/**
	 * Empty Constructor
	 */
	public GameState() {
		
	}

	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
