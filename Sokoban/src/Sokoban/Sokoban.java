package Sokoban;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Objects.Area;
import Objects.Player;

public class Sokoban extends GUI {
	
	private static final String PATH = "src/Images/";
	private int imageWidth = getImageW();
	private int imageHeight = getImageH();
	
	private String userName=" ";
    
	//Class Fields
	private Area area = new Area();;
	
	private Player p = new Player(userName);
	
	
	public Sokoban(){
		imageWidth = getImageW();
		imageHeight = getImageH();
		//Get Players Name
		
		userName=JOptionPane.showInputDialog(getFrame(), "Enter a Username", "Username", JOptionPane.PLAIN_MESSAGE);
		getTextOutputArea().append("Username is: "+userName);
	}
	
	
	
	public void onMove(Move m){
		
		if(m==Move.LEFT){
			getTextOutputArea().setText("You Move Left\n");
			
			if(p.getxPos()>0){
				p.setxPos(p.getxPos()-1);
			}
			
		}
		if(m==Move.RIGHT){
			getTextOutputArea().setText("You Move Right\n");
			if(p.getxPos()<getFrame().getWidth()){
				p.setxPos(p.getxPos()+1);
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
			setImageW(getImageW()+1);
			setImageH(getImageH()+1);
			
		}
		if(m==Move.ZOOM_OUT){
			getTextOutputArea().setText("You Zoom Out\n");
			setImageW(getImageW()-1);
			setImageH(getImageH()-1);
			
		}
		
	}
	
	
	
	public void redraw(Graphics g){
		//Draw The Area
		area.drawArea(g, drawing, PATH, getImageH(), getImageW());
		p.drawChar(g, drawing, PATH, getImageH(), getImageW());
		
	}
	
	public static void main(String[] args){
		
		// Choosing Floor Screen
		
		
		//Main
		new Sokoban();
	}

}
