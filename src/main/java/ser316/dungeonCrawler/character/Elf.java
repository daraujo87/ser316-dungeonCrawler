package ser316.dungeonCrawler.character;

import ser316.dungeonCrawler.core.Mediator;

public class Elf extends PlayerCharacter {

	public Elf(Mediator m) {
		super(m);
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
	
	@Override
	protected void sendMove(String move) {
		super.sendMove(move);
		
		if (move.equals("Concentrate")) {
			System.out.println("You take a moment to regain focus.");
			recoverMana((int)(getMaxMana()/10));
			return;
		}
	}

}
