package de.hanoi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIStarter {

	public static final Dimension DIMENSION_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int GUI_HEIGHT = DIMENSION_SCREEN.height/2;
	public static final int GUI_WIDTH = DIMENSION_SCREEN.width/2;
	
	
	public static void start(GamePad g) {
		JFrame gui = new JFrame("Hanoi");
		HanoiPanel face = new HanoiPanel(g);
		PlayPanel actionfield = new PlayPanel(g);
		JPanel groundPanel = new JPanel();
		
		groundPanel.setLayout(new BorderLayout());
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(GUI_WIDTH,GUI_HEIGHT);
		gui.setLocationRelativeTo(null);
		
		groundPanel.add(face, BorderLayout.CENTER);
		groundPanel.add(actionfield, BorderLayout.PAGE_END);
		
		gui.add(groundPanel);

		gui.setVisible(true);
		
		new Thread(new Runnable(){
			public void run()
			{
				while(true)
					gui.repaint();
			}
		}).start();
	}

}
