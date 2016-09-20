package edu.buffalo.cse116;
import java.util.ArrayList;

public class Room extends Card{
	
	String roomName;
	ArrayList<Player> players;
	
	public Room (String name){
		roomName = name;
		players = new ArrayList<Player>();
	}
	
	public void add(Player p){
		players.add(p);
	}
	
	public void remove(Player p){
		players.remove(p);
	}
}
