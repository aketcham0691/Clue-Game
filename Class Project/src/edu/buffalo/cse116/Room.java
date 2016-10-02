package edu.buffalo.cse116;
import java.util.ArrayList;

<<<<<<< Upstream, based on origin/master
public class Room extends BoardObject{
=======
public class Room{
	//(Brian) I changed this class so that it no longer extended the card class, i'm pretty sure the physical room element 
	//is different from the room(so it would need diff code) represented by the card
>>>>>>> 7502fdd j
	
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
