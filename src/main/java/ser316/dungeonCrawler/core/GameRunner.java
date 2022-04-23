package ser316.dungeonCrawler.core;

import java.util.LinkedList;

import ser316.dungeonCrawler.floors.*;
import ser316.dungeonCrawler.character.*;
import ser316.dungeonCrawler.character.Character;

public class GameRunner implements Mediator {

	private LinkedList<Floor> floors;
	private int currentFloor;
	private Character player;

	public GameRunner(int playerType, int playerClass) {
		floors = new LinkedList<>();
		// TODO add floor factory call
		// TODO add player factory call
	}

	@Override
	public void notify(GameEntity entity, String event) {
		// TODO Auto-generated method stub

	}

}
