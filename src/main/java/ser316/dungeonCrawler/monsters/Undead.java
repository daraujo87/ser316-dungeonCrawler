package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

public class Undead extends Monster {
	
	public Undead (int powerLevel, String name, ArrayList<String> moveList) {
		super(powerLevel, name, moveList);
		
		maxLife = 1 + (int)(powerLevel * 2);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		mgcAtk = 10 + (int)(powerLevel * 0.6);
		phyDef = 12 + (int)(powerLevel * 0.6);
		mgcDef = 8 + (int)(powerLevel * 0.6);
		agility = 10 + (int)(powerLevel * 0.5);
		crit = 0.1;
		
		moveList.add("Attack");
		if (powerLevel >= 10) {
			moveList.add("Vampiric Touch");
		}
	}

}
