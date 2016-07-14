package de.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * HanoiPanel signify the drawing Game, where {@link Disk}s moves from one {@link Peg} to another within the {@link GamePad}
 * and it is a fragment of the GUI.
 * @author phillip.goellner & severino.detta
 *
 */
public class HanoiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GamePad gamepad;
	
	/**
	 * Creates a HanoiPanel with an existing {@link GamePad}
	 * @param g is a {@link GamePad} Object that HanoiPanel should be initialized with  
	 */
	public HanoiPanel(GamePad g)
	{
		gamepad = g;
	}
	
	/**
	 * This method draw a rigid pictures of the Game and further the standing or moving disks
	 */
	public void paint(Graphics d)
	{
		int stack_width = 10;
		int stack_height = getHeight()/5*4;
		int width = getWidth();
		int height = getHeight();
		Graphics2D g = (Graphics2D) d;
		//Background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//Bar
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, height/5*4, width, 10);
		//Column
		g.fillRect(width/4, 10, stack_width, stack_height);
		g.fillRect(width/2, 10, stack_width, stack_height);
		g.fillRect((width/4)*3, 10, stack_width, stack_height);
		g.setColor(Color.GREEN);

		for(int i = 0; i < 3; i++)
		{
			Peg p = gamepad.getPegAt(i);
			for(int a = 0; a < p.size(); a++)
			{
				int no = p.getDiskAt(a).SIZE;
				g.fillRect((width/4)*(i+1)-4*no,height/5*4-10-a*10,no*8+stack_width,10);
			}
		}
	}

	
}
