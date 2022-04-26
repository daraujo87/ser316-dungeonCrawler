package ser316.dungeonCrawler.floors;

import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.monsters.Monster;

/**
 * Dungeon floors are used for all dungeon floors that are either infested or
 * empty.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class DungeonFloor extends Floor {

    // The monsters that inhabit the Dungeon floor
    private Monster monster;

    /**
     * Constructor.
     * 
     * @param m the mediator
     * @param level    the floor level
     */
    public DungeonFloor(Mediator m, int level) {
        super(m, level);
    }

    /**
     * Prints the floor's description.
     */
    @Override
    public void getDescription() {
        System.out.print("You explore level #" + level + " of the dungeon.\n");
        if (clear) {
            System.out.println("The floor is empty. What would you like to do?");
        } else {
            System.out.println("You encounter: " + monster.getName());
            mediator.notify(this, "Enter combat");
        }

    }

    /**
     * Setd the floor's monster.
     * 
     * @param monster the monster
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Randomizes the new contents of the floor when you revisit it It can be filled
     * with new enemies, with a traveling merchant, or still be empty.
     * 
     * @return
     */
    public String revisitFloor() {
        int max = 10;
        int min = 1;
        int random = ((int) (Math.random() * (max - min)) + min);
        switch (random) {
            case 1: // 10% chance of finding a merchant
                return "Shop";
            case 2:
            case 3: // 20% chance of finding new monsters
                return "Dungeon";
            default:
                return "Empty";
        }
    }

    /**
     * Check if the floor is a regular dungeon floor.
     * 
     * @return
     */
    @Override
    public boolean isDungeon() {
        return true;
    }

}
