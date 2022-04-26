package ser316.dungeonCrawler.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import ser316.dungeonCrawler.floors.*;
import ser316.dungeonCrawler.monsters.Monster;
import ser316.dungeonCrawler.character.PlayerCharacter;
import ser316.dungeonCrawler.factories.CharacterFactory;
import ser316.dungeonCrawler.factories.FloorFactory;
import ser316.dungeonCrawler.factories.MonsterFactory;

/**
 * GameRunner is the concrete instance of the Mediator that is charged with
 * running and coordinating the game. 
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class GameRunner implements Mediator {

	// Attributes
	private LinkedList<Floor> floors;
	private CharacterFactory charFactory;
	private MonsterFactory monsterFactory;
	private FloorFactory floorFactory;
	private int currentFloor;
	private PlayerCharacter player;
	private Monster monster;
	private ArrayList<String> storeInventory;
	private boolean escape;

	/**
	 * Constructor
	 */
	public GameRunner() {
		floors = new LinkedList<>();
		charFactory = new CharacterFactory();
		monsterFactory = new MonsterFactory();
		floorFactory = new FloorFactory();
		player = null;
		monster = null;
	}

	/**
	 * Player character setup before the game starts
	 * @throws Exception
	 */
	public void playerSetup() throws Exception {
		
		System.out.print("Welcome to Dungeon Crawler!\n" + "Let's set up your character. Choose a character type:\n"
				+ "1 - Human\n" + "2 - Elf\n" + "3 - Dwarf\n");
		Scanner scan = new Scanner(System.in);
		String charType = "";
		String charClass = "";
		while (player == null) {
			charType = scan.nextLine();
			switch (charType) {
			case ("1"):
				player = charFactory.createCharacter(this, "Human");
				break;
			case ("2"):
				player = charFactory.createCharacter(this, "Elf");
				break;
			case ("3"):
				player = charFactory.createCharacter(this, "Dwarf");
				break;
			default:
				System.out.print("Option not recognized.\n" + "Choose a character type:\n" + "1 - Human\n" + "2 - Elf\n"
						+ "3 - Dwarf\n");
			}
		}

		System.out.print("Now choose a character class:\n" + "1 - Warrior\n" + "2 - Thief\n" + "3 - Wizard\n");
		while (player.getCharClass().equals("None")) {
			charClass = scan.nextLine();
			switch (charClass) {
			case ("1"):
				player = charFactory.addClass(player, "Warrior");
				break;
			case ("2"):
				player = charFactory.addClass(player, "Thief");
				break;
			case ("3"):
				player = charFactory.addClass(player, "Wizard");
				break;
			default:
				System.out.print("Option not recognized.\n" + "Choose a character class:\n" + "1 - Warrior\n"
						+ "2 - Thief\n" + "3 - Wizard\n");
			}
		}
	}

	/**
	 * Starts the main game loop.
	 * Helps the user setup the player character,
	 * prints the game intro,
	 * and begins running the game
	 * @throws Exception
	 */
	public void initializeGame() throws Exception {
		playerSetup();

		floors.add(floorFactory.create(this, 0));
		currentFloor = 0;

		System.out.print("At the northern border of the Shield Lands, "
				+ "near the Bandit Kingdoms and the Great Rift, " + "stands legendary White Plume Mountain.\n"
				+ "Adventurers from all over the world come here in search "
				+ "for riches and glory in the endless depths of the mountain.\n" + "You are one such adventurer.\n"
				+ "Located at the feet of White Plume Mountain is the small village of Fallcrest, "
				+ "which serves as a safe haven for those willing to delve into the dungeon.\n" + "\n----------\n\n");
		run();
	}

	/**
	 * The main game loop
	 * @throws Exception
	 */
	public void run() throws Exception {
		while (true) {
			// check if floor has to be re-seeded
			if (floors.get(currentFloor).isClear()) {
				revisitFloor();
			}
			// prints floor description
			floors.get(currentFloor).getDescription();
			
			// pick which prompt to send to the user
			if (floors.get(currentFloor).isStore()) {
				populateInventory();
				// TODO send list of wares and prompt for player action
				
				if (currentFloor == 0)
					player.fallcrestPrompt(storeInventory);
				else
					player.storePrompt(storeInventory);
				
			} else if (floors.get(currentFloor).isDungeon()) {
				
				// prompts player for actions on an empty dungeon floor
				player.dungeonPrompt();
			}
		}
	}

	/**
	 * Combat loop
	 */
	public void combatLoop() {
		System.out.println("Initiating combat...");
		
		while (monster.getCurrLife() > 0) {
			
			// prompt user for combat action
			player.combatPrompt();
			
			// check if monster is dead
			if (monster.getCurrLife() <= 0) {
				System.out.println(monster.getName() + " was defeated!");
				
				// clear current floor
				Floor floor = floors.get(currentFloor);
				floor.clear();
				floors.set(currentFloor, floor);
				
				// get prizes
				int exp = currentFloor * 10 - player.getLevel();
				player.gainExp(exp);
				// TODO gain gold
				return;
			}
			
			// if the player manages to escape (currently only for Thief)
			if (escape) {
				System.out.println("You escape from combat!");
				escape = false;
				return;
			}
			
			// prompt monster for combat action
			monster.combatPrompt();
			
			// check if player is dead
			if (player.getCurrLife() <= 0) {
				endGame();
			}
		}
	}

	/**
	 * Notification method of the Mediator design pattern.
	 * Used by game entities to ask the Mediator to resolve a game event.
	 * Composed of a list of valid events.
	 */
	@Override
	public void notify(GameEntity entity, String event) {

		// Return to surface
		if (entity instanceof PlayerCharacter && event.equals("Return to surface")) {
			// go back to surface
			currentFloor = 0;
			player.recoverAll();
			System.out.println("Life and mana fully recovered.");
			player.levelUp();
		}

		// Delve deeper
		if (entity instanceof PlayerCharacter && event.equals("Delve deeper")) {
			try {
				delveDeeper();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Enter combat loop
		if (entity instanceof DungeonFloor && event.equals("Enter combat")) {
			combatLoop();
		}

		// Physical attack - player
		if (entity instanceof PlayerCharacter && event.equals("PhyAtk")) {
			int damage = player.getTotalPhyAtk() - monster.getPhyDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			if ((Math.random() * 1) <= player.getTotalCrit())
				damage += (int) (damage * player.getTotalCrit());
			monster.takeDamage(damage);
		}

		// Physical attack - monster
		if (entity instanceof Monster && event.equals("PhyAtk")) {
			int damage = monster.getPhyAtk() - player.getTotalPhyDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			if ((Math.random() * 1) <= monster.getCrit())
				damage += (int) (damage * monster.getCrit());
			player.takeDamage(damage);
		}

		// Magical attack - player
		if (entity instanceof PlayerCharacter && event.equals("MgcAtk")) {
			int damage = player.getTotalMgcAtk() - monster.getMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			monster.takeDamage(damage);
		}

		// Magical attack - monster
		if (entity instanceof Monster && event.equals("MgcAtk")) {
			int damage = monster.getMgcAtk() - player.getTotalMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			player.takeDamage(damage);
		}

		// Critical physical attack - player
		if (entity instanceof PlayerCharacter && event.equals("CritAtk")) {
			int damage = player.getTotalPhyAtk() - monster.getPhyDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			damage += (int) (damage * player.getTotalCrit());
			monster.takeDamage(damage);
		}

		// Critical physical attack - monster
		if (entity instanceof Monster && event.equals("CritAtk")) {
			int damage = monster.getPhyAtk() - player.getTotalPhyDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			damage += (int) (damage * monster.getCrit());
			player.takeDamage(damage);
		}

		// Critical magical attack - player
		if (entity instanceof PlayerCharacter && event.equals("CritMgcAtk")) {
			int damage = player.getTotalMgcAtk() - monster.getMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			damage += (int) (damage * player.getTotalCrit());
			monster.takeDamage(damage);
		}

		// Critical magical attack - monster
		if (entity instanceof Monster && event.equals("CritMgcAtk")) {
			int damage = monster.getMgcAtk() - player.getTotalMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			damage += (int) (damage * monster.getCrit());
			player.takeDamage(damage);
		}

		// Drain attack - player
		if (entity instanceof PlayerCharacter && event.equals("DrainAtk")) {
			int damage = player.getTotalMgcAtk() - monster.getMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			monster.takeDamage(damage);
			player.recoverLife(damage / 2);
		}

		// Drain attack - player
		if (entity instanceof Monster && event.equals("DrainAtk")) {
			int damage = monster.getMgcAtk() - player.getTotalMgcDef() + randomizeDamage();
			if (damage <= 0)
				damage = 1;
			player.takeDamage(damage);
			monster.recoverLife(damage / 2);
		}

		// Escape battle
		if (entity instanceof PlayerCharacter && event.equals("Escape")) {
			escape = true;
		}

		// Death blow
		if (entity instanceof PlayerCharacter && event.equals("DeathBlow")) {
			monster.takeDamage(monster.getCurrLife());
		}
	}

	/**
	 * Moves the player character to the next floor in the dungeon.
	 * Sets up the floor if it still doesn't exists.
	 * @throws Exception
	 */
	private void delveDeeper() throws Exception {
		currentFloor++;
		if (currentFloor >= floors.size()) {
			Floor floor = floorFactory.create(this, currentFloor);
			if (floor instanceof DungeonFloor) {
				if (currentFloor % 10 == 0) {
					monster = monsterFactory.create(this, currentFloor, true);
				} else {
					monster = monsterFactory.create(this, currentFloor, false);
				}
				((DungeonFloor) floor).setMonster(monster);
			}
			floors.add(floor);
		}
	}

	/**
	 * When the player revisits a floor, randomly repopulate it.
	 * @throws Exception
	 */
	private void revisitFloor() throws Exception {
		int max = 10;
		int min = 1;
		int random = ((int) (Math.random() * (max - min)) + min);
		switch (random) {
		case 1:
			floors.set(currentFloor, floorFactory.create(this, currentFloor, "Shop"));
			break;
		case 2:
		case 3:
			monster = monsterFactory.create(this, currentFloor, false);
			Floor floor = floorFactory.create(this, currentFloor, "Dungeon");
			((DungeonFloor)floor).setMonster(monster);
			floors.set(currentFloor, floor);
			
			break;
		default:
			// do nothing
			break;
		}
	}

	/**
	 * Populates a shop's inventory
	 * TODO not finished implementing
	 */
	private void populateInventory() {
		storeInventory = new ArrayList<>();
	}

	/**
	 * Ends the game when the player dies.
	 */
	private void endGame() {
		System.out.println("GAME OVER");
		System.exit(0);
	}
	
	/**
	 * Randomizes an additional 1-5 damage per attack.
	 * Keeps things interesting :)
	 * @return
	 */
	private int randomizeDamage() {
		int max = 5;
		int min = 1;
		return ((int) (Math.random() * (max - min)) + min);
	}

}
