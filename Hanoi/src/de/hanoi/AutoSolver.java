package de.hanoi;

/**
 * This class provides an auto solving algorithm for the game. It does that in the fewest steps possible.
 * Every step is saved to the queue in QueueManager within a MovementToken.
 * @author phillip.goellner
 */
public class AutoSolver implements Runnable
{
	private QueueManager queueMgr;
	private int diskNumber;
	private boolean abort;
	
	public AutoSolver(QueueManager queueMgr, int diskNo)
	{
		this.queueMgr = queueMgr;
		diskNumber = diskNo;
	}
	
	public void solve() throws IllegalMovementException
	{
		solve(0,1,2,diskNumber);
	}
	
	private void solve(int start, int help, int target, int size) throws IllegalMovementException
	{
		if(abort)
		{
			abort = false;
			return;
		}
		
		if(size == 1)
		{
			queueMgr.addMovement(new MovementToken(start, target));
		}
		else
		{
			solve(start, target, help, size-1);
			queueMgr.addMovement(new MovementToken(start, target));
			solve(help, start, target, size-1);
		}
	}
	
	public void abort()
	{
		abort = true;
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
}
