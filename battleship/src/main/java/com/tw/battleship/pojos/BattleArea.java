package com.tw.battleship.pojos;

import java.util.Map;

public class BattleArea {
	
	private Map<Coordinate, String> areaMap;

	public BattleArea(Map<Coordinate, String> areaMap) {
		super();
		this.areaMap = areaMap;
	}

	public Map<Coordinate, String> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Map<Coordinate, String> areaMap) {
		this.areaMap = areaMap;
	}

	public void occupyArea(Coordinate coordinate, String ship) {
		areaMap.put(coordinate, ship);
	}

	public boolean hasShipAt(Coordinate fireCoordinate) {
		return false;
	}

	public String getShipAt(Coordinate fireCoordinate) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeOccupiedCoordinate(Coordinate fireCoordinate) {
		// TODO Auto-generated method stub
		
	}
	

}