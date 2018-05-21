package com.tw.battleship.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tw.battleship.enums.ShipType;


/**
 * Class defines the Player information(name, ships and missiles)
 * @author tw
 *
 */
public class Player{
	/**
	 * Defines name of player
	 */
	private String playerName;

	/*
	 * 
	 */
	private BattleArea battleArea;
	
	/**
	 * variable defines the ship 
	 * KEY - Coordinate of Ship
	 * Value - complete Ship information
	 */
	Map<String, Ship> playerShips;
	
	/**
	 * list of missiles assigned to player
	 */
	private List<Missile> missiles;
	
	
	
	
	public Player(String playerName) {
		this.playerName = playerName;
		playerShips = new HashMap<String, Ship>();
		missiles= new ArrayList<Missile>();
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<Missile> getMissiles() {
		return missiles;
	}
	public void setMissiles(List<Missile> missiles) {
		this.missiles = missiles;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}
	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}
	

	public Map<String, Ship> getPlayerShips() {
		return playerShips;
	}
	public void setPlayerShips(Map<String, Ship> playerShips) {
		this.playerShips = playerShips;
	}
	
	public void placeShip(List<Coordinate> coordinates, ShipType shipType, String shipName ) {
		Map<Coordinate, Integer> activeLocation = new HashMap<Coordinate, Integer>();
		for(Coordinate coordinate : coordinates ) {
			activeLocation.put(coordinate, shipType.getStrength());
			battleArea.occupyArea(coordinate, shipName);
		}
		Ship ship = new Ship(shipType, activeLocation);
		playerShips.put(shipName, ship);
	}
	
	public boolean hasMissiles() {
		return !missiles.isEmpty();
	}
	
	public Coordinate launchMissile() {
		if(!missiles.isEmpty())
			return missiles.remove(0).fireCoordinate;
		return null;
	}
	
	public boolean hitShip(Coordinate fireCoordinate) {
		if(battleArea.hasShipAt(fireCoordinate)) {
			String shipName = battleArea.getShipAt(fireCoordinate);
			if(playerShips.get(shipName).getCoordinateStrength(fireCoordinate)>1) {
				Ship ship = playerShips.get(shipName);
				ship.reduceStrengthOfCoordinate(fireCoordinate);
				playerShips.put(shipName, ship);
			} else {
				playerShips.remove(shipName);
				battleArea.removeOccupiedCoordinate(fireCoordinate);
			}			
			return true;
		}
		return false;
	}
}
