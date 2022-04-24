package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.character.*;
import ser316.dungeonCrawler.core.Mediator;

public class CharacterFactory extends GameEntityFactory {

	public PlayerCharacter create(Mediator m, String characterType, String characterClass) throws Exception {

		PlayerCharacter pc;

		switch (characterType) {
		case ("Human"):
			pc = new Human(m);
			break;
		case ("Elf"):
			pc = new Elf(m);
			break;
		case ("Dwarf"):
			pc = new Dwarf(m);
			break;
		default:
			throw new Exception("Character type not found.");
		}

		switch (characterClass) {
		case ("Warrior"):
			pc = new Warrior(pc);
			break;
		case ("Thief"):
			pc = new Thief(pc);
			break;
		case ("Wizard"):
			pc = new Wizard(pc);
			break;
		default:
			throw new Exception("Character class not found.");
		}

		return pc;
	}
}
