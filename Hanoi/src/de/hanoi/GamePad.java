package de.hanoi;

/**
 * GamePad represents the game itself and contains an array of (three) Pegs, the current amount of moves and the current GameState.
 * The methods provided by this class are used by the GUI as well as the {@link AutoSolver} class.
 * @author phillip.goellner
 */
public class GamePad
{
	private Peg[] pegs;
	public int diskNumber;
	public static final int DEFAULT_DISK_NUMBER = 4;
	private int moves;
	private GameState currentGameState;
	
	/**
	 * Initializes a GamePad with a default number of 4 Disks.
	 */
	public GamePad()
	{
		pegs = new Peg[3];
		diskNumber = DEFAULT_DISK_NUMBER;
		initiate();
	}
	/**
	 * Initializes a GamePad with the given number of Disks.
	 * @param diskNumber the number of Disks the GamePad should be initialized with
	 */
	public GamePad(int diskNumber)
	{
		pegs = new Peg[3];
		this.diskNumber = diskNumber;
		initiate();
	}
	
	/**
	 * This method sets up a new board by creating three new Pegs, positioning all Disks on the first Peg and setting the moves to 0.
	 */
	private void initiate()
	{
		for(int i = 0; i < pegs.length; i++)
		{
			pegs[i] = new Peg();
		}
		for(int i = diskNumber; i > 0; i--)
		{
			pegs[0].push(new Disk(i));
		}
		moves = 0;
	}
	 /**
	  * Moves the top Disk from the first Peg onto the other. This is the only possibility to change the state of pegs and disks. The GUI as well as the
	  * {@link AutoSolver} class use this to perform a move either automatically or user triggered.
	  * @param peg1 the Peg from where the Disk is taken from
	  * @param peg2 the PEg where the Disk is put
	  * @throws  IllegalMovementException when an illegal movement is performed
	  */
	public void move(int peg1, int peg2) throws IllegalMovementException
	{
		moves++;
		if(pegs[peg1].isEmpty())
		{
			throw new IllegalMovementException("Trying to remove from an empty Peg");
		}
		if(!pegs[peg2].isEmpty() && pegs[peg2].peek().compareTo(pegs[peg1].peek()) < 0)
		{
			throw new IllegalMovementException("Trying to move size " + pegs[peg1].peek() + " onto size " + pegs[peg2].peek());
		}
		pegs[peg2].push(pegs[peg1].pop());
	}

	/**
	 * Resets the movement count as well as the game itself.
	 * What actually happens is that a new board is set up keeping the original number of disks.
	 */
	public void resetMoves()
	{
		initiate();
	}
	
	/**
	 * Returns the moves performed so far
	 * @return an int representing the number of movements performed
	 */
	public int getMoves()
	{
		return moves;
	}

	/**
	 * Sets up a new board with the given number of disks.
	 * This method is mainly implemented for future use, e.g. for a selection of a different number of disks starting a new game.
	 * @param diskNumber the number of disks the board should be initialized with 
	 */
	public void setDiskNumber(int diskNumber)
	{
		this.diskNumber = diskNumber;
		initiate();
	}

	/**
	 * Returns the number of movements performed up to this point.
	 * @return an int representing the number of movements performed so far
	 */
	public int getPegSize(int index)
	{
		return pegs[index].size();
	}

	/**
	 * Changes the {@link GameState} to a new one.
	 * This is happens whenever the game finishes or starts.
	 */
	public void setGameState(GameState g)
	{
		currentGameState = g;
	}

	/**
	 * Returns the {@link GameState} this GamePad is currently in
	 */
	public GameState getGameState()
	{
		return currentGameState;
	}
	
	public Peg getPegAt(int index)
	{
		return pegs[index].getCopy();
	}

	/**
	 * Returns a String representing this GamePad object
	 * @return a String representation of this GamePad
	 */
	public String toString()
	{
		String output = "{";
		for(int i = 0; i < pegs.length-1; i++)
			output +=  pegs[i]+",";
		output += pegs[pegs.length-1]+"}";
		return output;
	}
}
