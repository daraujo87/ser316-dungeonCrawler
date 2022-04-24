package ser316.dungeonCrawler.character;

public class Warrior extends CharacterClass {
	
	public Warrior(PlayerCharacter pc) {
		super(pc);
		charClass = "Warrior";
		
		moves.add("Charge");
	}
	
	/**
	 * Warrior level up
	 */
	@Override
	public boolean levelUp() {
		if (super.levelUp()) {
			maxLife += 3;
			maxMana += 0;
			phyAtk += 2;
			mgcAtk += 0;
			phyDef += 2;
			mgcDef += 0;
			agility += 1;
			crit += 0.01;
			recoverAll();
			
			switch (level) {
			case (3):
				moves.add("Second Wind");
				break;
			case (6):
				moves.add("Power Attack");
				break;
			case (9):
				moves.add("Dragon Slam");
				break;
			}
			return true;
		}
		return false;
	}

}
