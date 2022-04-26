package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Human is one of the character types that can be picked during creation
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class Human extends PlayerCharacter {

	/**
	 * Constructor
	 * @param m the mediator
	 */
	public Human(Mediator m) {
		super(m);
		baseType = "Human";
	}

	/**
	 * Humans gain 10% more experience
	 */
	@Override
	public void gainExp(int exp) {
		int newExp = (int) (exp + (exp * 0.1));
		super.gainExp(newExp);
	}

	/**
	 * Level up progression for Humans
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 5;
			maxMana += 2;
			phyAtk += 1;
			mgcAtk += 1;
			phyDef += 1;
			mgcDef += 1;
			agility += 1;
			recoverAll();
			return true;
		}
		return false;
	}
}
