package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.floors.*;

public class FloorFactory extends GameEntityFactory {

	public Floor create(Mediator m, int level, String type) throws Exception {
		
		Floor floor;
		
		switch (type) {
		case("Shop"):
			floor = new ShopFloor(m, level);
			break;
		case("Infested"):
			floor = new InfestedFloor(m, level);
		break;
		default:
			throw new Exception("Floor type not found.");
		}
		
		return floor;
	}
}
