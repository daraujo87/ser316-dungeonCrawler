package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.monsters.*;

public class MonsterFactory extends GameEntityFactory {

	public Monster create(Mediator m, int powerLevel, boolean boss) throws Exception {

		Monster monster;
		String name;
		
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
		
		if (boss) {
			monster.powerUp();
		}
		
		return monster;
	}
	
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
