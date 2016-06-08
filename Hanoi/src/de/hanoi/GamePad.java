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
	private Rod[] rods;
	public final int DISC_NUMBER;
	public static final int DEFAULT_DISC_NUMBER = 4;
	
	public GamePad()
	{
		rods = new Rod[3];
		DISC_NUMBER = DEFAULT_DISC_NUMBER;
		initiate();
	}
	public GamePad(int discNumber)
	{
		rods = new Rod[3];
		DISC_NUMBER = discNumber;
		initiate();
	}
	
	private void initiate()
	{
		for(int i = 0; i < rods.length; i++)
		{
			rods[i] = new Rod();
		}
		for(int i = DISC_NUMBER; i > 0; i--)
		{
			rods[0].push(new Disc(i));
		}
	}
	
	public void move(int rod1, int rod2) throws IllegalMovementException
	{
		Rod tmp = rods[rod1];
		rods[rod1] = rods[rod2];
		rods[rod2] = tmp;
	}
}
