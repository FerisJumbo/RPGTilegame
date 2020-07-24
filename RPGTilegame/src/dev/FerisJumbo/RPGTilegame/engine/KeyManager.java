package dev.FerisJumbo.RPGTilegame.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles key inputs so they can be read by the game
 * has every key and when pressed will update the key
 * to true, and if released, false
 * @author Cole Gartner
 *
 */
public class KeyManager implements KeyListener {
	
	private boolean[] keys; // True false array of keys
	
	// All letter keys in qwerty format
	public boolean q, w, e, r, t, y, u, i, o, p, a, s, d, f,
				g, h, j, k, l, z, x, c, v, b, n, m;
	// All number keys
	public boolean one, two, three, four, five, six, seven, eight, nine, zero;
//	// Special keys
//	public boolean tab, capsl, lShift, lCtrl, lAlt, back, enter,
//				rShift, rCtrl, rAlt;

	public KeyManager() {
		keys = new boolean[256];
	}
	
	/**
	 * Updates the public variables of the keys from the boolean array
	 */
	public void update() {
		q = keys[KeyEvent.VK_Q];
		w = keys[KeyEvent.VK_W];
		e = keys[KeyEvent.VK_E];
		r = keys[KeyEvent.VK_R];
		t = keys[KeyEvent.VK_T];
		y = keys[KeyEvent.VK_Y];
		u = keys[KeyEvent.VK_U];
		i = keys[KeyEvent.VK_I];
		o = keys[KeyEvent.VK_O];
		p = keys[KeyEvent.VK_P];
		a = keys[KeyEvent.VK_A];
		s = keys[KeyEvent.VK_S];
		d = keys[KeyEvent.VK_D];
		f = keys[KeyEvent.VK_F];
		g = keys[KeyEvent.VK_G];
		h = keys[KeyEvent.VK_H];
		j = keys[KeyEvent.VK_J];
		k = keys[KeyEvent.VK_K];
		l = keys[KeyEvent.VK_L];
		z = keys[KeyEvent.VK_Z];
		x = keys[KeyEvent.VK_X];
		c = keys[KeyEvent.VK_C];
		v = keys[KeyEvent.VK_V];
		b = keys[KeyEvent.VK_B];
		n = keys[KeyEvent.VK_N];
		m = keys[KeyEvent.VK_M];
		
		one   = keys[KeyEvent.VK_1];
		two   = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3];
		four  = keys[KeyEvent.VK_4];
		five  = keys[KeyEvent.VK_5];
		six   = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7];
		eight = keys[KeyEvent.VK_8];
		nine  = keys[KeyEvent.VK_9];
		zero  = keys[KeyEvent.VK_0];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
