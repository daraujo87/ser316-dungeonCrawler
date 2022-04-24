package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

public class Undead extends Monster {
	
	public Undead (Mediator m, int powerLevel, String name) {
		super(m, powerLevel);
		
		this.name = name;
		type = "Undead";
		
		maxLife = 1 + (int)(powerLevel * 2);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		mgcAtk = 10 + (int)(powerLevel * 0.6);
		phyDef = 12 + (int)(powerLevel * 0.6);
		mgcDef = 8 + (int)(powerLevel * 0.6);
		agility = 10 + (int)(powerLevel * 0.5);
		crit = 0.1;
		
		moveList.add("Claws");
		if (powerLevel >= 10) {
			moveList.add("Bite");
		}
		if (powerLevel >= 20) {
			moveList.add("Vampiric Touch");
		}
	}

}
