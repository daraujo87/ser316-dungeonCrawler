
package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.floors.*;

public class FloorFactory extends GameEntityFactory {

	public Floor create(Mediator m, int level) throws Exception {
		
		Floor floor;
		
		String type;
		if (level == 0)
			type = "Shop";
		else
			type = floorRandomizer();
		
		switch (type) {
		case("Shop"):
			floor = new ShopFloor(m, level);
			break;
		case("Dungeon"):
			floor = new DungeonFloor(m, level);
		break;
		default:
			throw new Exception("Floor type not found.");
		}
		
		return floor;
	}
	
	public Floor create(Mediator m, int level, String type) throws Exception {
		
		Floor floor;
		
		
		switch (type) {
		case("Shop"):
			floor = new ShopFloor(m, level);
			break;
		case("Dungeon"):
			floor = new DungeonFloor(m, level);
		break;
		default:
			throw new Exception("Floor type not found.");
		}
		
		return floor;
	}
	
	
	private String floorRandomizer() {
		
		int max = 10;
		int min = 1;
		int random = ((int)(Math.random() * (max - min)) + min);
		switch (random) {
		case 1:
			return "Shop";
		default:
			return "Dungeon";
		}
	}
}
