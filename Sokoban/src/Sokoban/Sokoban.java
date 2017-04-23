package Sokoban;

import java.awt.Graphics;

public class Sokoban extends GUI {
	
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
		
	}
	
	public void redraw(Graphics g){
		
	}
	
	public static void main(String[] args){
		new Sokoban();
	}

}
