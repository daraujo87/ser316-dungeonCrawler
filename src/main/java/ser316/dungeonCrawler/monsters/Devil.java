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
		
		moveList.add("Attack");
		if (powerLevel >= 20) {
			moveList.add("Vicious Strike");
		}
		if (powerLevel >= 30) {
			moveList.add("Hellfire");
		}
		
		fillLife();
	}
	
	@Override
	protected void sendMove(String move) {
		
		if (move.equals("Attack")) {
			System.out.println(name + " prods you with his trident.");
			mediator.notify(this, "PhyAtk");
			return;
		}
		
		if (move.equals("Vicious Strike")) {
			System.out.println(name + " attacks with demonic strenght.");
			mediator.notify(this, "CritAtk");
			return;
		}
		
		if (move.equals("Hellfire")) {
			System.out.println(name + " engulfs you in hell fire.");
			mediator.notify(this, "CritMgcAtk");
			return;
		}
		
	}
}
