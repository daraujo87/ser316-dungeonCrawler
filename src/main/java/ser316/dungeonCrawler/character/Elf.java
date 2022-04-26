package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Elf is one of the character types that can be picked during creation
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class Elf extends PlayerCharacter {

	/**
	 * Constructor
	 * @param m the mediator
	 */
	public Elf(Mediator m) {
		super(m);
		baseType = "Elf";
		moves.add("Concentrate");
	}

	/**
	 * Level up progression for Elves
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 4;
			maxMana += 3;
			phyAtk += 1;
			mgcAtk += 2;
			phyDef += 1;
			mgcDef += 2;
			agility += 2;
			recoverAll();
			return true;
		}
		return false;
	}
	
	/**
	 * Elves have the Concentrate move that recovers 20% mana
	 */
	@Override
	protected void sendMove(String move) {
		super.sendMove(move);
		
		if (move.equals("Concentrate")) {
			System.out.println("You take a moment to regain focus.");
			recoverMana((int)(getMaxMana()/5));
			return;
		}
	}

}
