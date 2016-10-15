package code;

public class Board {
	
	public static BoardObject[][] board;
	// Clue is 25 x 24
	public Board(int x, int y){
		board = new BoardObject[x][y];
	}
	
	public void populate(BoardObject obj, int x, int y){
		board[x][y] = obj;
	}
	
	public BoardObject occupied(int x, int y){
		return board[x][y];
	}
	
	public BoardObject[][] getBoard(){
		return board; 
	}
}

