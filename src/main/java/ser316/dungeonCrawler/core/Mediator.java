package ser316.dungeonCrawler.core;

/**
 * Mediator is a central class that coordinates the game using
 * a Mediator design pattern. 
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public interface Mediator {

	/**
	 * Used by all game entities to send actions to the mediator
	 * @param entity the sending entity
	 * @param event the action to be resolved by the mediator
	 */
	public void notify(GameEntity entity, String event);
}
