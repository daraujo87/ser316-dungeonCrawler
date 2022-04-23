package ser316.dungeonCrawler.floors;

import java.util.ArrayList;

public class ShopFloor extends Floor {

	private ArrayList<String> inventory;
	
	public ShopFloor(int level) {
		super(level);
		inventory = new ArrayList<>();
		populate();
	}
	
	@Override
	public void getDescription() {
		System.out.print(
				"Welcome back to town!\n"
				+ "Would you like to purchase anything from the local shop?\n"
				+ "Current wares:\n"
				);
		int i = 1;
		for (String item : inventory) {
			System.out.println(i + " - " + item);
		}
	}
	
	public String purchase(int index) {
		if (inventory.size() >= index) {
			return null;
		}
		return inventory.get(index -1);
	}
	
	public void populate() {
		// TODO fill in product list
	}
	
	private String getItem() {
		// TODO retrieve items from collection
		return null;
	}

}
