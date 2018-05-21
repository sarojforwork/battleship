package com.tw.battleship.pojos;

public class Coordinate {
	/**
	 * Represents x coordinate [1 to 9]
	 */
	private Integer xCoordinate;
	
	/**
	 * Represents y coordinate [A to Z]
	 */
	private Character yCoordinate;

	
	public Coordinate(Integer xCoordinate, Character yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	public Integer getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public Character getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(Character yCoordinate) {
		this.yCoordinate = yCoordinate;
	}


}
