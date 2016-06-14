package de.hanoi;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton button = new JButton("Commit!");
	private JLabel lbl_moves = new JLabel("Number of moves: ");
	private JLabel lbl_number = new JLabel("0");
	
	public void init()
	{
		this.setLayout(new FlowLayout());
		button.setPreferredSize(new Dimension(100, 25));
		button.setLocation(getWidth()/2, getHeight());
		
		lbl_moves.setLocation(0, 0);
		
		lbl_number.setSize(25, 18);
		lbl_number.setEnabled(false);
		
		add(lbl_moves);
		add(lbl_number);
		add(button);
	}

}
