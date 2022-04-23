package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

public class Human extends Character {

	public Human(Mediator m) {
		super(m);
		baseType = "Human";
	}

	/**
	 * Humans gain 10% more experience
	 */
	@Override
	public void setExp(int exp) {
		this.exp = (int) (exp + (exp * 0.1));
	}

	/**
	 * Leveling up upgrades for Humans
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
