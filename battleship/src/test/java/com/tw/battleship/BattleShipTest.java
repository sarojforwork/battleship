package com.tw.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.battleship.pojos.Player;

public class BattleShipTest {
	private Player p1;
	private Player p2;
	private BattleShip bs;
	
	@Before
	public void setup() {
		p1 = new Player("Player-1");
		p2 = new Player("Player-2");
		
		bs = new BattleShip();
		
		bs.initialize(p1, p2);

	}
	
	@Test
	public void initializePlayerTest(){
		
		Assert.assertNotNull(p1.getPlayerName());
		Assert.assertNotNull(p1.getPlayerShips());
		Assert.assertNotNull(p1.getMissiles());
		
		Assert.assertNotNull(p2.getPlayerName());
		Assert.assertNotNull(p2.getPlayerShips());
		Assert.assertNotNull(p2.getMissiles());
		
	}
	
	@Test
	public void playGameTest(){
		Assert.assertEquals(p2.getPlayerName()+" won the battle", bs.playGame(p1, p2));
	}
	
	

}
