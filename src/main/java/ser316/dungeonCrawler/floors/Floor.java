package ser316.dungeonCrawler.floors;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

/**
 * Floor is the abstract class that is used as the basis for other all floor
 * types (Shop and Dungeon). Using a Decorator design pattern a floor sub type
 * will be later added on top of the base floor.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public abstract class Floor extends GameEntity {

    // Attributes
    protected boolean clear;
    protected int level;

    /**
     * Constructor.
     * 
     * @param mediator the mediator
     * @param level    the floor level
     */
    public Floor(Mediator mediator, int level) {
        super(mediator);

        clear = false;
        this.level = level;
    }

    /**
     * Sets the floor to "clear of monsters".
     */
    public void clear() {
        clear = true;
    }

    /**
     * Checks if the floor is clear of monsters.
     * 
     * @return
     */
    public boolean isClear() {
        return clear;
    }

    /**
     * Prints the floor's description.
     */
    public void getDescription() {
        // Override on subclasses
    }

    /**
     * Check if the floor is a shop floor.
     * 
     * @return
     */
    public boolean isStore() {
        if (this instanceof ShopFloor) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the floor is a regular dungeon floor.
     * 
     * @return
     */
    public boolean isDungeon() {
        if (this instanceof DungeonFloor) {
            return true;
        } else {
            return false;
        }
    }

}
