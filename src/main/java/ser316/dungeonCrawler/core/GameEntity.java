package ser316.dungeonCrawler.core;

/**
 * GameEntity is the base class for all game entities (characters, monsters, and floors).
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public class GameEntity {
	
	// The mediator that coordinates the game
	// All classes have a reference to be able to interact with the mediator
	protected Mediator mediator;
	
	/**
	 * Constructor
	 * @param mediator a reference to the mediator
	 */
	public GameEntity(Mediator mediator) {
		this.mediator = mediator;
	}
	
	/**
	 * Mediator getter
	 * @return
	 */
	public Mediator getMediator() {
		return mediator;
	}

}
