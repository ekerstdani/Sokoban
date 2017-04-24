package Objects;



public class Player {
	String name;
	int xPos = 0;
	int yPos = 0;
	public Player(String name){
 		this.name = name;
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