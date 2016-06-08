/**
 * 
 */
package de.hanoi;

import java.util.Stack;

/**
 * @author phillip.goellner
 *
 */
public class Rod
{
	private Stack<Disc> stack;
	
	public Disc pop()
	{
		return stack.pop();
	}
	public void push(Disc d)
	{
		stack.push(d);
	}
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
}
