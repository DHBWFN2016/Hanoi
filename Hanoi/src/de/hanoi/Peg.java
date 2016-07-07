package de.hanoi;

import java.util.Stack;

/**
 * Peg is a wrapper class for a stack. The reason for doing this instead of extending java.util.Stack is the greater flexibility of a wrapper class,
 * also taking possible future expansion into consideration.
 * <p>
 * Every method is simply a wrapper around the corresponding java.util.Stack method
 * @author phillip.goellner
 */
public class Peg
{
	/**
	 *  The Stack this class wraps around. Here all the disks are saved.
	 */
	private Stack<Disk> stack;

	/**
	 * Initializes a new empty Peg.
	 */
	public Peg()
	{
		stack = new Stack<Disk>();
	}
	/**
	 * Initializes a new Peg with all the disks from the given Stack. This is only used internally for the getCopy() method.
	 * @param s the Stack with all the Disks this new one should contain
	 */
	private Peg(Stack<Disk> s)
	{
		stack = new Stack<Disk>();
		stack.addAll(s);
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
	 * @return a boolean: true when the peg is empty, false otherwise
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
	
	public Disk getDiskAt(int i)
	{
		return stack.elementAt(i);
	}
	
	public Peg getCopy()
	{
		return new Peg(stack);
	}
	
	/**
	 * Returns a String representing this Peg object
	 * @return a String representation of this peg
	 */
	public String toString()
	{
		return stack.toString();
	}
}
