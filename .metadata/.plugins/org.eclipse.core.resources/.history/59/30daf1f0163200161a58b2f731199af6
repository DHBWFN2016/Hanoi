package de.hanoi;

/**
 * @author phillip.goellner
 * This class is a simple implementation of an abstract Towers of Hanoi disk having the size as a single member.
 * Comparable is merely implemented for utility reasons, the same goes for the toString method.
 */
public class Disk implements Comparable<Disk>
{
	public final int SIZE;
	
	public Disk(int s)
	{
		SIZE = s;
	}

	/**
	 * Compares this object to another Disk by checking both sizes.
	 * This returns a negative int in case the given {@link Disk} is greater than this one. This returns a positive
	 * int in case the given {@link Disk} is smaller than this one. If the returned value is 0 both objects are equally
	 * big.
	 * 
	 * @param otherDisk another {@link Disk} object to compare with this one
	 * @return an int specifying the relation between both disks
	 */
	public int compareTo(Disk otherDisk)
	{
		return SIZE - otherDisk.SIZE;
	}

	/**
	 * Returns a String representing this Disk object
	 */
	public String toString()
	{
		return "" + SIZE;
	}
}
