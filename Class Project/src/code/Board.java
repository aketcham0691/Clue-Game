package code;
/**
 * Class that implements the game board. The game board is represented by 
 * a two-dimensional BoardOject array. This class also has methods for initializing 
 * the elements of the array, returning which BoardObject subclass an element of the 
 * array is initialized to, and returning the array as well. 
 * @author Andrew Ketcham, Kevin Hanley, and Brian Irving.
 *
 */
public class Board {
	/** Stores the two-dimensional BoardObject array. */
	private BoardObject[][] board;
	/**
	 * The constructor for the Board class. Allows two int variables to be 
	 * passed as argument. Instantiates the BoardObject array having a certain number
	 * of rows equal to the first variable passed in, and a certain number of columns 
	 * equal to the second variable passed in.
	 * @param x The number of rows the BoardObject array will have.
	 * @param y The number of columns the BoardObject array will have.
	 */
	public Board(int x, int y){
		board = new BoardObject[x][y];
	}
	/**
	 * Method that takes a BoardObject object, and two int values . The method then 
	 * initializes the element within the BoardObject array to the BoardObject
	 * object passed in. The element's row will be equal to the first int value passed 
	 * in, and the element's column will be equal to the second int value passed in. 
	 * @param obj The BoardObject object the array element will be initialized to.
	 * @param x The array element's row.
	 * @param y The array element's column.
	 */
	public void populate(BoardObject obj, int x, int y){
		board[x][y] = obj;
	}
	/**
	 * @param x The array element's row.
	 * @param y The array element's column.
	 * @return Returns the BoardObject object the element is currently initialized to.
	 */
	public BoardObject occupied(int x, int y){
		return board[x][y];
	}
	/**
	 * @return Returns the BoardObject array.
	 */
	public BoardObject[][] getBoard(){
		return board; 
	}
}

