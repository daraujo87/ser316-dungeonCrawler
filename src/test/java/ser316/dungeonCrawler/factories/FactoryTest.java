package ser316.dungeonCrawler.factories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ser316.dungeonCrawler.character.PlayerCharacter;
import ser316.dungeonCrawler.core.GameRunner;
import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.floors.Floor;
import ser316.dungeonCrawler.monsters.Monster;

public class FactoryTest {
    
    private GameEntityFactory factory;
    private Mediator m;

    @Before
    public void testSetup() {
        m = new GameRunner();
    }
    
    @Test(expected = Exception.class)
    public void testInvalidCharacterType() throws Exception {
        factory = new CharacterFactory();
        PlayerCharacter pc = ((CharacterFactory) factory).createCharacter(m, "Orc");
    }
    
    @Test(expected = Exception.class)
    public void testInvalidCharacterClass() throws Exception {
        factory = new CharacterFactory();
        PlayerCharacter pc = ((CharacterFactory) factory).createCharacter(m, "Human");
        pc = ((CharacterFactory) factory).addClass(pc, "Monk");
    }
    
    @Test
    public void testMonsterFactory() throws Exception {
        factory = new MonsterFactory();
        
        // the monster factory randomizes the output, so it's hard to make assertions
        // we'll just create a bunch instead
        
        // lv 1 monster
        Monster monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        
        // lv 10 monster
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        
        // lv 20 monster
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        
        // lv 30 monster
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
    }
    
    @Test
    public void testBossFactory() throws Exception {
        factory = new MonsterFactory();
        
        // the monster factory randomizes the output, so it's hard to make assertions
        // we'll just create a bunch instead
        
        // lv 1 monster
        Monster monster = ((MonsterFactory) factory).create(m, 1, true);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        monster = ((MonsterFactory) factory).create(m, 1, false);
        
        // lv 10 monster
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        monster = ((MonsterFactory) factory).create(m, 10, false);
        
        // lv 20 monster
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        monster = ((MonsterFactory) factory).create(m, 20, false);
        
        // lv 30 monster
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
        monster = ((MonsterFactory) factory).create(m, 30, false);
    }
    
    @Test(expected = Exception.class)
    public void testInvalidFloorType() throws Exception {
        factory = new FloorFactory();
        
        Floor floor = ((FloorFactory) factory).create(m, 1, "Mall");
    }
    
    @Test
    public void testFloorFactory() throws Exception {
        factory = new FloorFactory();
        
        // creates Fallcrest level
        Floor floor = ((FloorFactory) factory).create(m, 0);
        
        // creates wandering merchant level
        floor = ((FloorFactory) factory).create(m, 1, "Shop");
        
        // created dungeon level
        floor = ((FloorFactory) factory).create(m, 1, "Dungeon");
        
        // test randomized creation
        floor = ((FloorFactory) factory).create(m, 0); // Fallcrest
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
        floor = ((FloorFactory) factory).create(m, 1);
    }
}
