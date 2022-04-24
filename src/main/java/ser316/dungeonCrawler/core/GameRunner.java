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

public class GameRunner implements Mediator {

	private LinkedList<Floor> floors;
	private CharacterFactory charFactory;
	private MonsterFactory monsterFactory;
	private FloorFactory floorFactory;
	private int currentFloor;
	private PlayerCharacter player;
	private Monster monster;
	private ArrayList<String> storeInventory;

	public GameRunner() {
		floors = new LinkedList<>();
		charFactory = new CharacterFactory();
		monsterFactory = new MonsterFactory();
		floorFactory = new FloorFactory();
		player = null;
		monster = null;
	}

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

	public void initializeGame() throws Exception {
		playerSetup();

		floors.add(floorFactory.create(this, 0));
		currentFloor = 0;

		System.out.print("At the northern border of the Shield Lands, "
				+ "near the Bandit Kingdoms and the Great Rift, " + "stands legendary White Plume Mountain.\n"
				+ "Adventurers from all over the world come here in search "
				+ "for riches and glory in the endless depths of the mountain.\n"
				+ "You are one such adventurer.\n"
				+ "Located at the feet of White Plume Mountain is the small village of Fallcrest, "
				+ "which serves as a safe haven for those willing to delve into the dungeon.\n"
				+ "\n----------\n\n");
		run();
	}

	public void run() throws Exception {
		//while (true) {
			// get floor description
			floors.get(currentFloor).getDescription();
			if (floors.get(currentFloor).isClear()) {
				revisitFloor();
			}
			if (floors.get(currentFloor).isStore()) {
				populateInventory();
				// send list of wares and prompt for player action
				if (currentFloor == 0)
					player.fallcrestPrompt(storeInventory);
				else
					player.storePrompt(storeInventory);
			} else if (floors.get(currentFloor).isDungeon()) {
				floors.get(currentFloor).getDescription();
				if (!floors.get(currentFloor).isClear()) {
					combatLoop();
				}
				player.dungeonPrompt();
			}
		//}
	}
	
	public void combatLoop() {
		while (monster.getLife() > 0 || player.getCurrLife() > 0) {
			// prompt user for combat action
			player.combatPrompt();
			// resolve action
			// check if monster is dead
			if (monster.getLife() <= 0) {
				System.out.println(monster.getName() + " was defeated!");
				// get prizes
				break;
			}
			// prompt monster for combat action
			monster.combatPrompt();
			// resolve action
			// check if player is dead
			if (player.getCurrLife() <= 0) {
				endGame();
			}
		}
	}

	@Override
	public void notify(GameEntity entity, String event) {

		// Setup Monster request from Dungeon floor
		if (entity.getClass().equals(DungeonFloor.class) && event.equals("Setup Monster")) {
			try {
				if (!floors.get(currentFloor).isClear() && currentFloor % 10 == 0)
					monster = monsterFactory.create(this, currentFloor, true);
				else
					monster = monsterFactory.create(this, currentFloor, false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void revisitFloor() throws Exception {
		int max = 10;
		int min = 1;
		int random = ((int)(Math.random() * (max - min)) + min);
		switch (random) {
		case 1:
			floors.set(currentFloor, floorFactory.create(this, currentFloor, "Shop"));
			break;
		case 2:
		case 3:
			floors.set(currentFloor, floorFactory.create(this, currentFloor, "Dungeon"));
			break;
		default:
			// do nothing
			break;
		}
	}

	private void populateInventory() {
		storeInventory = new ArrayList<>();
	}
	
	private void endGame() {
		System.out.print("You have died!\n"
				+ "Game Over\n");
		System.exit(0);
	}

}
