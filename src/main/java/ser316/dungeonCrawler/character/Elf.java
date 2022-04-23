package ser316.dungeonCrawler.character;

public class Elf extends Character {

	public Elf() {
		super();
		baseType = "Elf";
		moves.add("Concentrate");
	}

	/**
	 * Leveling up upgrades for Elves
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

}
