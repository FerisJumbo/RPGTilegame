package dev.FerisJumbo.RPGTilegame.states;

import java.awt.Graphics;

import dev.FerisJumbo.RPGTilegame.engine.KeyManager;
import dev.FerisJumbo.RPGTilegame.engine.State;
import dev.FerisJumbo.RPGTilegame.engine.loading.World;

/**
 * The Game state that holds the world and lets the player actually play
 * the game by updating and rendering tasks
 * @author Cole Gartner
 *
 */
public class GameState extends State{
	
	private World world1;

	/**
	 * Empty Constructor
	 */
	public GameState(int winWidth, int winHeight) {
		world1 = new World("resources/worlds/world1.txt", winWidth, winHeight);
	}

	@Override
	public void render(Graphics g) {
		world1.render(g);
	}

	@Override
	public void update(KeyManager km) {
		world1.update(km);
	}

}
