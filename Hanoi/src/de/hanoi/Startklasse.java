package de.hanoi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Startklasse {

	public static final Dimension DIMENSION_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int GUI_HEIGHT = DIMENSION_SCREEN.height/2;
	public static final int GUI_WIDTH = DIMENSION_SCREEN.width/2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame gui = new JFrame("Hanoi");
		HanoiPanel face = new HanoiPanel();
		PlayPanel actionfield = new PlayPanel();
		JPanel groundPanel = new JPanel();
		
		groundPanel.setLayout(new BorderLayout());
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(GUI_WIDTH,GUI_HEIGHT);
		gui.setLocationRelativeTo(null);
		
		groundPanel.add(face, BorderLayout.CENTER);
		groundPanel.add(actionfield, BorderLayout.PAGE_END);
		
		actionfield.init();
		
		gui.add(groundPanel);

		gui.setVisible(true);
	}

}
