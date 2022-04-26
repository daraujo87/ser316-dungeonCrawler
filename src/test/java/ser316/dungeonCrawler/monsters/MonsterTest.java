package ser316.dungeonCrawler.monsters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ser316.dungeonCrawler.core.GameRunner;
import ser316.dungeonCrawler.core.Mediator;

public class MonsterTest {

    private Mediator m;
    private Monster monster;
    
    @Before
    public void testSetup() {
        m = new GameRunner();
    }
    
    @Test
    public void testGettersSetters() throws Exception {
        monster = new Goblinoid(m, 1, "Moblin");
        
        assertEquals(monster.getName(), "Moblin");
        assertEquals(monster.getType(), "Goblinoid");
        
        // test attributes
        assertEquals(monster.getMaxLife(), 2);
        assertEquals(monster.getCurrLife(), 2);
        assertEquals(monster.getAgility(), 10);
        assertEquals(monster.getPhyAtk(), 5);
        assertEquals(monster.getPhyDef(), 8);
        assertEquals(monster.getMgcAtk(), 5);
        assertEquals(monster.getMgcDef(), 8);
        assertEquals(monster.getCrit(), 0.1, 0.001);
    }
    
    @Test
    public void testPowerUp() throws Exception {
        monster = new Goblinoid(m, 1, "Moblin");
        
        assertEquals(monster.getMaxLife(), 2);
        monster.powerUp();
        assertEquals(monster.getMaxLife(), 3);
    }
    
    @Test
    public void testLevelUp() throws Exception {
        monster = new Goblinoid(m, 1, "Moblin");
        
        assertEquals(monster.getMaxLife(), 2);
        
        // level up to lv 10
        monster = new Goblinoid(m, 10, "Moblin");
        
        assertEquals(monster.getMaxLife(), 19);
    }
    
    @Test
    public void testDamageAndRecovery() throws Exception {
        monster = new Goblinoid(m, 10, "Moblin");
        
        // test damage
        assertEquals(monster.getCurrLife(), 19);
        assertTrue(monster.takeDamage(5));
        assertEquals(monster.getCurrLife(), 14);
        assertTrue(monster.takeDamage(-5));
        assertEquals(monster.getCurrLife(), 14);
        assertFalse(monster.takeDamage(50));    // monster is dead
        assertEquals(monster.getCurrLife(), 0);
        
        // test recovery
        monster.recoverLife(10);
        assertEquals(monster.getCurrLife(), 10);
        monster.recoverLife(-5);
        assertEquals(monster.getCurrLife(), 10);
        monster.recoverLife(100);
        assertEquals(monster.getCurrLife(), 19); // back to full life
    }
    
    @Test
    public void testGoblinoid() throws Exception {
        // already covered by Monster tests
    }
    
    @Test
    public void testUndead() throws Exception {
        monster = new Undead(m, 1, "Murray");
        monster = new Undead(m, 10, "Mordecai");
        monster = new Undead(m, 20, "Vecna");
    }
    
    @Test
    public void testDevil() throws Exception {
        monster = new Devil(m, 1, "Chip");
        monster = new Devil(m, 20, "Orcus");
        monster = new Devil(m, 30, "Asmodeus");
    }
}
