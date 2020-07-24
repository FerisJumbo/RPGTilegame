package dev.FerisJumbo.RPGTilegame.engine.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * The actual display using JFrame and Canvas to put images
 * onto the screen
 * @author Cole Gartner
 *
 */
public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String gameTitle;
	private int width, height; // Screen width and height

	/**
	 * Constructs the display, their should only be one display
	 * object declared in the game engine
	 * @param title
	 * @param width
	 * @param height
	 */
	public Display(String title, int width, int height) {
		this.gameTitle = title;
		this.width = width;
		this.height = height;
		
		initDisplay();
	}
	
	/**
	 * Initializes the display and sets needed settings to
	 * operate
	 */
	private void initDisplay() {
		frame = new JFrame(gameTitle);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	// Getters and Setters \\

	public JFrame getFrame() {
		return frame;
	}

	public void setGrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
