package code;
/**
 * Subclass of the BoardObject class used to store walls in the game board.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Wall extends BoardObject{

	/**
	 * Returns "W" to be able to print an image of the board used in testing.
	 */
	public String toString(){
		return "W"; 
	}
}
