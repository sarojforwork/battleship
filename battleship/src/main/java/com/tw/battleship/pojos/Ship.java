package com.tw.battleship.pojos;

import java.util.Map;

import com.tw.battleship.enums.ShipType;

/**
 * Represents basic attributes of battle ship
 * @author tw
 *
 */
public class Ship {
	
	/**
	 * Represents Ship Type like {‘P’, ‘Q’}
	 */
	private String shipName;
	
	private ShipType shipType;
	
	private Map<Coordinate, Integer> activeLocation;
	
	
	public ShipType getShipType() {
		return shipType;
	}
	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
	
	public Ship(ShipType shipType, Map<Coordinate, Integer> activeLocation) {
		super();
		this.shipType = shipType;
		this.activeLocation = activeLocation;
	}
	public Map<Coordinate, Integer> getActiveLocation() {
		return activeLocation;
	}
	public void setActiveLocation(Map<Coordinate, Integer> activeLocation) {
		this.activeLocation = activeLocation;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getCoordinateStrength(Coordinate coordinate) {
		return activeLocation.get(coordinate);
	}
	
	public void reduceStrengthOfCoordinate(Coordinate fireCoordinate) {
		// TODO Auto-generated method stub
		
	}
	
	

}
