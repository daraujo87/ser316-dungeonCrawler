package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Dwarf is one of the character types that can be picked during creation
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class Dwarf extends PlayerCharacter {

	/**
	 * Constructor
	 * @param m the mediator
	 */
	public Dwarf(Mediator m) {
		super(m);
		baseType = "Dwarf";
	}

	/**
	 * Level up progression for Dwarves
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 6;
			maxMana += 1;
			phyAtk += 2;
			mgcAtk += 1;
			phyDef += 2;
			mgcDef += 1;
			agility += 1;
			recoverAll();
			return true;
		}
		return false;
	}
	
	/**
	 * Dwarves take 10% less damage
	 */
	@Override
	public void takeDamage(int amount) {
		int reducedAmount = (int)(amount * 0.9);
		super.takeDamage(reducedAmount);
	}
}
