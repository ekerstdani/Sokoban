package Sokoban;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Objects.Area;
import Objects.Player;
import Rendering.Drawing;

public class Sokoban extends GUI {
	
	private static final String PATH = "src/Images/";
	private int imageWidth = getImageW();
	private int imageHeight = getImageH();
	
	
    
	//Class Fields
	
	private Drawing draw = new Drawing(drawing);
	private Player p = new Player(" ");
	private Direction dir = Direction.SOUTH;
	public enum Direction {
		NORTH, WEST, EAST, SOUTH
	};
	
	
	public Sokoban(){
		imageWidth = getImageW();
		imageHeight = getImageH();
		//Get Players Name
		
		p.setName(JOptionPane.showInputDialog(getFrame(), "Enter a Username", "Username", JOptionPane.PLAIN_MESSAGE));
		getTextOutputArea().append("Username is: "+p.getName() +"\n");
	}
	
	
	
	public void onMove(Move m){
		
		if(m==Move.LEFT){
			dir=Direction.WEST;
			if(p.getxPos()>=10){
				p.setxPos(p.getxPos()-10);
			}
			
			
		}
		if(m==Move.RIGHT){
			dir=Direction.EAST;
			if(p.getxPos()<getFrame().getWidth()-(imageWidth+20)){
				p.setxPos(p.getxPos()+10);
				
			}
		}
		
		if(m==Move.DOWN){
			dir=Direction.SOUTH;
			
		}
		if(m==Move.UP){
			dir=Direction.NORTH;
			
		}
		
	}
	
	
	
	public void redraw(Graphics g){
		//Draw The Area
		draw.drawArea(getImageH(), getImageW(), g);
		draw.drawPlayer(imageHeight, imageWidth, p.getxPos(), p.getyPos(), g, dir);
		
	}
	
	public static void main(String[] args){
		
		// Choosing Floor Screen
		
		
		//Main
		new Sokoban();
	}



	@Override
	protected void changeName() {
		p.setName(JOptionPane.showInputDialog(getFrame(), "Enter a Username", "Username", JOptionPane.PLAIN_MESSAGE));
		getTextOutputArea().setText("Username is: "+p.getName() +"\n");
		
	}

}
