package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

public class Goblinoid extends Monster {
	
	public Goblinoid(Mediator m, int powerLevel, String name) {
		super(m, powerLevel);
		
		this.name = name;
		type = "Goblinoid";
		
		maxLife = 1 + (int)(powerLevel * 1.8);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		agility = 10 + (int)(powerLevel * 0.7);
		
		moveList.add("Harass");
		if (powerLevel >= 10) {
			moveList.add("Charge");
		}
		if (powerLevel >= 20) {
			moveList.add("Crush");
		}
	}
	
	
	
	

}
