/**
 * 
 */
package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class GamePad
{
	private Peg[] pegs;
	public final int DISC_NUMBER;
	public static final int DEFAULT_DISC_NUMBER = 4;
	private int moves;
	
	public GamePad()
	{
		pegs = new Peg[3];
		DISC_NUMBER = DEFAULT_DISC_NUMBER;
		initiate();
		moves = 0;
	}
	public GamePad(int discNumber)
	{
		pegs = new Peg[3];
		DISC_NUMBER = discNumber;
		initiate();
		moves = 0;
	}
	
	private void initiate()
	{
		for(int i = 0; i < pegs.length; i++)
		{
			pegs[i] = new Peg();
		}
		for(int i = DISC_NUMBER; i > 0; i--)
		{
			pegs[0].push(new Disk(i));
		}
	}
	
	public void move(int peg1, int peg2) throws IllegalMovementException
	{
		System.out.println("Trying to move from " + pegs[peg1] + " to " + pegs[peg2]);
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
		System.out.println("Moved from " + pegs[peg1] + " to " + pegs[peg2]);
	}
	
	public void resetMoves()
	{
		moves = 0;
	}
	public int getMoves()
	{
		return moves;
	}
	
	public int getPegSize(int index)
	{
		return pegs[index].size();
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
