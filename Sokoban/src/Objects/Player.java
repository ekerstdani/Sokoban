package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Player {
	String name;
	int xPos = 0;
	int yPos = 0;
	public Player(String name){
 		this.name = name;
	}

	
	
	public void drawChar(Graphics g, JComponent drawing, String PATH, int imageHeight, int imageWidth){
		
		
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