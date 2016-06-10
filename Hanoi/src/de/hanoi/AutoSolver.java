/**
 * 
 */
package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class AutoSolver implements Runnable
{
	private GamePad gamePad;
	private int delay;
	
	public AutoSolver(GamePad g, int d)
	{
		gamePad = g;
		delay = d;
	}
	
	public void solve(int start, int help, int target, int size) throws IllegalMovementException
	{
		if(size == 1)
		{
			gamePad.move(start, target);
		}
		else
		{
			solve(start, target, help, size-1);
			gamePad.move(start, target);
			solve(help, start, target, size-1);
		}
		try
		{
			Thread.sleep(delay*1000L);
		}
		catch (InterruptedException e)
		{
			// if this happens we have other problems than a dormant Thread...
			e.printStackTrace();
		}
	}

	public void run()
	{
		try
		{
			solve(0,1,2,gamePad.getPegSize(0));
		}
		catch (IllegalMovementException e)
		{
			// if this happens we screwed up the algorithm
			// of course this will never happen
			e.printStackTrace();
		}
	}
}
