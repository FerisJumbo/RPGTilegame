package dev.FerisJumbo.RPGTilegame.engine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.FerisJumbo.RPGTilegame.Assets;
import dev.FerisJumbo.RPGTilegame.engine.display.Display;
import dev.FerisJumbo.RPGTilegame.states.GameState;

/**
 * 
 * @author Cole Gartner
 *
 */
public class GameEngine implements Runnable{
	
	public String title; // Title of the game
	public int width, height, tilesize; // height and width of the window
	
	private boolean running; // Determines whether the game loop runs or not
	private Thread gameThread; // Game Thread
	
	private Display display; // The actual display to render to the computer
	
	// The buffer strategy controls the buffer screens before drawing to the screen
	// this prevents flickering
	private BufferStrategy bs; 
	private Graphics g; // Graphics object that gives the display canvas information to draw
	
	/**
	 * The Game Engine class handles the different states update and render methods
	 * it is the main hub for variable changes and display this information to the
	 * screen for the user to see.
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public GameEngine(String title, int width, int height, int tilesize) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.tilesize = tilesize;
	}
	
	// Used to init variables
	private void init() {
		Assets.init();
		running = true;
		display = new Display(title, width, height);
		State.currentState = new GameState(width, height);
	}

	// Runs the game loop
	public void run() {
		init();
		
		// These variables keep track of making sure that the fps stays
		// Consistent for all computers
		int FPS = 60;
		double timePerUpdate = 1000000000 / FPS;
		double deltaTime = 0;
		long now;
		long lastTime = System.nanoTime();
		
		// Game Loop
		while (running) {
			// FPS works by getting the delta of now and last and dividing that by the
			// nano seconds to ensure that it reaches the desired fps
			now = System.nanoTime();
			deltaTime += (now - lastTime) / timePerUpdate;
			lastTime = now;
			
			// As soon as one frame is able to go the game updates and renders
			if (deltaTime >= 1) {
				update();
				render();
				deltaTime--;
			}
		}
		
		stop();
	}
	
	// Updates variables values that are assigned to the current state
	private void update() {
		// Will update the current states update method if not null
		if (State.currentState != null) {
			State.currentState.update();
		}
	}
	
	// Renders all images to the screen
	private void render() {
		// Gets the buffer strategy
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) { // Creates a buffer strategy of 3 if none (Buffer > Buffer > Screen)
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clear Screen
		g.clearRect(0, 0, width, height);
		
		// Begin Draw
		
		// Will draw the current states render method if not null
		if (State.currentState != null) {
			State.currentState.render(g);
		}
		
		// End Draw
		
		bs.show();
		g.dispose();
	}
	
	
	
	// THREAD RUNNING \\
	
	// Used to start the Thread, but makes sure the thread has not already started
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	// Kills the thread and stops the game loop
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
