package edu.buffalo.cse116;

public abstract class BoardObject {
	protected int xPos = 0;
	protected int yPos = 0;
	
	

	public void setXPosition(int x){
		xPos = x;
	}
	
	public void setYPosition(int y){
		yPos = y;
	}
	
	public int getXPosition(){
		return xPos;
	}
	
	public int getYPosition(){
		return yPos;
	}
	
	
}
