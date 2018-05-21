package com.tw.battleship.interfaces;

import com.tw.battleship.pojos.Player;

/**
 * Interface to define basic functionality of game
 * @author tw
 *
 */
public interface Game {
	public static final String FILE_NAME = "inputFile";
	
	/**
	 * this method will be used to initialize the two players of game.
	 * @param p1 - Player 1
	 * @param p2 - Player 2
	 */
	void initialize(Player p1, Player p2);
	

	/**
	 * method used to play games
	 * @param p1 - Player 1
	 * @param p2 - Player 2
	 * @return game results
	 */
	String playGame(Player p1, Player p2);
}
