package code;
import java.util.ArrayList;
/**
 * Subclass of the BoardObject class, allowing you to put one or more players into
 * a room using an ArrayList<Player>.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Room extends BoardObject{
	/** Stores the name of the room, e.g. "Billiard Room". */
	String name;
	/** Stores the players that are currently in the room. */
	ArrayList<Player> players;
	/**
	 *  The constructor for the room class. Sets each variable above to the arguments passed.
	 * @param name Name of the room.
	 */
	public Room (String name){
		this.name = name;
		players = new ArrayList<Player>();
	}
	/**
	 * Adds the player passed to the ArrayList<Player> object tied to this room object.
	 * @param p The player to be added to the ArrayList<Player> object
	 */
	public void add(Player p){
		players.add(p);
	}
	/**
	 * Removes the player passed from the ArrayList<Player> object tied to this room object.
	 * @param p The player to be removed from the ArrayList<Player> object
	 */
	public void remove(Player p){
		players.remove(p);
	}
	/**
	 * @return Returns the room's name.
	 */
	public String toString(){
		return name; 
	}
	/**
	 * @return Returns the ArrayList<Player> object tied to this room. Therefore, returning all
	 * players currently within the room.
	 */
	public ArrayList<Player> getMembers(){
		return players;
	}
	public void printMembers(){
		for (Player p : players){
			System.out.println(p.getName());
		}
	}
}
