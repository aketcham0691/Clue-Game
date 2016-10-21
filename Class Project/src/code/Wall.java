package code;
/**
 * Subclass of the BoardObject class used to store walls in the game board.
 * @author Andrew Ketcham, Kevin Hanley, and Brian Irving.s
 *
 */
public class Wall extends BoardObject{

	/**
	 * Returns "W" to be able to print and image of the board used in testing.
	 */
	public String toString(){
		return "W"; 
	}
}
