package code;

import java.util.Random;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class that implements the players of the game, including methods for movement and making suggestions. 
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
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
	private int[] currentPos;
	private ArrayList<int[]> moveChoices = new ArrayList<int[]>();
	private ArrayList<ArrayList<int[]>> movePaths = new ArrayList<ArrayList<int[]>>();
	private ArrayList<int[]> priorMoves = new ArrayList<int[]>();
	private Color color;
	private Card playChoice;
	private Card weapChoice;
	private Card roomChoice;
	private Card card;
	private ImageIcon icon;
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
	public Player(String name, Board board, int xPos, int yPos, Room study, Room hall, Room lounge, Room library, Room diningRoom, Room billiardRoom, Room conservatory, Room ballroom, Room kitchen, Hallway hallWay, Game game, Color color, Card card, ImageIcon icon){
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
		this.color = color;
		this.card = card;
		this.icon = icon;
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
	public void move(int x, int y){
		for (int[] choice : moveChoices){
			if (choice[0] == x && choice[1] == y){
				if (board.occupied(x, y) instanceof Doorway){
					Doorway door = (Doorway) board.occupied(x, y);
					door.addToRoom(this);
					board.populate(hallWay, this.getX(), this.getY());
					this.setX(0);
					this.setY(0);
				}
				else{
				for (Room r : game.getRooms()){
					if (r.getMembers().contains(this)){
						r.remove(this);
					}
				}
				board.populate(hallWay, this.getX(), this.getY());
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				}
			}
		}
	}
	public ArrayList<int[]> moveOptions(int x, int y){
		ArrayList<int[]> retVal = new ArrayList<int[]>();
		int[] moveUp = new int[] {x - 1, y};
		int[] moveDown = new int[] {x + 1, y};
		int[] moveLeft = new int[] {x, y - 1};
		int[] moveRight = new int[] {x, y + 1};
		retVal.add(moveUp);
		retVal.add(moveDown);
		retVal.add(moveLeft);
		retVal.add(moveRight);
		return retVal;
	}
	
	public boolean canMove(int x, int y, int initX, int initY){
		BoardObject boardObject = board.occupied(x, y);
		if (boardObject instanceof Wall || boardObject instanceof Player){
			return false;
		}
		if ((x == 5 && y == 17) && (initX == 5 && initY == 16)){
			return false;
		}
		if ((x == 3 && y == 6) && (initX == 3 && initY == 7)){
			return false;
		}
		if ((x == 19 && y == 4) && (initX == 18 && initY == 4)){
			return false;
		}
		if ((x == 5 && y == 16) && (initX == 5 && initY == 17)){
			return false;
		}
		if ((x == 3 && y == 7) && (initX == 3 && initY == 6)){
			return false;
		}
		if ((x == 18 && y == 4) && (initX == 19 && initY == 4)){
			return false;
		}
		return true;
	}
	
	public void calculateMoves(ArrayList<int[]> priorMoves, ArrayList<int[]> moveOpt, int diceRoll, int initX, int initY){
		
		if (diceRoll == 0){
			return;
		}
		for (int[] opt : moveOpt){
			if (opt[0] == 25 || opt[0] == -1 || opt[1] == 24 || opt[1] == -1){
				continue;
			}
			ArrayList<int[]> moves = new ArrayList<int[]>();
			for (int[] arr : priorMoves){
				moves.add(arr);
			}
			int xTrack = opt[0];
			int yTrack = opt[1];
			int diceTrack = diceRoll;
			if (canMove(xTrack, yTrack, initX, initY) && !listContains(moves, opt)){
				diceTrack -= 1;
				moves.add(opt);
				if (!listContains(moveChoices, opt)){
					moveChoices.add(opt);
				}
				calculateMoves(moves, moveOptions(xTrack, yTrack), diceTrack, xTrack, yTrack);
				//calculateMoves(moves, moveOptions(xTrack, yTrack), diceTrack);
			}
		}
		int[] startPos = new int[]{this.getX(), this.getY()};
		moveChoices.remove(startPos);
	}
	
	public boolean listContains(ArrayList<int[]> list, int[] arr){
		for (int[] i : list){
			if (Arrays.equals(i, arr)){
				return true;
			}
		}
		return false;
	}
	
	public void listRemove(ArrayList<int[]> list, int[] arr){
		int[] removal = new int[2];
		for (int[] i : list){
			if (Arrays.equals(i, arr)){
				removal = i;
			}
		}
		list.remove(removal);
	}
	

	public int roll(){
		int roll1 = rand.nextInt(6) + 1;
		return roll1;		
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
	public Player suggest(){
		ArrayList<Player> players = game.getPlayers();
		int idx = players.indexOf(this);
		int guessIdx;
		Player playerSuggested = null;
		for (Player p : game.getPlayers()){
			if (p.getCard().equals(playChoice)){
				playerSuggested = p;
				break;
			}
		}
		if (idx == players.size() - 1){
			guessIdx = 0;
			for (int i = 0; i < players.size(); i++){
				Player guessPlayer = players.get(guessIdx);
				ArrayList<Card> guessPlayerCards = guessPlayer.getPlayersCards();
				for (Card c: guessPlayerCards){
					if (c.toString() == this.playChoice.toString()|| c.toString() == this.weapChoice.toString() || c.toString() == this.roomChoice.toString()){
						for (Room r : game.getRooms()){
							if (r.equals(this.getRoomIn())){
								if (playerSuggested.getRoomIn() != null){
									playerSuggested.getRoomIn().remove(guessPlayer);
								}
								r.add(playerSuggested);
								if (playerSuggested.getX() != 0 && playerSuggested.getY() != 0){
									board.populate(hallWay, playerSuggested.getX(), playerSuggested.getY());
									playerSuggested.setX(0);
									playerSuggested.setY(0);
								}
								break;
							}
							
						}
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
					if (c.toString() == this.playChoice.toString()|| c.toString() == this.weapChoice.toString() || c.toString() == this.roomChoice.toString()){
						for (Room r : game.getRooms()){
							if (r.equals(this.getRoomIn())){
								if (playerSuggested.getRoomIn() != null){
									playerSuggested.getRoomIn().remove(guessPlayer);
								}
								r.add(playerSuggested);
								if (playerSuggested.getX() != 0 && playerSuggested.getY() != 0){
									board.populate(hallWay, playerSuggested.getX(), playerSuggested.getY());
									playerSuggested.setX(0);
									playerSuggested.setY(0);
								}
								break;
							}
						}
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

	public ArrayList<int[]> getMoveChoices(){
		return moveChoices;
	}
	public void printMoveChoices(){
		for (int[] choice : moveChoices){
			System.out.println(choice[0] + ", " + choice[1]);
		}
	}
	public ArrayList<int[]> getCurrentPos(){
		int[] pos = new int[] {this.getX(), this.getY()};
		priorMoves.add(pos);
		return priorMoves;
	}
	public void printMovePaths(){
		for (ArrayList<int[]> path: movePaths){
			System.out.print("{");
			for (int[] move : path){
				System.out.print("(" + move[0] + ", " + move[1] + ")");
			}
			System.out.println("}");
		}
	}
	public void printPriorMoves(){
		for (int[] choice : priorMoves){
			System.out.println(choice[0] + ", " + choice[1]);
		}
	}
	public Color getColor(){
		return color;
	}
	public ArrayList<int[]> getPriorMoves(){
		return priorMoves;
	}
	public int[] getPosition(){
		int[] position = new int[] {this.getX(), this.getY()};
		return position;
	}
	
	public boolean inRoom(){
		if(hall.getMembers().contains(this) || study.getMembers().contains(this) || conservatory.getMembers().contains(this) || billiardRoom.getMembers().contains(this) || kitchen.getMembers().contains(this) ||
				diningRoom.getMembers().contains(this) || library.getMembers().contains(this) || lounge.getMembers().contains(this) || ballroom.getMembers().contains(this)){
			return true; 
		}
		else{
			return false; 
		}
	}
	public void setPlay(Card c){
		playChoice = c;
	}
	public void setWeap(Card c){
		weapChoice = c;
	}
	public void setRoom(Card c){
		roomChoice = c;
	}
	public Card getPlay(){
		return playChoice; 
	}
	public Card getWeapon(){
		return weapChoice; 
	}
	public Card getRoom(){
		return roomChoice; 
	}
	public void clearChoices(){
		moveChoices.clear();
		priorMoves.clear();
	}
	public void setMoveChoices(ArrayList<int[]> moves){
		moveChoices = moves;
	}
	
	public Card getCard(){
		return card;
	}
	public ImageIcon getIcon(){
		return icon;
	}
	public Room getRoomIn(){
		if (library.getMembers().contains(this)){
			return library;
		}
		if (study.getMembers().contains(this)){
			return study;
		}
		if (hall.getMembers().contains(this)){
			return hall;
		}
		if (kitchen.getMembers().contains(this)){
			return kitchen;
		}
		if (diningRoom.getMembers().contains(this)){
			return diningRoom;
		}
		if (ballroom.getMembers().contains(this)){
			return ballroom;
		}
		if (conservatory.getMembers().contains(this)){
			return conservatory;
		}
		if (billiardRoom.getMembers().contains(this)){
			return billiardRoom;
		}
		if (lounge.getMembers().contains(this)){
			return lounge;
		}
		else return null;
	}
}
