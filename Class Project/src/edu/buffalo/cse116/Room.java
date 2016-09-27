package edu.buffalo.cse116;
import java.util.ArrayList;

public class Room extends BoardObject{
	
	String name;
	ArrayList<Player> players;
	
	public Room (String name){
		this.name = name;
		players = new ArrayList<Player>();
	}
	
	public void add(Player p){
		players.add(p);
	}
	
	public void remove(Player p){
		players.remove(p);
	}
	
	public String toString(){
		return name; 
	}
}
