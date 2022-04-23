package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public abstract class GameEntityFactory {
	
	public GameEntity create(Mediator m) {
		return new GameEntity(m);
	}
}
