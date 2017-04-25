package Sokoban;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import Objects.Area;
import Objects.Player;

public class Sokoban extends GUI{
	
	private int imageWidth = getImageW();
	private int imageHeight = getImageH();
	
	
    
	//Class Fields
	
	private Player p = new Player(" ",drawing);
	private Area area = new Area(drawing);
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
			if(p.getyPos()<=drawing.getHeight()-(imageHeight+10)){
				p.setyPos(p.getyPos()+10);
			}
			
		}
		if(m==Move.UP){
			dir=Direction.NORTH;
			if(p.getyPos()>=10){
				p.setyPos(p.getyPos()-10);
			}
		}
		
	}
	
	
	
	public void redraw(Graphics g){
		//Draw The Area
		area.drawArea(getImageH(), getImageW(), g);
		p.drawPlayer(imageHeight, imageWidth, p.getxPos(), p.getyPos(), g, dir);
		
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



	@Override
	protected void setGround(String s) {
		// TODO Auto-generated method stub
		area.setGround(s);
	}

}
