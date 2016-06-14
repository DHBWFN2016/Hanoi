package de.hanoi;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton commit = new JButton("Commit!");
	private JButton resetb = new JButton("Reset");
	private JLabel lbl_moves = new JLabel("Number of moves: ");
	private JLabel lbl_number = new JLabel("0");
	private GridBagLayout grid = new GridBagLayout();
	
	public void init()
	{
		this.setLayout(grid);
		commit.setPreferredSize(new Dimension(100, 25));
		commit.setLocation(getWidth()/2, getHeight());
		
		lbl_moves.setLocation(0, 0);
		
		lbl_number.setSize(25, 18);
		lbl_number.setEnabled(false);
		
		add(lbl_moves);
		add(lbl_number);
		add(commit);
		add(resetb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
