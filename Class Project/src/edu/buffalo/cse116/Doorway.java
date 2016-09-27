package edu.buffalo.cse116;

public class Doorway extends BoardObject{
	
	String name; 
	BoardObject room;
	
	
	public Doorway(String name, BoardObject room){
		this.name = name; 
		this.room = room; 
	}
	
	
	public String toString(){
		return "D"; 
	}
}
