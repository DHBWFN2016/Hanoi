package de.hanoi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The class GUIStarter launch the Graphical User Interface that is divided in two fractions.
 * These fractions are the {@link HanoiPanel} and the {@link PlayPanel}
 * @author severino.detta
 *
 */
public class GUIStarter {

	/**
	 * Define the GUI size
	 */
	private static final Dimension DIMENSION_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int GUI_HEIGHT = DIMENSION_SCREEN.height/2;
	private static final int GUI_WIDTH = DIMENSION_SCREEN.width/2;
	
	/**
	 * Draw a GUI with its components, that are influenced by a GamePad 
	 * @param g the required GamePad for the initialization of the current GUI  
	 */
	public static void start(GamePad g, boolean autoplay) {
		
		JFrame gui = new JFrame("Hanoi");
		HanoiPanel face = new HanoiPanel(g);
		PlayPanel actionfield = new PlayPanel(g, autoplay);
		JPanel groundPanel = new JPanel();
		
		groundPanel.setLayout(new BorderLayout());
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(GUI_WIDTH,GUI_HEIGHT);
		gui.setMinimumSize(new Dimension(730, 350));
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