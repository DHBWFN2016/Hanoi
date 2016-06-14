package de.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class HanoiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics d)
	{
		int STACK_WIDTH = 10;
		int STACK_HEIGHT = getHeight()/5*4;
		int WIDTH = getWidth();
		int HEIGHT = getHeight();
		Graphics2D g = (Graphics2D)d;
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, HEIGHT/5*4, WIDTH, 10);
		g.fillRect(WIDTH/4, 10, STACK_WIDTH, STACK_HEIGHT);
		g.fillRect(WIDTH/2, 10, STACK_WIDTH, STACK_HEIGHT);
		g.fillRect((WIDTH/4)*3, 10, STACK_WIDTH, STACK_HEIGHT);
	}

	
}
