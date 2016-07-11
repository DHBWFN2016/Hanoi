package de.hanoi;

/**
 * This enum represents a game state. Specifically the GUI needs the game states to determine whether to repaint or
 * not as this is highly dependent on a user action.
 * Also the {@link Main} class uses it to start in autoplay mode if need be.
 * <p>
 * This enumeration mainly exists for a future extension of the game. 
 * @author phillip.goellner
 */
public enum GameState

{
	AUTOPLAY, FINISHED, WAITING_FOR_ACTION, RESET
}
