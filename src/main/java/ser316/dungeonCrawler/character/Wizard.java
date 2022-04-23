package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

public class Wizard extends PlayerCharacter {
	
	public Wizard(Mediator m) {
		super(m);
		charClass = "Wizard";
		
		moves.add("Magic Missile");
	}
	
	/**
	 * Wizard level up
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 0;
			maxMana += 2;
			phyAtk += 0;
			mgcAtk += 2;
			phyDef += 0;
			mgcDef += 2;
			agility += 1;
			crit += 0.0;
			recoverAll();
			
			switch (level) {
			case (3):
				moves.add("Shield");
				break;
			case (6):
				moves.add("Chill Touch");
				break;
			case (9):
				moves.add("Fireball");
				break;
			}
			return true;
		}
		return false;
	}

}
