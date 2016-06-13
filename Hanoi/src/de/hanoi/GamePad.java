package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class GamePad
{
	private Peg[] pegs;
	public int diskNumber;
	public static final int DEFAULT_DISK_NUMBER = 4;
	private int moves;
	private GameState currentGameState;
	
	public GamePad()
	{
		pegs = new Peg[3];
		diskNumber = DEFAULT_DISK_NUMBER;
		initiate();
		moves = 0;
	}
	public GamePad(int diskNumber)
	{
		pegs = new Peg[3];
		this.diskNumber = diskNumber;
		initiate();
		moves = 0;
	}
	
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
	}
	
	public void move(int peg1, int peg2) throws IllegalMovementException
	{
		System.out.print(toString() + " -> ");
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
		System.out.println(toString());
	}
	
	public void resetMoves()
	{
		moves = 0;
		initiate();
	}
	public int getMoves()
	{
		return moves;
	}
	
	public void setDiskNumber(int i)
	{
		diskNumber = i;
		initiate();
	}
	
	public int getPegSize(int index)
	{
		return pegs[index].size();
	}
	
	public void setGameState(GameState g)
	{
		currentGameState = g;
	}
	
	public GameState getGameState()
	{
		return currentGameState;
	}
	
	public String toString()
	{
		String output = "{";
		for(int i = 0; i < pegs.length-1; i++)
			output +=  pegs[i]+",";
		output += pegs[pegs.length-1]+"}";
		return output;
	}
}
