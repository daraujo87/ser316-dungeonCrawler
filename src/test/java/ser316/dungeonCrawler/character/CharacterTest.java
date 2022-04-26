package ser316.dungeonCrawler.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ser316.dungeonCrawler.core.GameRunner;
import ser316.dungeonCrawler.core.Mediator;
import ser316.dungeonCrawler.factories.CharacterFactory;

public class CharacterTest {

    private Mediator m;
    private PlayerCharacter pc;
    private CharacterFactory charFactory;
    
    @Before
    public void testSetup() {
        m = new GameRunner();
        charFactory = new CharacterFactory();
    }
    
    @Test
    public void testCharacterCreation() throws Exception {
        
        pc = charFactory.createCharacter(m, "Human");
        pc = charFactory.addClass(pc, "Warrior");
        assertTrue(pc instanceof Warrior);
        assertTrue(pc.getType().equals("Human"));
        
        pc = charFactory.createCharacter(m, "Elf");
        pc = charFactory.addClass(pc, "Thief");
        assertTrue(pc instanceof Thief);
        assertTrue(pc.getType().equals("Elf"));
        
        pc = charFactory.createCharacter(m, "Dwarf");
        pc = charFactory.addClass(pc, "Wizard");
        assertTrue(pc instanceof Wizard);
        assertTrue(pc.getType().equals("Dwarf"));
    }
    
    @Test
    public void testGettersSetters() throws Exception {
        
        pc = charFactory.createCharacter(m, "Human");
        pc = charFactory.addClass(pc, "Warrior");
        
        // Test equipment
        pc.setAccessory("Ring");
        assertEquals(pc.getAccessory(), "Ring");
        pc.setArmor("Chainmail");
        assertEquals(pc.getArmor(), "Chainmail");
        pc.setWeapon("Broadsword");
        assertEquals(pc.getWeapon(), "Broadsword");
        
        // Test physical attributes
        pc.setAgility(10);
        pc.setBonusAgility(5);
        assertEquals(pc.getAgility(), 10);
        assertEquals(pc.getBonusAgility(), 5);
        assertEquals(pc.getTotalAgility(), 15);
        
        pc.setPhyAtk(10);
        pc.setBonusPhyAtk(5);
        assertEquals(pc.getPhyAtk(), 10);
        assertEquals(pc.getBonusPhyAtk(), 5);
        assertEquals(pc.getTotalPhyAtk(), 15);
        
        pc.setPhyDef(10);
        pc.setBonusPhyDef(5);
        assertEquals(pc.getPhyDef(), 10);
        assertEquals(pc.getBonusPhyDef(), 5);
        assertEquals(pc.getTotalPhyDef(), 15);
        
        pc.setMgcAtk(10);
        pc.setBonusMgcAtk(5);
        assertEquals(pc.getMgcAtk(), 10);
        assertEquals(pc.getBonusMgcAtk(), 5);
        assertEquals(pc.getTotalMgcAtk(), 15);
        
        pc.setMgcDef(10);
        pc.setBonusMgcDef(5);
        assertEquals(pc.getMgcDef(), 10);
        assertEquals(pc.getBonusMgcDef(), 5);
        assertEquals(pc.getTotalMgcDef(), 15);
        
        pc.setCrit(0.5);
        pc.setBonusCrit(0.1);
        assertEquals(pc.getCrit(), 0.5, 0.001);
        assertEquals(pc.getBonusCrit(), 0.1, 0.001);
        assertEquals(pc.getTotalCrit(), 0.6, 0.001);
        
        // Test other attributes
        pc.setMaxLife(30);
        pc.recoverAll();
        assertEquals(pc.getCurrLife(), 30);
        assertEquals(pc.getMaxLife(), 30);
        
        pc.setMaxMana(10);
        pc.recoverAll();
        assertEquals(pc.getCurrMana(), 10);
        assertEquals(pc.getMaxMana(), 10);
        
        assertEquals(pc.getCharClass(), "Warrior");
        assertEquals(pc.getType(), "Human");
        
        pc.gainExp(10);
        assertFalse(pc.levelUp());
        assertEquals(pc.getExp(), 10);
        pc.gainExp(100);
        assertEquals(pc.getExp(), 100);
        assertEquals(pc.getLevel(), 1);
        assertTrue(pc.levelUp());
        assertEquals(pc.getLevel(), 2);
        
        assertTrue(pc.getMoves() instanceof ArrayList);
        assertEquals(pc.getMoves().size(), 1);
        
        pc.setCharClass("Hero");
        assertEquals(pc.getCharClass(), "Hero");
    }
    
    @Test
    public void testDamageRecovery() throws Exception {
        
        pc = charFactory.createCharacter(m, "Human");
        pc = charFactory.addClass(pc, "Warrior");
        
        // Test life
        assertEquals(pc.getCurrLife(), 25);
        pc.takeDamage(10);
        assertEquals(pc.getCurrLife(), 15);
        pc.takeDamage(-5);
        assertEquals(pc.getCurrLife(), 15);
        pc.takeDamage(30);
        assertEquals(pc.getCurrLife(), 0);
        pc.recoverLife(-1);
        assertEquals(pc.getCurrLife(), 0);
        pc.recoverLife(10);
        assertEquals(pc.getCurrLife(), 10);
        pc.recoverLife(50);
        assertEquals(pc.getCurrLife(), 25);
        
        // Test mana
        assertEquals(pc.getCurrMana(), 5);
        pc.spendMana(1);
        assertEquals(pc.getCurrMana(), 4);
        pc.spendMana(-1);
        assertEquals(pc.getCurrMana(), 4);
        pc.spendMana(10);
        assertEquals(pc.getCurrMana(), 0);
        pc.recoverMana(-1);
        assertEquals(pc.getCurrMana(), 0);
        pc.recoverMana(3);
        assertEquals(pc.getCurrMana(), 3);
        pc.recoverMana(15);
        assertEquals(pc.getCurrMana(), 5);
    }
    
    @Test
    public void testHuman() throws Exception {
        pc = charFactory.createCharacter(m, "Human");
        
        assertEquals(pc.getExp(), 0);
        pc.gainExp(10);
        assertEquals(pc.getExp(), 11);
        
        assertEquals(pc.getLevel(), 1);
        assertFalse(pc.levelUp());
        assertEquals(pc.getLevel(), 1);
        pc.gainExp(100);
        assertTrue(pc.levelUp());
        assertEquals(pc.getLevel(), 2);
    }

    @Test
    public void testElf() throws Exception {
        pc = charFactory.createCharacter(m, "Elf");
        
        assertEquals(pc.getLevel(), 1);
        assertFalse(pc.levelUp());
        assertEquals(pc.getLevel(), 1);
        pc.gainExp(100);
        assertTrue(pc.levelUp());
        assertEquals(pc.getLevel(), 2);
        
        assertEquals(pc.getMoves().get(0), "Concentrate");
        pc.sendMove("Concentrate");
        pc.sendMove("not Concentrate");
    }
    
    @Test
    public void testDwarf() throws Exception {
        pc = charFactory.createCharacter(m, "Dwarf");
        
        assertEquals(pc.getLevel(), 1);
        assertFalse(pc.levelUp());
        assertEquals(pc.getLevel(), 1);
        pc.gainExp(100);
        assertTrue(pc.levelUp());
        assertEquals(pc.getLevel(), 2);
        
        assertEquals(pc.getCurrLife(), 31);
        pc.takeDamage(10);
        assertEquals(pc.getCurrLife(), 22);
    }
    
    @Test
    public void testWarrior() throws Exception {
        pc = charFactory.createCharacter(m, "Dwarf");
        pc = charFactory.addClass(pc, "Warrior");
        
        // level up to lv 10
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 5
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 10
        
        assertEquals(pc.getMoves().size(), 3);
        assertEquals(pc.getMoves().get(0), "Attack");
        assertEquals(pc.getMoves().get(1), "Second Wind");
        assertEquals(pc.getMoves().get(2), "Power Attack");
    }
    
    @Test
    public void testThief() throws Exception {
        pc = charFactory.createCharacter(m, "Elf");
        pc = charFactory.addClass(pc, "Thief");
        
        // level up to lv 10
        pc.levelUp(); // to test the false branch
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 5
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 10
        
        assertEquals(pc.getMoves().size(), 5);
        assertEquals(pc.getMoves().get(0), "Concentrate"); // elf's ability
        assertEquals(pc.getMoves().get(1), "Sneak Attack");
        assertEquals(pc.getMoves().get(2), "Mug");
        assertEquals(pc.getMoves().get(3), "Smoke Bomb");
        assertEquals(pc.getMoves().get(4), "Assassinate");
    }
    
    @Test
    public void testWizard() throws Exception {
        pc = charFactory.createCharacter(m, "Human");
        pc = charFactory.addClass(pc, "Wizard");
        
        // level up to lv 10
        pc.levelUp(); // to test the false branch
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 5
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();
        pc.gainExp(100);
        pc.levelUp();   // lv 10
        
        assertEquals(pc.getMoves().size(), 3);
        assertEquals(pc.getMoves().get(0), "Magic Missile"); // elf's ability
        assertEquals(pc.getMoves().get(1), "Chill Touch");
        assertEquals(pc.getMoves().get(2), "Fireball");
    }
}
