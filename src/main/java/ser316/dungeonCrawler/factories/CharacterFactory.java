package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.character.*;
import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public class CharacterFactory extends GameEntityFactory {

	public GameEntity create(Mediator m, String characterType, String characterClass) throws Exception {

		PlayerCharacter c;

		switch (characterType) {
		case ("Human"):
			c = new Human(m);
			break;
		case ("Elf"):
			c = new Elf(m);
			break;
		case ("Dwarf"):
			c = new Dwarf(m);
			break;
		default:
			throw new Exception("Character type not found.");
		}
		
		switch (characterClass) {
		case ("Warrior"):
			c = 
		}

		return super.create(m);
	}
}
