package de.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class HanoiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GamePad gamepad = new GamePad();
	private Peg stack = new Peg();
	private Random random = new Random();
	
	public HanoiPanel(GamePad g)
	{
		gamepad = g;
	}
	
	public void paint(Graphics d)
	{
		int stack_width = 10;
		int stack_height = getHeight()/5*4;
		int width = getWidth();
		int height = getHeight();
		Graphics2D g = (Graphics2D) d;
		
		for (int i = 0; i < 3; i++) {
			stack.push(new Disk(1+1));
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.DARK_GRAY);
		//Background
		g.fillRect(0, height/5*4, width, 10);
		//Column
		g.fillRect(width/4, 10, stack_width, stack_height);
		g.fillRect(width/2, 10, stack_width, stack_height);
		g.fillRect((width/4)*3, 10, stack_width, stack_height);
		/*
		if(!stack.isEmpty())
		{
			for (int i = 0; i < stack.size(); i++) 
				{
					int r = random.nextInt(255);
					int gr = random.nextInt(255);
					int b = random.nextInt(255);
					g.setColor(new Color(r, gr, b));
					g.fillRect(width/8+5*i, height/5*4-height/20-height/20*i, stack_width+width/4-10*i, height/20);
				}
		}*/
		for(int i = 0; i < 3; i++)
		{
			//System.out.println("#"+i);
			Peg p = gamepad.getPegAt(i);
			for(int a = 0; a < p.size(); a++)
			{
				int no = p.getDiskAt(a).SIZE;
				g.fillRect((width/4)*(i+1),10+no*10,no*10,15);
			}
		}
	}

	
}
