package de.hanoi;

/**
 * This class is the ultimate manager of the game.
 * It is the interface between the logic and the GUI (or wherever the output is going).
 * @author phillip.goellner
 */
public class GameManager
{
	private QueueManager queueManager;
	private GamePad gamePad;
	
	public GameManager(boolean autoSolve, int delay, int diskNo)
	{
		gamePad = new GamePad(diskNo);
		if(autoSolve)
		{
			queueManager = new QueueManager(gamePad);
		}
	}
	
	public GamePad getGamePad()
	{
		return gamePad;
	}
}
