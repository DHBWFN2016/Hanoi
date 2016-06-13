package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class AutoSolver implements Runnable
{
	private GamePad gamePad;
	private static int preDelay;
	private int delay;
	
	public AutoSolver(GamePad gamePad)
	{
		this.gamePad = gamePad;
		delay = (preDelay == 0) ? 1 : preDelay;
	}
	
	public AutoSolver(GamePad gamePad, int delay)
	{
		this.gamePad = gamePad;
		this.delay = delay;
	}
	
	public void solve() throws IllegalMovementException
	{
		solve(0,1,2,gamePad.getPegSize(0));
	}
	
	private void solve(int start, int help, int target, int size) throws IllegalMovementException
	{
		if(size == 1)
		{
			gamePad.move(start, target);
			try
			{
				Thread.sleep(delay*1000L);
			}
			catch (InterruptedException e)
			{
				// if this happens we have bigger problems than a dormant Thread...
				e.printStackTrace();
			}
		}
		else
		{
			solve(start, target, help, size-1);
			gamePad.move(start, target);
			try
			{
				Thread.sleep(delay*1000L);
			}
			catch (InterruptedException e)
			{
				// if this happens we have bigger problems than a dormant Thread...
				e.printStackTrace();
			}
			solve(help, start, target, size-1);
		}
	}

	public void run()
	{
		try
		{
			solve();
		}
		catch (IllegalMovementException e)
		{
			// if this happens we screwed up the algorithm
			// of course this will never happen
			e.printStackTrace();
		}
	}
	
	public static void presetDelay(int i)
	{
		preDelay = i;
	}
}
