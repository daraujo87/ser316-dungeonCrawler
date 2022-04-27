
package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.floors.DungeonFloor;
import ser316.dungeonCrawler.floors.Floor;
import ser316.dungeonCrawler.floors.ShopFloor;

/**
 * FloorFactory fabricates floor objects of all types.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class FloorFactory extends GameEntityFactory {

    /**
     * Fabricates a floor of random type.
     * 
     * @param m     the mediator
     * @param level the floor's level
     * @throws Exception for invalid parameters
     */
    public Floor create(Mediator m, int level) throws Exception {

        Floor floor;

        String type;

        // Level 0 is the town level - always a shop level
        if (level == 0) {
            type = "Shop";
        } else {
            type = floorRandomizer();
        }

        // Randomizes the floor type
        switch (type) {
            case ("Shop"):
                floor = new ShopFloor(m, level);
                break;
            case ("Dungeon"):
                floor = new DungeonFloor(m, level);
                break;
            default:
                throw new Exception("Floor type not found.");
        }

        return floor;
    }

    /**
     * Fabricates a floor of the given type.
     * 
     * @param m     the mediator
     * @param level the floor's level
     * @param type  the floor's type
     * @throws Exception for invalid parameters
     */
    public Floor create(Mediator m, int level, String type) throws Exception {

        Floor floor;

        switch (type) {
            case ("Shop"):
                floor = new ShopFloor(m, level);
                break;
            case ("Dungeon"):
                floor = new DungeonFloor(m, level);
                break;
            default:
                throw new Exception("Floor type not found.");
        }

        return floor;
    }

    /**
     * Randomizes the floor type.
     * 
     * @return
     */
    private String floorRandomizer() {

        double max = 10.1;
        double min = 1.0;
        int random = (int)((Math.random() * (max - min)) + min);
        switch (random) {
            case 1: // 10% chance of selecting Shop type
                // Skipping while items are not implemented
                //return "Shop";
            default: // 90% chance of selecting Dungeon type
                return "Dungeon";
        }
    }
}
