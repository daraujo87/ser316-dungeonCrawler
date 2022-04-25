package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

public class Goblinoid extends Monster {
	
	public Goblinoid(Mediator m, int powerLevel, String name) {
		super(m, powerLevel);
		
		this.name = name;
		type = "Goblinoid";
		
		maxLife = 1 + (int)(powerLevel * 1.8);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		mgcAtk = 5 + (int)(powerLevel * 0.5);
		agility = 10 + (int)(powerLevel * 0.7);
		
		moveList.add("Attack");
		if (powerLevel >= 10) {
			moveList.add("Charge");
		}
		
		fillLife();
	}
	
	@Override
	protected void sendMove(String move) {
		
		if (move.equals("Attack")) {
			System.out.println(name + " throw stones and shoot arrows at you.");
			mediator.notify(this, "PhyAtk");
			return;
		}
		
		if (move.equals("Charge")) {
			System.out.println(name + " rush and swarm you.");
			mediator.notify(this, "CritAtk");
			return;
		}
	}
}
