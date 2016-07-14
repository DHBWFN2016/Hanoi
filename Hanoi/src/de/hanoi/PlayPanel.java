package de.hanoi;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PlayPanel is where the User have to play. It creates a control area with Buttons etc.
 * and it is a fragment of the GUI.
 * @author severino.detta
 *
 */
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
	private JLabel lbl_from = new JLabel("From: ");
	private JLabel lbl_to = new JLabel("To: ");
	private JComboBox<Integer> box1 = new JComboBox<Integer>();
	private JComboBox<Integer> box2 = new JComboBox<Integer>();
	private FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
	private GamePad gamepad;
	
	/**
	 * Initializes a PlayPanel with a given GamePad
	 * @param g The GamePad that should be initialized
	 */
	public PlayPanel(GamePad g)
	{
		gamepad = g;
		init();
	}
	
	/**
	 * Initializes the action instruments and their function
	 */
	public void init()
	{
		this.setLayout(flow);
		commit.addActionListener(this);
		
		resetb.addActionListener(new ActionListener() {
			/**
			 * Define the action of the button "Reset"
			 */
			public void actionPerformed(ActionEvent a) {
				gamepad.resetMoves();
			}
		});
		
		autosolve.addActionListener(new ActionListener() {
			/**
			 * Define the action of the button "Solve automatically"
			 */
			public void actionPerformed(ActionEvent a) {
				gamepad.autoSolve();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			/**
			 * Define the action of the button "Cancel solving"
			 */
			public void actionPerformed(ActionEvent a) {
				gamepad.cancelSolving();
			}
		});
		
		lbl_number.setEnabled(false);

		for(int i = 1; i < 4; i++)
			box1.addItem(i);
		for(int i = 1; i < 4; i++)
			box2.addItem(i);
		
		add(lbl_moves);
		add(lbl_number);
		add(lbl_from);
		add(box1);
		add(lbl_to);
		add(box2);
		add(commit);
		add(autosolve);
		add(cancel);
		add(resetb);
	}
	
	/**
	 * Updated the number of moves shown in the GUI
	 */
	public void paintComponent(Graphics g) {
		lbl_number.setText(""+gamepad.getMoves());
	}

	/**
	 * Define the action of the button "Commit"
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if(gamepad.move(((Integer) box1.getSelectedItem())-1, ((Integer)(box2.getSelectedItem()))-1))
				System.out.println("You won with " + gamepad.getMoves() + " moves!");
		} catch (IllegalMovementException e1) {
			e1.printStackTrace();
		}
	}

}
