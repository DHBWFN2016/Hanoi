/**
 * 
 */
package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class IllegalMovementException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalMovementException(String message)
	{
		super(message);
	}
}
