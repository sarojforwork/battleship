package com.tw.battleship.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class for File operations
 * @author tw
 *
 */
public class FileUtils {

	/**
	 * Method to read file contents
	 * @param file
	 * @return delimited string of file contents
	 * @throws IOException
	 */
	public String readFile(String fileName){StringBuilder result = new StringBuilder("");
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fileName).getFile());
	
	try {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			result.append(line).append("\n");
		}
		scanner.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return result.toString();}
}
