package code;

public class RoomCard extends Card{
	private String roomName;
	
	public RoomCard(String name){
		roomName = name;
	}
	
	public String toString(){
		return roomName;
	}

}
