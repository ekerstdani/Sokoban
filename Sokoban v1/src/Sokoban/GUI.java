package Sokoban;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GUI {

	//GUI Default Height and Width
	private static final int DEFULT_DRAWING_HEIGHT = 600;
	private static final int DEFULT_DRAWING_WIDTH = 800;
	
	//Variables for the GUI
	private JFrame frame;
	private JPanel controls;
	
	
	/*
	 * Enum of operations that can be used to move the character or map
	 */
	public enum Move {
		UP, LEFT, DOWN, RIGHT, ZOOM_IN, ZOOM_OUT
	};
	
	
	//These are the methods you need to implement
	protected abstract void redraw(Graphics g);
	
	protected abstract void onMove(Move m);
	
	
	public void redraw(){
		frame.repaint();
	}
	/*
	 * This calls the Initialise() to set up the GUI
	 */
	public GUI(){
		initialise();
	}
	
	
	
	/*
	 * This Initialises The GUI
	 * Creates all of the buttons
	 */
	private void initialise() {
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			/*
			 * Will exit the GUI when the "Quit" Button is Pressed
			 */
			@Override
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		
		
		/*
		 * Adding Moving Buttons
		 * Left/WEST
		 */
		JButton left = new JButton("\u2190");
		left.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onMove(Move.LEFT);
				redraw();
			}
		});
		
		//Right/EAST
		JButton right = new JButton("\u2192");
		right.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onMove(Move.RIGHT);
				redraw();
			}
		});
		
		//Up/North
		JButton up = new JButton("\u2191");
		up.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onMove(Move.UP);
				redraw();
			}
		});
		
		//Down/South
		JButton down = new JButton("\u2193");
		down.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onMove(Move.DOWN);
				redraw();
			}
			
		});
		
		//Zoom In 
		
		//Zoom Out
		
		
		/*
		 * Making the Layout for the Conrol Panel
		 */
		controls = new JPanel();
		controls.setLayout(new BoxLayout(controls, BoxLayout.LINE_AXIS));
		
		//Make an empty border so componets arent up on the screen
		
		
		
		
		
		
		
	} //End of Init()
	
	
}
