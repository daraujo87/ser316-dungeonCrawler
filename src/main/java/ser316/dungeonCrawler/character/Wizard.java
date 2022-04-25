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
			crit += 0.03;
			recoverAll();
			
			switch (level) {
			case (5):
				moves.add("Chill Touch");
				break;
			case (10):
				moves.add("Fireball");
				break;
			}
			return true;
		}
		return false;
	}

	@Override
	protected void sendMove(String move) {
		super.sendMove(move);
		
		if (move.equals("Magic Missile")) {
			System.out.println("You shoot magic missiles from your hands.");
			mediator.notify(this, "MgcAtk");
			return;
		}
		
		if (move.equals("Chill Touch")) {
			System.out.println("You drain life from your enemy.");
			mediator.notify(this, "DrainAtk");
			return;
		}
		
		if (move.equals("Fireball")) {
			System.out.println("You unleash an explosive fire ball!");
			mediator.notify(this, "CritMgcAtk");
			return;
		}
	}
}
