package ser316.dungeonCrawler.floors;

public class Floor {
	
	protected boolean clear;
	protected int level;
	
	public Floor (int level) {
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
