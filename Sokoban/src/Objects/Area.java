package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Area {
	private static int imageWidth = 35;
	private static int imageHeight = 40;
	private static final String PATH = "src/Images/";
	
	public void drawArea(Graphics g, JComponent drawing){
		
		try {
			BufferedImage character = ImageIO.read(new File(PATH+"Character4.png"));
			g.drawImage(character,300,400,imageWidth,imageHeight, drawing);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
