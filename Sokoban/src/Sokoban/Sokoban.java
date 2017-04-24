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
	
	private Graphics graphic;
	private Drawing draw = new Drawing(drawing);
	private Player p = new Player(" ");
	
	public enum Direction {
		NORTH, WEST, EAST, SOUTH
	};
	
	
	public Sokoban(){
		imageWidth = getImageW();
		imageHeight = getImageH();
		//Get Players Name
		
		p.setName(JOptionPane.showInputDialog(getFrame(), "Enter a Username", "Username", JOptionPane.PLAIN_MESSAGE));
		getTextOutputArea().append("Username is: "+p.getName());
	}
	
	
	
	public void onMove(Move m){
		
		if(m==Move.LEFT){
			getTextOutputArea().setText("You Move Left\n");
			
			if(p.getxPos()>=10){
				p.setxPos(p.getxPos()-10);
			}
			
		}
		if(m==Move.RIGHT){
			getTextOutputArea().setText("You Move Right\n");
			if(p.getxPos()<getFrame().getWidth()-(imageWidth+20)){
				p.setxPos(p.getxPos()+10);
			}
		}
		
		if(m==Move.DOWN){
			getTextOutputArea().setText("You Move Down\n");
			
		}
		if(m==Move.UP){
			getTextOutputArea().setText("You Move Up\n");
			
		}
		if(m==Move.ZOOM_IN){
			
			getTextOutputArea().setText("You Zoom In\n");
			setImageW(getImageW()+5);
			setImageH(getImageH()+5);
			
		}
		if(m==Move.ZOOM_OUT){
			getTextOutputArea().setText("You Zoom Out\n");
			setImageW(getImageW()-5);
			setImageH(getImageH()-5);
			
		}
		
	}
	
	
	
	public void redraw(Graphics g){
		//Draw The Area
		graphic = g;
		//area.drawArea(g, drawing, PATH, getImageH(), getImageW());
		draw.drawArea(getImageH(), getImageW(), g);
		draw.drawPlayer(imageHeight, imageWidth, p.getxPos(), p.getyPos(), g, Direction.SOUTH );
		//p.drawChar(g, drawing, PATH, getImageH(), getImageW());
		
	}
	
	public static void main(String[] args){
		
		// Choosing Floor Screen
		
		
		//Main
		new Sokoban();
	}

}
