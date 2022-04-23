package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

public class Goblinoid extends Monster {
	
	public Goblinoid(int powerLevel, String name, ArrayList<String> moveList) {
		super(powerLevel, name, moveList);
		
		maxLife = 1 + (int)(powerLevel * 1.8);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		agility = 10 + (int)(powerLevel * 0.7);
		
		moveList.add("Attack");
		if (powerLevel >= 10) {
			moveList.add("Swarm");
		}
	}

}
