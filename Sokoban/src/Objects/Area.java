package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Area {

	private JComponent drawing;
	private final String PATH ="src/Images/";
	private BufferedImage area;
	private String ground = "GroundGravel_Sand.png";
	
	
	public Area(JComponent drawing){
		this.drawing=drawing;

	}
	
	
	
	public void setGround(String s){
		ground=s;
	}
	
	
	public void drawArea(int imageHeight, int imageWidth, Graphics g){
		
		try {
			area = ImageIO.read(new File(PATH+ground));
			//Loop to fill entire screen
			for(int i = 0; i < drawing.getWidth(); i+=imageWidth){
				for(int j = 0; j < drawing.getHeight(); j+=imageHeight){
					g.drawImage(area,i,j,imageWidth,imageHeight, drawing);
				}
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
}
