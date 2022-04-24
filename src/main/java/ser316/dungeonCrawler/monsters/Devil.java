package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

public class Devil extends Monster {

	public Devil (Mediator m, int powerLevel, String name) {
		super(m, powerLevel);
		
		this.name = name;
		type = "Devil";
		
		maxLife = 5 + (int)(powerLevel * 2);
		phyDef = 10 + (int)(powerLevel * 0.6);
		mgcDef = 10 + (int)(powerLevel * 0.6);
		agility = 10 + (int)(powerLevel * 0.7);
		crit = 0.2;
		
		moveList.add("Prod");
		if (powerLevel >= 20) {
			moveList.add("Vicious Strike");
		}
		if (powerLevel >= 30) {
			moveList.add("Hellfire");
		}
	}
}
