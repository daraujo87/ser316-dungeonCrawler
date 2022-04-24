package ser316.dungeonCrawler.floors;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.monsters.Monster;

public class DungeonFloor extends Floor {
	
	private Monster monster;
	public DungeonFloor(Mediator m, int level) {
		super(m, level);
		
		m.notify(this, "Setup Monster");
	}
	
	@Override
	public void getDescription() {
		System.out.print("You explore level #" + level + " of the dungeon.\n");
		if (clear) {
			System.out.println("The floor is empty. What would you like to do?");
		} else {
			System.out.println("You encounter: " + monster.getName());
		}
			
	}
	
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	public String revisitFloor(int playerLevel) {
		int max = 10;
		int min = 1;
		int random = ((int)(Math.random() * (max - min)) + min);
		switch (random) {
		case 1:
			return "Shop";
		case 2:
		case 3:
			return "Dungeon";
		default:
			return "Empty";
		}
	}
	
	@Override
	public boolean isDungeon() {
		return true;
	}

}
