package de.hanoi;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * QueueManager manages, as the name suggests, the queue in which the MovementTokens are stored.
 * Once the run method is triggered the AutoSolver class is asked to provide the necessary moves.
 * AutoSolver runs in a separate Thread so the first movements can be resolved before every single movement was calculated.
 *  
 * @author phillip.goellner
 */
public class QueueManager
{
	private ConcurrentLinkedQueue<MovementToken> queue;
	private AutoSolver autoSolver;
	private GamePad gamePad;

	public QueueManager(GamePad g)
	{
		queue = new ConcurrentLinkedQueue<MovementToken>();
		gamePad = g;
	}
	
	public void startSolving()
	{
		new Thread(autoSolver).run();
	}
	public void cancelSolving()
	{
		autoSolver.abort();
		queue.removeAll(queue);
		
	}
	
	public void addMovement(MovementToken m)
	{
		queue.add(m);
	}
	public void resolveMovement()
	{
		queue.poll().resolve(gamePad);
	}
}
