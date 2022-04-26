package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.monsters.*;

/**
 * MonsterFactory fabricates monster objects of all types.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class MonsterFactory extends GameEntityFactory {

	/**
	 * Fabricates a random monster of the given power level
	 * @param m the mediator
	 * @param powerLevel the monster's power level
	 * @param boss if the monster is a boss
	 * @return
	 * @throws Exception
	 */
	public Monster create(Mediator m, int powerLevel, boolean boss) throws Exception {

		Monster monster;
		String name;
		
		// randomizes the monster type
		String monsterType = monsterRandomizer();

		switch (monsterType) {
		case ("Goblinoid"):
			if (powerLevel < 10) {
				name = "Goblins";
			} else {
				name = "Hobgoblins";
			}
			if (boss) {
				name = "Elite " + name;
			}
			monster = new Goblinoid(m, powerLevel, name);
			break;
		case ("Undead"):
			if (powerLevel < 10) {
				name = "Skeletons";
			} else if (powerLevel < 20) {
				name = "Ghouls";
			} else {
				name = "Vampires";
			}
			if (boss) {
				name = "Elder " + name;
			}
			monster = new Undead(m, powerLevel, name);
			break;
		case ("Devil"):
			if (powerLevel < 20) {
				name = "Imp";
			} else if (powerLevel < 30) {
				name = "Barbazu";
			} else {
				name = "Cornugon";
			}
			if (boss) {
				name = "Wicked " + name;
			}
			monster = new Devil(m, powerLevel, name);
			break;
		default:
			throw new Exception("Monster type not found.");
		}
		
		// Powers Up boss monsters
		if (boss) {
			monster.powerUp();
		}
		
		return monster;
	}
	
	/**
	 * Randomizes the monster type
	 * @return
	 */
	private String monsterRandomizer() {
		int max = 3;
		int min = 1;
		int random = ((int)(Math.random() * (max - min)) + min);
		switch (random) {
		case 1:
			return "Goblinoid";
		case 2:
			return "Undead";
		case 3:
			return "Devil";
		default:
			return "Unknown";
		}
	}

}
