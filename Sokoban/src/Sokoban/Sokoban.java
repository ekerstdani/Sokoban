package Sokoban;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sokoban extends GUI {
	private static final String PATH = "src/Images/";
	private static int imageHeight = 40;
	private static int imageWidth = 35;

	public Sokoban(){}
	
	public void onMove(Move m){
		if(m==Move.LEFT){
			getTextOutputArea().setText("You Move Left\n");
			
		}
		if(m==Move.RIGHT){
			getTextOutputArea().setText("You Move Right\n");
			
		}
		if(m==Move.DOWN){
			getTextOutputArea().setText("You Move Down\n");
			
		}
		if(m==Move.UP){
			getTextOutputArea().setText("You Move Up\n");
			
		}
		if(m==Move.ZOOM_IN){
			imageHeight++;
			imageWidth++;
			
		}
		if(m==Move.ZOOM_OUT){
			imageHeight--;
			imageWidth--;
		}
		
	}
	
	public void redraw(Graphics g){
		try {
			BufferedImage character = ImageIO.read(new File(PATH+"Character4.png"));
			g.drawImage(character,300,400,imageWidth,imageHeight, drawing);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new Sokoban();
	}

	public static void setImageHeight(int imageHeight) {
		Sokoban.imageHeight = imageHeight;
	}

	public static void setImageWidth(int imageWidth) {
		Sokoban.imageWidth = imageWidth;
	}
	
	
	//Helper Methods

}
