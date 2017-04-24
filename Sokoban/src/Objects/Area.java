package Objects;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Area {

	
	
	public void drawArea(Graphics g, JComponent drawing, String PATH, int imageHeight, int imageWidth){
		
		try {
			BufferedImage character = ImageIO.read(new File(PATH+"GroundGravel_Sand.png"));
			
			//Loop to fill entire screen
			for(int i = 0; i < drawing.getWidth(); i+=imageWidth){
				for(int j = 0; j < drawing.getHeight(); j+=imageHeight){
					g.drawImage(character,i,j,imageWidth,imageHeight, drawing);
				}
			}
			
			g.drawImage(character,0,0,imageWidth,imageHeight, drawing);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
	
}
