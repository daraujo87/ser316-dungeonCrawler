package ser316.dungeonCrawler.floors;

import java.util.ArrayList;

import ser316.dungeonCrawler.core.Mediator;

public class ShopFloor extends Floor {

	public ShopFloor(Mediator m, int level) {
		super(m, level);
	}

	@Override
	public void getDescription() {
		if (level == 0) {
			System.out.print("Welcome to Fallcrest!\n"
					+ "Would you like to purchase anything from the local shop or head into the dungeon?\n");
		} else {
			System.out.print("While searching level #" + level + " of the dungeon you come across a goblin merchant.\n"
					+ "Would you like to purchase anything from him or will you keep traveling?\n");
		}
	}

	@Override
	public boolean isStore() {
		return true;
	}

}
