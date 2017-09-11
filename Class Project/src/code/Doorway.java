package code;
/**
 * Subclass of the BoardObject class used to store doorways in the game board.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Doorway extends BoardObject{
	/** Stores the name of the doorway, e.g. "Study Door". */
	String name;
	/** Stores the room object to which the player is tied. */
	Room room;
	/**
	 * The constructor for the Doorway class. Sets each variable above to the arguments passed.
	 * @param name The name of the doorway.
	 * @param room The room to which the doorway is tied.
	 */
	public Doorway(String name, Room room){
		this.name = name;
		this.room = room;
	}
	/**
	 * Returns "D" to be able to print an image of the board used in testing.
	 */
	public String toString(){
		return "D";
	}
	/**
	 * Adds the player passed to the room object tied to this doorway object. Used to
	 * add players to rooms.
	 *
	 * @param play The player to be added to the room object tied to this doorway object.
	 */
	public void addToRoom(Player play){
		room.add(play);
	}
	public String getRoomName(){
		return room.toString();
	}
}
