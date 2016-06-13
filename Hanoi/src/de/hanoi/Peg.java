package de.hanoi;

import java.util.Stack;

/**
 * @author phillip.goellner
 * Peg is a wrapper class for a stack. The reason for doing this instead of extending java.util.Stack is the greater flexibility of a wrapper class,
 * also taking possible future expansion into consideration.
 * <p>
 * Every method is simply a wrapper around the corresponding java.util.Stack method
 */
public class Peg
{
	private Stack<Disk> stack;

	public Peg()
	{
		stack = new Stack<Disk>();
	}
	
	/**
	 * Removes the first Disk from the Peg and returns it.
	 * @return the Disk removed by this method
	 * @throws EmptyStackException - if the Peg is empty
	 */
	public Disk pop()
	{
		return stack.pop();
	}
	
	/**
	 * Looks at the first Disk and returns it without removing it.
	 * @return the first Disk on this Peg
	 * @throws EmptyStackException - if the Peg is empty
	 */
	public Disk peek()
	{
		return stack.peek();
	}
	
	/**
	 * Inserts the given Disk on top of this Peg.
	 * @param disk the Disk to be pushed onto the Peg
	 */
	public void push(Disk disk)
	{
		stack.push(disk);
	}
	
	/**
	 * Checks whether the Peg is empty.
	 */
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	/**
	 * Returns the number of Disks on this Peg.
	 * @return the total number of Disks on this Peg*/
	public int size()
	{
		return stack.size();
	}
	
	/**
	 * Returns a String representing this Disk object
	 */
	public String toString()
	{
		return stack.toString();
	}
}
