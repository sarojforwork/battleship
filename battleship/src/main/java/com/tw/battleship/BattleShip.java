package com.tw.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.tw.battleship.enums.ShipType;
import com.tw.battleship.interfaces.Game;
import com.tw.battleship.pojos.BattleArea;
import com.tw.battleship.pojos.Coordinate;
import com.tw.battleship.pojos.Player;
import com.tw.battleship.pojos.Ship;
import com.tw.battleship.utils.FileUtils;

public class BattleShip implements Game {
	private FileUtils fileUtils = new FileUtils();

	/**
	 * method to initialize and start game
	 */
	public void initializeAndStartGame() {
		Player p1 = new Player("Player-1");
		Player p2 = new Player("Player-2");

		this.initialize(p1, p2);
		this.playGame(p1, p2);

	}

	public void initialize(Player p1, Player p2) {
		Scanner scanner = new Scanner(fileUtils.readFile(Game.FILE_NAME));
		String dimensions = scanner.nextLine();
		//assign battle areas to each player

		p1.setBattleArea(getEmptyBattleArea(dimensions));
		p2.setBattleArea(getEmptyBattleArea(dimensions));

		int shipCounts = Integer.parseInt(scanner.nextLine());

		for(int i = 0 ; i < shipCounts; i++ ){
			String playerData = scanner.nextLine();
			setPlayerInformation(playerData, p1, p2);
		}
		//set Missiles for each player
		//p1.setMissiles(Arrays.asList(scanner.nextLine().split("\\s")));
		//p2.setMissiles(Arrays.asList(scanner.nextLine().split("\\s")));
		scanner.close();
	}



	private BattleArea getEmptyBattleArea(String dimensions) {
		String[] dimarr = dimensions.split(" ");
		int width = Integer.parseInt(dimarr[0]);
		int height = Integer.parseInt(dimarr[1]);
		int xcoordinate = 0;
		char ycoordinate = 'A';
		Map<Coordinate, String> areaMap = new HashMap<Coordinate, String>(); 

		int i;
		char a;

		//
		for(i =  xcoordinate; i< width;i++){
			for(a = ycoordinate; a < height;a++){
				areaMap.put(new Coordinate(i, a), "");				
			}
		}
		BattleArea battleArea = new BattleArea(areaMap);
		return battleArea;
	}

	/**
	 * Set players information
	 * @param playerData
	 * @param p1 - player 1
	 * @param p2 - player 2
	 */
	private void setPlayerInformation(String playerData, Player p1, Player p2 ){
		String []dataArray = playerData.split("\\s");
		setPlayerInformation(dataArray,p1,true);
		setPlayerInformation(dataArray,p2,false);

	}


	/**
	 * Set player information based on its coordinate and ship description
	 * @param dataArray - contains SHIPTYPE{P,Q}, Width, Height and player YX coordinate
	 * @param player
	 * @param isFirstPlayer
	 */
	private void setPlayerInformation(String []dataArray, Player player, boolean isFirstPlayer){
		String shipType = dataArray[0];
		int width = Integer.parseInt(dataArray[1]);
		int height = Integer.parseInt(dataArray[2]);
		String xyStartcoordinate = isFirstPlayer ? dataArray[3] : dataArray[4];

		char ycoordinate = xyStartcoordinate.charAt(0);
		int incrementYValue = ycoordinate + height;

		int xcoordinate = Character.getNumericValue(xyStartcoordinate.charAt(1));
		int incrementXValue = xcoordinate + width;

		int i;
		char a;

		List<Coordinate> coordinates = new ArrayList<Coordinate>(); 
		for(i =  xcoordinate; i< incrementXValue;i++){
			{
				for(a = ycoordinate; a < incrementYValue;a++){
					coordinates.add(new Coordinate(i, a));
					//create and place ships in battle area
					//Ship ship = new Ship(ShipType.getShipType(shipType),i,a);
					player.placeShip(coordinates,ShipType.getShipType(shipType), String.valueOf(a+""+i).toUpperCase());
					//player.getPlayerShips().put(String.valueOf(a+""+i).toUpperCase(), ship);
					//System.out.println(""+a+""+i);
				}
			}
		}

	}


	public String playGame(Player p1, Player p2) {
		//first turn 
		//while player can fire missiles
		//check playerName.ifhit(), launchMissile(), hasMissiles(), hasShips();

		//checking to see if class file gets commited
		Player currentPlayer = p1;
		Player opponent = p2;
		/*		while(true) {
			//if(curren)

			if(currentPlayer.hasMissiles()) {
				Coordinate fireCoordinate = currentPlayer.launchMissile();
				if(opponent.hitShip(fireCoordinate)) {
					continue;
				} else {
					Player temp = opponent;
					opponent = currentPlayer;
					currentPlayer = temp;
				}				
			} else {

			}
		}
		 */
		String results = "";
		/*Iterator<String> p1Iterator = p1.getMissiles().iterator();
		Iterator<String> p2Iterator = p2.getMissiles().iterator();

		while(true)
		{
			// player-1 fire missile on player 2 
			while (p1Iterator.hasNext() && !p2.getPlayerShips().isEmpty()) {
				String coordinate = p1Iterator.next().toUpperCase();
				if(!fireMissile(p2, coordinate, p1.getPlayerName())) break;
			}

			// player-2 fire missile on player 1 
			while (p2Iterator.hasNext() && !p1.getPlayerShips().isEmpty()) {
				String coordinate = p2Iterator.next().toUpperCase();
				if(!fireMissile(p1, coordinate, p2.getPlayerName())) break;

			}

			// select winner 
			if(p1.getPlayerShips().isEmpty()){
				results = p2.getPlayerName()+" won the battle";
				System.out.println(results);
				break;
			}
			if(p2.getPlayerShips().isEmpty()){
				results = p1.getPlayerName()+" won the battle";
				System.out.println(results);
				break;

			}else if(!(p1Iterator.hasNext()) && !(p2Iterator.hasNext())){
				results = "Draw";
				System.out.println("Draw");
				break;
			}



			//Check player-1 missiles
			if(!(p1Iterator.hasNext()) && !p2.getPlayerShips().isEmpty()){
				System.out.println(p1.getPlayerName() + " has no more missiles left to launch");
			}

			//Check player-2 missiles
			if(!(p2Iterator.hasNext()) && !p1.getPlayerShips().isEmpty()){
				System.out.println(p2.getPlayerName()+ " has no more missiles left to launch");
			}

		}
		 */

		return results;
	}

	/**
	 * Method to fire missile.
	 * @param targetPlayer - target player
	 * @param coordinate - missile coordinate 
	 * @param srcPlayerName - player name which fire's missile
	 * @return true - when missile hits target player's ship
	 */
	private boolean fireMissile(Player targetPlayer, String coordinate,String srcPlayerName){
		boolean isShipHit = false;

		//check any ship falls in the coordinate
		if(null != targetPlayer.getPlayerShips().get(coordinate)){
			isShipHit = true;
			Ship ship = targetPlayer.getPlayerShips().get(coordinate);

			//check the ShipType
			if(ship.getShipType().toString().equalsIgnoreCase("Q")){
				ship.setShipType(ShipType.getShipType("P"));
			}else{
				targetPlayer.getPlayerShips().remove(coordinate);
			}
			System.out.println(srcPlayerName +" fires a missile with target "+coordinate+" which got hit");
		}
		else{
			System.out.println(srcPlayerName +" fires a missile with target "+coordinate+" which got miss");
		}

		return isShipHit;
	}

}
