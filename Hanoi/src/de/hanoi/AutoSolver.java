package de.hanoi;

/**
 * This class provides an auto solving algorithm for the game. It does that in the fewest steps possible.
 * To do the solving in a pace the user can follow, there is a delay, which can be set to a value greater than 1.
 * 1 second is also the default delay.
 * @author phillip.goellner
 */
public class AutoSolver implements Runnable
{
	private GamePad gamePad;
	private static int preDelay;
	private int delay;
	
	/**
	 * Initializes a new AutoSolver for the given {@link GamePad} and with either the default delay or the preset one.
	 * @param gamePad the GamePad for which this solver is meant
	 */
	public AutoSolver(GamePad gamePad)
	{
		this.gamePad = gamePad;
		delay = (preDelay == 0) ? 0 : preDelay;
	}
	
	/**
	 * Initializes a new AutoSolver for the given {@link GamePad} and the given delay.
	 * @param gamePad the GamePad for which this solver is meant
	 * @param delay the desired delay
	 */
	public AutoSolver(GamePad gamePad, int delay)
	{
		this.gamePad = gamePad;
		this.delay = delay;
	}
	
	/**
	 * This function is the one used by the visualizing parts of the program.
	 * It simply calls the real (private) solve function with the right parameters. 
	 * @throws IllegalMovementException
	 */
	public void solve() throws IllegalMovementException
	{
		solve(0,1,2,gamePad.getPegSize(0));
	}
	
	/**
	 * Solves the given Hanoi board recursively with the fewest steps possible.
	 * Because of it's recursive nature, this function needs more space than an iterative approach would need.
	 * It was designed this way, because of its simplicity and its good readability.  
	 * @param start the peg from which the disk will be taken
	 * @param help the peg used for help
	 * @param target the peg the disk is supposed to go
	 * @param size the size of the current stack of disks on start
	 * @throws IllegalMovementException only if the algorithm is corrupted or something unexpected happens
	 */
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

	/**
	 * The starting point for the separate auto solving thread. Called by the GUI or another UI.
	 */
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
	
	/**
	 * Presets the delay for each following instance of AutoSolver.
	 * Used by {@link Main}. Guarantees the right delay even if the solving process is aborted and restated. 
	 * @param i the delay each new instance will be initialized with.
	 */
	public static void presetDelay(int i)
	{
		preDelay = i;
	}
}
