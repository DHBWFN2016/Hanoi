package de.hanoi;

/**
 * @author phillip.goellner
 * This Exception is thrown whenever someone tries to perform an illegal movement.
 * Trying to remove from an empty Peg and trying to place a Disk on a smaller one are both considered illegal.
 */
public class IllegalMovementException extends Exception
{

	/**
	 * The default serialVersionUID, demanded due to the extension Exception.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Passes the given message, which tells what was the cause for this Exception to be thrown, to the super Constructor.
	 * @param message a message specifying the cause of this Exception
	 */
	public IllegalMovementException(String message)
	{
		super(message);
	}
}
