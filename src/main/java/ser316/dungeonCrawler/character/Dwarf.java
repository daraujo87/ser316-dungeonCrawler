package ser316.dungeonCrawler.character;

public class Dwarf extends Character {

	public Dwarf() {
		super();

		baseType = "Dwarf";

		moves.add("Iron Skin");
	}

	/**
	 * Leveling up upgrades for Dwarves
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 7;
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
}
