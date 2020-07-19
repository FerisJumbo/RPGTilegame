package dev.FerisJumbo.RPGTilegame.engine.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame display;
	private Canvas canvas;
	
	private String gameTitle;
	private int width, height;

	public Display(String title, int width, int height) {
		this.gameTitle = title;
		this.width = width;
		this.height = height;
		
		initDisplay();
	}
	
	private void initDisplay() {
		display = new JFrame(gameTitle);
		display.setSize(width, height);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setResizable(false);
		display.setLocationRelativeTo(null);
		display.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		display.add(canvas);
		display.pack();
		
	}
	
	// Getters and Setters \\

	public JFrame getDisplay() {
		return display;
	}

	public void setDisplay(JFrame display) {
		this.display = display;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
