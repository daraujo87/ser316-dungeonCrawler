package ser316.dungeonCrawler.floors;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public class Floor extends GameEntity{
	
	protected boolean clear;
	protected int level;
	
	public Floor (Mediator mediator, int level) {
		super(mediator);
		
		clear = false;
		this.level = level;
	}
	
	public void clear() {
		clear = true;
	};
	
	public boolean isClear() {
		return clear;
	}
	
	public void getDescription() {
		// Override on subclasses
	}

}