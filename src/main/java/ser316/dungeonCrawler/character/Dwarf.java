package ser316.dungeonCrawler.character;

public class Dwarf extends Character {

	public Dwarf() {
		super();
		baseType = "Dwarf";
	}

	/**
	 * Leveling up upgrades for Dwarves
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 6;
			maxMana += 1;
			phyAtk += 1;
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