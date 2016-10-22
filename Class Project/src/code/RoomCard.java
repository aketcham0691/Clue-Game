package code;
/**
 * Subclass of Card used for the different rooms in the game.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class RoomCard extends Card{
	/**
	 * Stores the name of the room.
	 */
	private String roomName;
	/**
	 * Constructor that sets the room's name.
	 * @param name Name of the room.
	 */
	public RoomCard(String name){
		roomName = name;
	}
	
	/**
	 * Returns the room's name.
	 */
	public String toString(){
		return roomName;
	}

}
