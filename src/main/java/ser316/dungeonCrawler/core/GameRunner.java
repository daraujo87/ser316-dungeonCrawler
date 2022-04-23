package ser316.dungeonCrawler.core;

import java.util.LinkedList;

import ser316.dungeonCrawler.floors.Floor;
import ser316.dungeonCrawler.floors.ShopFloor;

public class GameRunner implements Mediator {
	
	private LinkedList<Floor> floors;
	private int currentFloor;
	private Character player;
	
	public GameRunner() {
		floors = new LinkedList<>();
	}
	
	@Override
	public void notify(GameEntity entity, String event) {
		// TODO Auto-generated method stub

	}

}
