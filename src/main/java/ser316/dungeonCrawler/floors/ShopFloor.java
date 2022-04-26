package ser316.dungeonCrawler.floors;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Shop floors are used for the town level (0) or levels with wandering
 * merchants.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class ShopFloor extends Floor {

    /**
     * Constructor.
     * 
     * @param m the mediator
     * @param level    the floor level
     */
    public ShopFloor(Mediator m, int level) {
        super(m, level);
    }

    /**
     * Prints the floor's description.
     */
    @Override
    public void getDescription() {
        if (level == 0) {
            System.out.print("Welcome to Fallcrest!\n"
                    + "Would you like to purchase anything from the local shop or "
                    + "head into the dungeon?\n");
        } else {
            System.out.print("While searching level #" + level + " of the dungeon "
                    + "you come across a goblin merchant.\n"
                    + "Would you like to purchase anything from him "
                    + "or will you keep traveling?\n");
        }
    }

    /**
     * Check if the floor is a shop floor.
     * 
     * @return
     */
    @Override
    public boolean isStore() {
        return true;
    }

}
