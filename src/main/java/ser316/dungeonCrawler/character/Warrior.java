package ser316.dungeonCrawler.character;

public class Warrior extends CharacterClass {
	
	public Warrior(PlayerCharacter pc) {
		super(pc);
		charClass = "Warrior";
		
		moves.add("Attack");
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
			crit += 0.05;
			recoverAll();
			
			switch (level) {
			case (5):
				moves.add("Second Wind");
				break;
			case (10):
				moves.add("Power Attack");
				break;
			}
			return true;
		}
		return false;
	}

	@Override
	protected void sendMove(String move) {
		super.sendMove(move);
		
		if (move.equals("Attack")) {
			System.out.println("You attack with your weapon.");
			mediator.notify(this, "PhyAtk");
			return;
		}
		
		if (move.equals("Second Wind")) {
			System.out.println("You take a moment to recompose yourself.");
			recoverLife((int)(currLife/5));
			return;
		}
		
		if (move.equals("Power Attack")) {
			System.out.println("You unleash a powerful attack!");
			mediator.notify(this, "CritAtk");
			return;
		}
	}
}
