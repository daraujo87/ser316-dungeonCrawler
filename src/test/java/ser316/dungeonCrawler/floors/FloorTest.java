package ser316.dungeonCrawler.floors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ser316.dungeonCrawler.core.GameRunner;
import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.factories.FloorFactory;
import ser316.dungeonCrawler.monsters.Goblinoid;

public class FloorTest {

    private Mediator m;
    private Floor floor;
    private FloorFactory floorFactory;
    
    @Before
    public void testSetup() {
        m = new GameRunner();
        floorFactory = new FloorFactory();
    }
    
    @Test
    public void testFloor() throws Exception {
        floor = floorFactory.create(m, 0);
        
        assertFalse(floor.isClear());
        floor.clear();
        assertTrue(floor.isClear());
        
        assertTrue(floor.isStore());
        assertFalse(floor.isDungeon());
        
        floor = floorFactory.create(m, 1, "Dungeon");
        
        assertFalse(floor.isStore());
        assertTrue(floor.isDungeon());
    }
    
    @Test
    public void testShop() throws Exception {
        // test Fallcrest description
        floor = floorFactory.create(m, 0);
        floor.getDescription();
        
        // test wandering merchant description
        floor = floorFactory.create(m, 1, "Shop");
        floor.getDescription();
    }
    
    @Test
    public void testDungeon() throws Exception {
        floor = floorFactory.create(m, 1, "Dungeon");
        ((DungeonFloor) floor).setMonster(new Goblinoid(m, 1, "Moblin"));
        
        // test floor description prints
        // can't test floor description because mediator is not running game
        //floor.getDescription();
        floor.clear();
        floor.getDescription();
        
        // test revisit floor
        // because this method's output is random, assertions will not work properly
        // we will just call it a bunch instead
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
        ((DungeonFloor) floor).revisitFloor();
    }
}
