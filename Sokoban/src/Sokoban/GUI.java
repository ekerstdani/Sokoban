package Sokoban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

public abstract class GUI {

	//GUI Default Height and Width
	private static final int DEFULT_DRAWING_HEIGHT = 600;
	private static final int DEFULT_DRAWING_WIDTH = 800;
	private static final int TEXT_OUTPUT_ROWS = 5;
	private static final int INPUT_COl = 15;
	
	//Variables for the GUI
	private JFrame frame;
	private JPanel controls;
	protected JComponent drawing;
	private JTextArea textOutputArea;
	private JTextField input;
	
	
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
	
	//Useful methods that i will need
	
	public JTextArea getTextOutputArea(){
		return textOutputArea;
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
	@SuppressWarnings("serial")
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
		
		
		input = new JTextField(INPUT_COl);
		input.setMaximumSize(new Dimension(0,25));
		input.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Not Sure				
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
				JButton in = new JButton("+");
				in.addActionListener( new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						onMove(Move.ZOOM_IN);
						redraw();
					}
					
				});
		
		//Zoom Out
				JButton out = new JButton("\u2012");
				out.addActionListener( new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						onMove(Move.ZOOM_OUT);
						redraw();
					}
					
				});
		
		
		/*
		 * Making the Layout for the Conrol Panel
		 */
		controls = new JPanel();
		controls.setLayout(new BoxLayout(controls, BoxLayout.LINE_AXIS));
		
		//Make an empty border so componets arent up on the screen
		
		Border edge = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		controls.setBorder(edge);
		
		JPanel q = new JPanel();
		q.setLayout(new GridLayout(2,1));
		q.setMaximumSize(new Dimension(50,100));
		q.add(quit);
		controls.add(q);
		
		//Rigid area, space components out
		controls.add(Box.createRigidArea(new Dimension(15,0)));
		
		JPanel nav = new JPanel();
		nav.setMaximumSize(new Dimension(150,60));
		nav.setLayout(new GridLayout(2,3));//(2,3) if add Zoom
		nav.add(out);
		nav.add(up);
		nav.add(in);
		nav.add(left);
		nav.add(down);
		nav.add(right);
		controls.add(nav);
		controls.add(Box.createRigidArea(new Dimension(15,0)));
		controls.add(Box.createHorizontalGlue());
		
		controls.add(new JLabel("User Input"));
		controls.add(Box.createRigidArea(new Dimension(5,0)));
		controls.add(input);
		//Drawing Component 
		
		drawing = new JComponent(){
			protected void paintComponent(Graphics g){
				redraw(g);
			}
		};
		
		drawing.setPreferredSize(new Dimension(DEFULT_DRAWING_WIDTH,DEFULT_DRAWING_HEIGHT));
		drawing.setVisible(true);
		
		
		//Make a text output area
		
		textOutputArea = new JTextArea(TEXT_OUTPUT_ROWS,0);
		textOutputArea.setLineWrap(true);
		textOutputArea.setWrapStyleWord(true);
		textOutputArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textOutputArea);
		DefaultCaret caret = (DefaultCaret) textOutputArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		//Make main Frame
		
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setDividerSize(5);
		split.setContinuousLayout(true);
		split.setResizeWeight(1);
		split.setBorder(BorderFactory.createEmptyBorder());
		split.setTopComponent(drawing);
		split.setBottomComponent(scroll);
		
		frame = new JFrame("Sokoban");
		
		//Makes program actually quit when button pressed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(controls, BorderLayout.NORTH);
		frame.add(split, BorderLayout.CENTER);
		
		
		frame.pack();
		frame.setVisible(true);
		
	} //End of Init()
	
	
}