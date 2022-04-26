package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.character.*;
import ser316.dungeonCrawler.core.Mediator;

/**
 * CharacterFactory fabricates character objects of all types.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class CharacterFactory extends GameEntityFactory {

	/**
	 * Fabricates a base character of the given type
	 * @param m the mediator
	 * @param characterType the character's type
	 * @return
	 * @throws Exception
	 */
	public PlayerCharacter createCharacter(Mediator m, String characterType) throws Exception {

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
		
		return pc;
	}
	
	/**
	 * Sets the character's class
	 * @param pc
	 * @param characterClass
	 * @return
	 * @throws Exception
	 */
	public PlayerCharacter addClass(PlayerCharacter pc, String characterClass) throws Exception {

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
