package code;

import java.util.Random;
import java.util.ArrayList;
/**
 * Class that implements the players of the game, including methods for movement and making suggestions. 
 * @author Andrew Ketcham, Kevin Hanley, and Brian Irving.
 *
 */
public class Player extends BoardObject {
	/** Stores the name of the player, e.g. "Professor Plum". */
	private String name;
	/** Stores the player's x coordinate on the game board. */
	private int xPos;
	/** Stores the player's y coordinate on the game board. */
	private int yPos;
	/** Stores the board object to which this player is tied. 
	 *  When game is instantiated, all players are tied to the same board.
	 */
	private Board board;
	private Room study;
	/** The following room variables store the rooms to which the player is tied, similar to board above */
	private Room hall;
	private Room lounge;
	private Room library;
	private Room diningRoom;
	private Room billiardRoom;
	private Room conservatory;
	private Room ballroom;
	private Room kitchen;
	/** Stores the hallway object to which the player is tied. */
	private Hallway hallWay;
	/** Stores the game to which the player is tied.*/
	private Game game;
	/** Stores the cards that the player has in his/her hand.*/
	private ArrayList<Card> playersCards=new ArrayList<Card>();
	/** This Random object is used to generate the dice rolls.*/
	private Random rand = new Random();
	/**
	 * The constructor for the player class. Sets each variable above to the arguments passed.
	 * @param name The name of the player, e.g. "Professor Plum."
	 * @param board The board to which the player is tied.
	 * @param xPos The initial x position of the player.
	 * @param yPos The initial y position of the player.
	 * @param study The study to which the player is tied.
	 * @param hall The hall to which the player is tied.
	 * @param lounge The lounge to which the player is tied.
	 * @param library The library to which the player is tied.
	 * @param diningRoom The dining room to which the player is tied.
	 * @param billiardRoom The billiard room to which the player is tied.
	 * @param conservatory The conservatory to which the player is tied.
	 * @param ballroom The ballroom to which the player is tied.
	 * @param kitchen The kitchen to which the player is tied.
	 * @param hallWay The hallway to which the player is tied.
	 * @param game The game to which the player is tied.
	 */
	public Player(String name, Board board, int xPos, int yPos, Room study, Room hall, Room lounge, Room library, Room diningRoom, Room billiardRoom, Room conservatory, Room ballroom, Room kitchen, Hallway hallWay, Game game){
		this.name = name; 
		this.board = board; 
		this.xPos = xPos; 
		this.yPos = yPos;
		this.study = study;
		this.ballroom = ballroom;
		this.billiardRoom = billiardRoom;
		this.conservatory = conservatory;
		this.diningRoom = diningRoom;
		this.hall = hall;
		this.kitchen = kitchen;
		this.library = library;
		this.lounge = lounge;
		this.hallWay = hallWay;
		this.game = game;
	}
	/**
	 * This move method is limited to one square movement. The completeMove() method below takes an
	 * ArrayList of these movements as its argument to make a complete movement.
	 * 
	 * The method first checks whether the player is in a room, and, if so, allows the player to only move
	 * to the spaces on the board directly outside of the respective room. It performs this check for each room.
	 * If the players attempts to move to a space other than directly outside the room, or
	 * if there is a player blocking the door, the method returns false.
	 * 
	 * The method then checks if the space selected for movement is greater than one space away. If so,
	 * the method returns false.
	 * 
	 * The method then checks whether the space selected for movement contains a hallway, doorway, player, or wall. 
	 * If the space contains a player or wall, the method returns false. If the space contains a doorway,
	 * the method places the player into the room associated with the doorway and returns true. 
	 * Finally, if the space contains a hallway, the method updates the players x and y position and returns true.
	 * 
	 * @param x The x position selected for movement.
	 * @param y The y position selected for movement.
	 * @return Returns false if the movement is illegal and true if the movement is legal.
	 */
	public boolean move (int x, int y){
		if (study.getMembers().contains(this)){
			if (x != 4 && y != 6){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				study.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (hall.getMembers().contains(this)){
			if ((x != 4 && y != 8) || (x != 7 && y != 11) || (x != 7 && y != 12) ){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				hall.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (lounge.getMembers().contains(this)){
			if ((x != 6 && y != 17)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				lounge.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (library.getMembers().contains(this)){
			if ((x != 8 && y != 7) || (x != 11 && y != 3)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				library.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (billiardRoom.getMembers().contains(this)){
			if ((x != 11 && y != 1) || (x != 15 && y != 6)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				billiardRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (diningRoom.getMembers().contains(this)){
			if ((x != 8 && y != 17) || (x != 12 && y != 15)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				diningRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (conservatory.getMembers().contains(this)){
			if (x != 19 && y != 5){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				conservatory.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (ballroom.getMembers().contains(this)){
			if ((x != 19 && y != 7) || (x != 19 && y != 16) || (x != 16 && y != 9) || (x != 16 && y != 14)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				ballroom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (kitchen.getMembers().contains(this)){
			if (x != 17 && y != 19){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				kitchen.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if(Math.abs((x - this.getX())) + Math.abs((y - this.getY())) > 1){
			return false;
		}
		else{
			BoardObject boardObject = board.occupied(x, y); 
			
			if(boardObject instanceof Wall){
				return false; 
			}
			else if(boardObject instanceof Doorway){
				Doorway doorWay = (Doorway) boardObject; 
				doorWay.addToRoom(this);
				return true;
			}
			else if(boardObject instanceof Hallway){
				this.setX(x);
				this.setY(y);
				return true;
			}
			else if(boardObject instanceof Player){
				return false;
			}
		}
		System.out.println("You can't move there");
		return false;
	}

	public int roll(){
		int roll1 = rand.nextInt(6) + 1;
		int roll2 = rand.nextInt(6) + 1;
		return roll1 + roll2; 		
	}
	/**
	 * This method takes an array of movements as an argument and determines whether the movements selected constitutes
	 * a complete legal move by the rules of the game. If the movement is legal, the method updates the objects
	 * stored in the board to reflect the movement. 
	 * 
	 * The method first checks the size of the movement array against the dice roll to determine whether the player 
	 * selected an appropriate number of moves. If not, the method returns false and prints "You can't move there."
	 * 
	 * The method then checks the truth value of each move in the array. If any one move is false, the method first
	 * updates the player's position to return it to its starting position and then returns false and prints 
	 * "You can't move there."
	 * 
	 * If a player enters a room at any point in its movement, the method returns true and replaces the player's
	 * previous position with a hallway object and sets the player's x and y coordinates to 0.
	 * 
	 * If the player selected a final position which is not obtained through the moves selected, the method
	 * returns false.
	 * 
	 * If the player does not enter a room, and does not use all moves rolled on the dice,
	 * the method returns false.
	 * 
	 * If all moves are legal, the method updates the player's x and y position to the position selected and 
	 * updates the board's objects to reflect the movement (populates the player's prior position with a hallway
	 * and populates the player's new position with the player moving). 
	 * 
	 * @param diceRoll The number rolled on the dice.
	 * @param moves The array of movements select to reach the final position.
	 * @param initX The initial x position of the player.
	 * @param initY The initial y position of the player.
	 * @param finalX The final x position of the player.
	 * @param finalY The final y position of the player.
	 * @return Returns false if the complete movement is illegal and true if it is legal.
	 */
	public boolean completeMove(int diceRoll, ArrayList<Boolean> moves, int initX, int initY, int finalX, int finalY){
		if (moves.size() > diceRoll){
			System.out.println("You can't move there");
			this.setX(initX);
			this.setY(initY);
			return false;
		}
		for (boolean move : moves){
			if (move == false){
				System.out.println("You can't move there");
				this.setX(initX);
				this.setY(initY);
				return false;
			}
			else if (study.getMembers().contains(this) || hall.getMembers().contains(this) || lounge.getMembers().contains(this) || library.getMembers().contains(this)
					|| billiardRoom.getMembers().contains(this) || diningRoom.getMembers().contains(this) || conservatory.getMembers().contains(this) || ballroom.getMembers().contains(this) || kitchen.getMembers().contains(this)){
				board.populate(hallWay, initX, initY);
				this.setX(0);
				this.setY(0);
				return true;
			}
		}
		if (finalX != this.getX() || finalY != this.getY()){
			System.out.println("Your moves don't lead to this position");
			return false;
		}
		if ((finalX != 0 && finalY != 0) && diceRoll != moves.size()){
			System.out.println("You must move the numer rolled on the dice.");
			return false;
		}
		this.setX(finalX);
		this.setY(finalY);
		board.populate(hallWay, initX, initY);
		board.populate(this, finalX, finalY);
		return true;
	}
	
	/**
	 * This method checks whether the player is in a room that has access to a passageway, and, if so, 
	 * removes the player from the current room and places it in the room to which the passageway leads.
	 * @return Returns true if the player is able to use a passageway and false if the player was not in 
	 * a room with a passageway when using the method.
	 */
	public boolean usePassageway(){
		if (study.getMembers().contains(this)){
			study.getMembers().remove(this);
			kitchen.getMembers().add(this);
			return true;
		}
		if (kitchen.getMembers().contains(this)){
			kitchen.getMembers().remove(this);
			study.getMembers().add(this);
			return true;
		}
		if (conservatory.getMembers().contains(this)){
			conservatory.getMembers().remove(this);
			lounge.getMembers().add(this);
			return true;
		}
		if (lounge.getMembers().contains(this)){
			lounge.getMembers().remove(this);
			conservatory.getMembers().add(this);
			return true;
		}
		return false;
	}
	/**
	 * Method to obtain the list of cards in the player's hand.
	 * @return Returns the ArrayList of cards in the player's hand.
	 */
	public ArrayList<Card> getPlayersCards(){
		return playersCards;
	}
	/**
	 * This method takes the cards suggested by the player and returns the player who is able to disprove
	 * the suggestion, if one exists.
	 * 
	 * The method first obtains the list of players in the game. It then checks the position of the player
	 * making the suggestion in this list. The method will first attempt to disprove the suggestion
	 * using the player immediately to the suggester's left. If this player has any of the cards suggested, 
	 * then the method returns this player. The method will continue to loop through each player until the 
	 * suggestion is disproved or has gone through each player. If no player can disprove the suggestion, 
	 * then the method returns null. 
	 * @param character The character card suggested.
	 * @param weapon The weapon card suggested.
	 * @param room The room card suggested.
	 * @return Returns the player who can disprove the suggestion (including the suggester) or null if no player
	 * can disprove the suggestion.
	 * 	 */
	public Player suggest(Card character, Card weapon, Card room){
		ArrayList<Player> players = game.getPlayers();
		int idx = players.indexOf(this);
		int guessIdx;
		if (idx == players.size() - 1){
			guessIdx = 0;
			for (int i = 0; i < players.size(); i++){
				Player guessPlayer = players.get(guessIdx);
				ArrayList<Card> guessPlayerCards = guessPlayer.getPlayersCards();
				for (Card c: guessPlayerCards){
					if (c.equals(character)|| c.equals(weapon) || c.equals(room)){
						return guessPlayer;
					}
				}
				guessIdx += 1;
			}
			return null;
		}
		else{
			guessIdx = idx + 1;
			for (int i = 0; i < players.size(); i++){
				Player guessPlayer = players.get(guessIdx);
				ArrayList<Card> guessPlayerCards = guessPlayer.getPlayersCards();
				for (Card c: guessPlayerCards){
					if (c.equals(character)|| c.equals(weapon) || c.equals(room)){
						return guessPlayer;
					}
				}
				if (guessIdx == players.size() - 1)
				guessIdx = 0;
				else guessIdx += 1;
			}
			return null;
		}
		
	}
	/**
	 * Method used in printing the board to determine where players are on the board. Used in testing.
	 */
	public String toString(){
		return "P";
	}
	
	/**
	 * Adds the card passed to the player's hand. Used when dealing cards.
	 * @param card The card to be added to the player's hand.
	 */
	public void addCard(Card card) {

		playersCards.add(card);
	}
	/**
	 * @return Returns the player's name.
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return Returns the player's x position on the board.
	 */
	public int getX(){
		return xPos; 
	}
	/**
	 * @return Returns the player's y position on the board.
	 */
	public int getY(){
		return yPos; 
	}
	/**
	 * Sets the player's x position on the board.
	 * @param newX The player's new x position.
	 */
	public void setX(int newX){
		xPos = newX;
	}
	/**
	 * Sets the player's y position on the board.
	 * @param newY The player's new y position.
	 */
	public void setY(int newY){
		yPos = newY;
	}

}
