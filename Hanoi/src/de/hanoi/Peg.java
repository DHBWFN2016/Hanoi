/**
 * 
 */
package de.hanoi;

import java.util.Stack;

/**
 * @author phillip.goellner
 *
 */
public class Peg
{
	private Stack<Disk> stack;

	public Peg()
	{
		stack = new Stack<Disk>();
	}
	
	public Disk pop()
	{
		return stack.pop();
	}
	public Disk peek()
	{
		return stack.peek();
	}
	public void push(Disk d)
	{
		stack.push(d);
	}
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	public int size()
	{
		return stack.size();
	}
	
	public String toString()
	{
		return stack.toString();
	}
}
