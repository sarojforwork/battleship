package com.tw.battleship.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * Enum defines the type of ship{P,Q}
 * @author tw
 *
 */
public enum ShipType {
	P("P"),
	Q("Q");

	private final String shipType;
	private final Integer strength;

	private ShipType(String shipType) {
		this.shipType = shipType;
		switch(shipType.charAt(0)) {
		case 'P' :
			this.strength= 2;
			break;
		case 'Q' :
			this.strength= 2;
			break;
		default :
			this.strength= 2;
			break;
		}
	}

	/**
	 * Cache variable to store enum values. 
	 */
	private static final Map<String, ShipType> cacheShipTypeMap = new HashMap<String, ShipType>();

	static {
		for (ShipType st : ShipType.values()) {
			cacheShipTypeMap.put(st.shipType, st);
		}
	}

	/**
	 * Method to retrieve ShipType based on value
	 * @param shipType
	 * @return
	 */
	public static ShipType getShipType(String shipType) {
		return cacheShipTypeMap.get(shipType);
	}

	public Integer getStrength() {
		return strength;
	}
	
	
}