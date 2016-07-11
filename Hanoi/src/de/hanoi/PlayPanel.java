package de.hanoi;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton commit = new JButton("Commit!");
	private JButton resetb = new JButton("Reset");
	private JButton autosolve = new JButton("Solve automatically");
	private JButton cancel = new JButton("Cancel solving");
	private JLabel lbl_moves = new JLabel("Number of moves: ");
	private JLabel lbl_number = new JLabel("0");
	private JComboBox<Integer> box1 = new JComboBox<Integer>();
	private JComboBox<Integer> box2 = new JComboBox<Integer>();
	private GridBagLayout grid = new GridBagLayout();
	private GamePad gamepad;
	
	public PlayPanel(GamePad g)
	{
		gamepad = g;
		init();
	}
	
	public void init()
	{
		this.setLayout(grid);
		commit.setPreferredSize(new Dimension(100, 25));
		commit.setLocation(getWidth()/2, getHeight());
		commit.addActionListener(this);
		
		resetb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				gamepad.resetMoves();
			}
		});
		
		autosolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				gamepad.autoSolve();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				gamepad.cancelSolving();
			}
		});
		
		lbl_moves.setLocation(0, 0);
		
		lbl_number.setSize(25, 18);
		lbl_number.setEnabled(false);

		for(int i = 1; i < 4; i++)
			box1.addItem(i);
		for(int i = 1; i < 4; i++)
			box2.addItem(i);
		
		add(lbl_moves);
		add(lbl_number);
		add(box1);
		add(box2);
		add(autosolve);
		add(cancel);
		add(commit);
		add(resetb);
	}
	
	public void paintComponent(Graphics g) {
		lbl_number.setText(""+gamepad.getMoves());
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if(gamepad.move(((Integer) box1.getSelectedItem())-1, ((Integer)(box2.getSelectedItem()))-1))
				System.out.println("You won with " + gamepad.getMoves() + " moves!");
		} catch (IllegalMovementException e1) {
			e1.printStackTrace();
		}
	}

}
