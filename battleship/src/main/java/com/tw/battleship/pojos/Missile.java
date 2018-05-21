package com.tw.battleship.pojos;

public class Missile {
	
	Coordinate fireCoordinate;

	public Missile(Coordinate fireCoordinate) {
		super();
		this.fireCoordinate = fireCoordinate;
	}

	public Coordinate getFireCoordinate() {
		return fireCoordinate;
	}

	public void setFireCoordinate(Coordinate fireCoordinate) {
		this.fireCoordinate = fireCoordinate;
	}
}
