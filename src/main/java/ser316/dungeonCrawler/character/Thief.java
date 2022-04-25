package ser316.dungeonCrawler.character;

public class Thief extends CharacterClass {

	public Thief(PlayerCharacter pc) {
		super(pc);
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
			phyAtk += 0;
			mgcAtk += 0;
			phyDef += 1;
			mgcDef += 1;
			agility += 2;
			crit += 0.1;
			recoverAll();
			
			switch (level) {
			case (3):
				moves.add("Mug");
				break;
			case (6):
				moves.add("Smoke Bomb");
				break;
			case (10):
				moves.add("Assassinate");
				break;
			}
			return true;
		}
		return false;
	}
	
	@Override
	protected void sendMove(String move) {
		super.sendMove(move);
		
		if (move.equals("Sneak Attack")) {
			System.out.println("You stab the enemy at a weak spot.");
			mediator.notify(this, "CritAtk");
			return;
		}
		
		if (move.equals("Mug")) {
			System.out.println("You rob the enemy as you attack.");
			// gain money
			mediator.notify(this, "PhyAtk");
			return;
		}
		
		if (move.equals("Smoke Bomb")) {
			System.out.println("You throw a smoke bomb to confuse the enemy.");
			mediator.notify(this, "Escape");
			return;
		}
		
		if (move.equals("Assassinate")) {
			System.out.println("You lunge at the enemy with a killing blow.");
			mediator.notify(this, "DeathBlow");
			return;
		}
	}
}
