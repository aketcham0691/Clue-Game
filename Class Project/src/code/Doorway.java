package code;

public class Doorway extends BoardObject{
	
	String name; 
	Room room;
	
	
	public Doorway(String name, Room room){
		this.name = name; 
		this.room = room; 
	}
	
	
	public String toString(){
		return "D"; 
	}
	
	public void addToRoom(Player play){
		room.add(play);
	}
}
