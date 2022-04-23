package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

public class Thief extends Character {

	public Thief(Mediator m) {
		super(m);
		charClass = "Thief";
		
		moves.add("Sneak Attack");
	}
	
	/**
	 * Thief level up
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 1;
			maxMana += 1;
			phyAtk += 1;
			mgcAtk += 0;
			phyDef += 1;
			mgcDef += 1;
			agility += 2;
			crit += 0.03;
			recoverAll();
			
			switch (level) {
			case (3):
				moves.add("Mug");
				break;
			case (6):
				moves.add("Smoke Bomb");
				break;
			case (9):
				moves.add("Assassinate");
				break;
			}
			return true;
		}
		return false;
	}
}
