package ser316.dungeonCrawler.character;

public class Wizard extends CharacterClass {
	
	public Wizard(PlayerCharacter pc) {
		super(pc);
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
