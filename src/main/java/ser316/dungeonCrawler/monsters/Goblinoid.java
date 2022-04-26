package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Goblinoids are the weakest but most prolific monster types
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class Goblinoid extends Monster {
	
	/**
	 * Constructor
	 * @param m the mediator
	 * @param powerLevel the Monster's power level
	 * @param name the Monster's name
	 */
	public Goblinoid(Mediator m, int powerLevel, String name) {
		super(m, powerLevel);
		
		this.name = name;
		type = "Goblinoid";
		
		maxLife = 1 + (int)(powerLevel * 1.8);
		phyAtk = 5 + (int)(powerLevel * 0.5);
		mgcAtk = 5 + (int)(powerLevel * 0.5);
		agility = 10 + (int)(powerLevel * 0.7);
		
		// Adds the goblinoid's moves based on its power level
		moveList.add("Attack");
		if (powerLevel >= 10) {
			moveList.add("Charge");
		}
		
		fillLife();
	}
	
	/**
	 * Sends the combat move to the mediator
	 * @param move
	 */
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
