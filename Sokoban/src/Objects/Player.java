package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Sokoban.Sokoban.Direction;



public class Player {
	private String name;
	private int xPos = 0;
	private int yPos = 0;
	private JComponent drawing;
	private final String PATH ="src/Images/";
	
	public Player(String name, JComponent drawing){
 		this.name = name;
 		this.drawing=drawing;
	}
	
	
	public void drawPlayer(int imageHeight, int imageWidth, int xPos, int yPos, Graphics g, Direction d){
		BufferedImage character = null;
		try {
			//What picture to draw
			if(d.equals(Direction.SOUTH)){
				character = ImageIO.read(new File(PATH+"Character4.png"));
			}
			else if(d.equals(Direction.NORTH)){
				character = ImageIO.read(new File(PATH+"Character7.png"));
			}
			else if(d.equals(Direction.EAST)){
				//Stopping
				character = ImageIO.read(new File(PATH+"Character3.png"));
			
			}
			else if(d.equals(Direction.WEST)){
				character = ImageIO.read(new File(PATH+"Character10.png"));
			}
			g.drawImage(character,xPos,yPos,imageWidth,imageHeight, drawing);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	
	//Helper Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getxPos() {
		return xPos;
	}



	public void setxPos(int xPos) {
		this.xPos = xPos;
	}



	public int getyPos() {
		return yPos;
	}



	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	
	

}