package com.tw.battleship;

/**
 * Driver/Main class to run the battleship code
 * @author tw
 *
 */
public class Application {
	public static void main(String[] args) {
		BattleShip battleShip = new BattleShip();
		battleShip.initializeAndStartGame();
	}
}
