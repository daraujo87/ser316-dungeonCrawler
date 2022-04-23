package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

public class Devil extends Monster {

	public Devil (int powerLevel, String name, ArrayList<String> moveList) {
		super(powerLevel, name, moveList);
		
		maxLife = 5 + (int)(powerLevel * 2);
		phyDef = 10 + (int)(powerLevel * 0.6);
		mgcDef = 10 + (int)(powerLevel * 0.6);
		agility = 10 + (int)(powerLevel * 0.7);
		crit = 0.2;
		
		moveList.add("Attack");
		if (powerLevel >= 15) {
			moveList.add("Hellfire");
		}
	}
}
