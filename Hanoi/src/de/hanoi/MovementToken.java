package de.hanoi;

/**
 * MovementToken is a simple Tumple, as these are not available in Java. Each MovementToken represents a single movement from
 * one peg to another and all of these movements are used to determine the next step in the solution of the game
 * and are saved sequentially in a queue.
 * @author phillip.goellner
 */
public class MovementToken
{
	private int startingPeg;
	private int targetPeg;
	
	public MovementToken(int s, int t)
	{
		startingPeg = s;
		targetPeg = t;
	}
	
	public void resolve(GamePad gamePad)
	{
		try
		{
			gamePad.move(startingPeg, targetPeg);
		}
		catch (IllegalMovementException e)
		{
			// If this occurs we messed up the solving algorithm
			e.printStackTrace();
		}
	}
}
