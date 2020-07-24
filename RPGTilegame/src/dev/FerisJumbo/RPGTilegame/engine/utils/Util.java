package dev.FerisJumbo.RPGTilegame.engine.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Util class just has some nice utilities that the game uses
 * that dont fit really anywhere else
 * @author Cole Gartner
 *
 */
public class Util {

	/**
	 * Loads in the file from the path and will return it as a
	 * long string
	 * @param path
	 * @return
	 */
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line + " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/**
	 * Will attempt to parse a string into a number
	 * i.e. "1" > 1
	 * @param num
	 * @return
	 */
	public static int parseInt(String num) {
		try {
			return Integer.parseInt(num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
