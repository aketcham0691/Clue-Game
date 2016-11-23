package code;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Class that starts the game. Instantiates the board and all components of the board (i.e. Players,
 * doorways, walls, hallways) and initializes each element of the board as well.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Game {
	/** Stores the board to which this game object is tied to. */
	Board board; 
	/** Stores the rooms to which this game object is tied to. */
	Room study, hall, lounge, library, billiardRoom,
				diningRoom, conservatory, ballroom, kitchen; 
	
	/** Stores the doorways to which this game object is tied to. */
	Doorway studyDoor, hallDoor, loungeDoor, libraryDoor, billiardDoor, 
	            diningDoor, conservatoryDoor, ballroomDoor, kitchenDoor; 
	
	/** ArrayList used to store all the weapon, character, and room cards. */
	ArrayList<Card> choices = new ArrayList<Card>();
	/** Stores the single wall object that this game object is tied to. */
	Wall wall;
	/** Stores the single hallway object that this game object is tied to. */
	Hallway hallWay;
	/** Stores the players that this game object is tied to. */
	Player p1, p2, p3, p4, p5, p6;
	/** Stores the deck that this game object is tied to. */
	Deck cardDeck = new Deck();
	Deck dealDeck = new Deck();
	/** ArrayList used to store all players in the game. Used for testing */
	ArrayList<Player> players = new ArrayList<Player>(); 
	/** ArrayList used to store all rooms in the game. Used for testing */
	ArrayList<Room> rooms = new ArrayList<Room>();
	GUI gui;
	
	/**
	 * The main method. The first method in the application that is invoked. Instantiates 
	 * a new game object and then invokes that game objects startGame() method.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		new Game().startGame();	
		
	}
	/**
	 * This method instantiates a board object, a wall object, and a hallway object. This 
	 * method then calls to the other methods of the class that are responsible for creating 
	 * all the necessary board objects and then using those board objects to initialize all 
	 * elements of the board object array. Finally this method invokes printBoard() which is 
	 * used to print an image of the board for testing.
	 */
	public void startGame(){ 
		
		board = new Board(25,24); 
		wall = new Wall(); 
		hallWay = new Hallway();  
		
		makeRooms();
		populateListOfRooms();
		makeDoors();
		makePlayers();
		populateListOfPlayers();
		putPlayersOnBoard(); 
		populateStudy();
		populateHall();
		populateLounge(); 
		populateLibrary();
		populateBilliardRoom();
		populateDiningRoom(); 
		populateConservatory();
		populateBallRoom();
		populateKitchen(); 
		populateStairCase();
		populateWalls(); 
		populateHallWays(); 
		populateChoices();
		dealCards();
		printBoard();
		makeGUI(this); 
		for (Player p : this.getPlayers()){
			System.out.println(p.getName() + ": " + p.getPlayersCards());
		}
		System.out.println("Envelope:" + dealDeck.getEnvelope());

	}
	public void makeGUI(Game game){
		gui = new GUI(game);
	}
	/**
	 * This method checks each element of the BoardObject array. If the element is 
	 * not initialized to a player, a doorway, or a wall, then it is initialized to 
	 * a hallway.
	 */
	public void populateHallWays(){
		BoardObject[][] b = board.getBoard(); 
		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 24; j++){
				if((b[i][j] != wall) && (b[i][j] != p1) && (b[i][j] != p2) && (b[i][j] != p3) && (b[i][j] != p4) && (b[i][j] != p5) && (b[i][j] != p6)
						&& (b[i][j] != studyDoor) && (b[i][j] != hallDoor) && (b[i][j] != diningDoor) && (b[i][j] != loungeDoor) && (b[i][j] != libraryDoor) 
						&& (b[i][j] != conservatoryDoor) && (b[i][j] != billiardDoor) && (b[i][j] != kitchenDoor) && (b[i][j] != ballroomDoor)){
					b[i][j] = hallWay; 
				}
			}
		}
	}
	/** 
	 * This method initializes all the elements of the BoardObject array that represent the staircase of the clue 
	 * board to walls.
	 */
	public void populateStairCase(){
		for(int i = 8; i < 15; i++){
			for(int j = 9; j < 14; j++){
				board.populate(wall, i, j);
			}
		}
	}
	/**
	 * This method initializes particular elements of the BoardObject array to walls.
	 */
	public void populateWalls(){
		board.populate(wall, 0, 8);
		board.populate(wall, 0, 15);
		board.populate(wall, 4, 0);
		board.populate(wall, 11, 0);
		board.populate(wall, 17, 0);
		board.populate(wall, 6, 23);
		board.populate(wall, 8, 23);
		board.populate(wall, 16, 23);
		board.populate(wall, 23, 6);
		board.populate(wall, 24, 6);
		board.populate(wall, 24, 7);
		board.populate(wall, 24, 8);
		board.populate(wall, 24, 15);
		board.populate(wall, 24, 16);
		board.populate(wall, 24, 17);
		board.populate(wall, 23, 17);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * kitchen of the clue board to either walls or a kitchen doorway. 
	 */
	public void populateKitchen(){
		for(int i = 18; i < 25; i++){
			for(int j = 18; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(kitchenDoor, 18, 19);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * ballroom of the clue board to either walls or ballroom doorways. 
	 */
	public void populateBallRoom(){
		for(int i = 17; i < 23; i++){
			for(int j = 8; j < 16; j++){
				board.populate(wall, i, j);
			}
		}
		for(int i = 23; i < 25; i++){
			for(int j = 10; j < 14; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(ballroomDoor, 19, 8);
		board.populate(ballroomDoor, 17, 9);
		board.populate(ballroomDoor, 17, 14);
		board.populate(ballroomDoor, 19, 15);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * conservatory of the clue board to either walls, a conservatory doorway, or null. 
	 */
	public void populateConservatory(){
		for(int i = 19; i < 25; i++){
			for(int j = 0; j < 6; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(conservatoryDoor, 19, 4);
		board.populate(null, 19, 5);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * dining room of the clue board to either walls, dining room doorways, or null. 
	 */
	public void populateDiningRoom(){
		for(int i = 9; i < 16; i++){
			for(int j = 16; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(diningDoor, 9, 17);
		board.populate(diningDoor, 12, 16);
		board.populate(null, 15, 16);
		board.populate(null, 15, 17);
		board.populate(null, 15, 18);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * billiard room of the clue board to either walls or billiard room doorways. 
	 */
	public void populateBilliardRoom(){
		for(int i = 12; i < 17; i++){
			for(int j = 0; j < 6; j++){
				board.populate(wall, i, j);
			}
		}	
		board.populate(billiardDoor, 12, 1);
		board.populate(billiardDoor, 15, 5);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * library of the clue board to either walls, library doorways, or null. 
	 */
	public void populateLibrary(){
		for(int i = 6; i < 11; i++){
			for(int j = 0; j < 7; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(libraryDoor, 8, 6);
		board.populate(libraryDoor, 10, 3);
		board.populate(null, 6, 6);
		board.populate(null, 10, 6);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * lounge of the clue board to either walls or a lounge doorway. 
	 */
	public void populateLounge(){
		for(int i = 0; i < 6; i++){
			for(int j = 17; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(loungeDoor, 5, 17);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * study of the clue board to either walls or a study doorway. 
	 */
	public void populateStudy(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 7; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(studyDoor, 3, 6);
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * hall of the clue board to either walls or hall doorways. 
	 */
	public void populateHall(){
		for(int i = 0; i < 7; i++){
			for(int j = 9; j < 15; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(hallDoor, 4, 9);
		board.populate(hallDoor, 6, 11);
		board.populate(hallDoor, 6, 12);
	}
	/**
	 * Method to print the two-dimensional BoardObject array. Printing out an image 
	 * of the board is used for testing.
	 */
	public void printBoard(){
		BoardObject[][] b = board.getBoard(); 
		for(int i = 0; i < 25; i++){
		    for(int j = 0; j < 24; j++){
		        if(b[i][j] == null){
		        	System.out.print("0" + " ");
		        }
		        else{
		        	System.out.print(b[i][j] + " ");
		        }
		    }
		    System.out.println();
		}
	}
	/**
	 * Method to instantiate all of the rooms.
	 */
	public void makeRooms(){
		study = new Room("Study", cardDeck.getCards().get(20));
		hall = new Room("Hall", cardDeck.getCards().get(19));
		lounge = new Room("Lounge", cardDeck.getCards().get(18));
		library = new Room("Library", cardDeck.getCards().get(17));
		billiardRoom = new Room("Billiard Room", cardDeck.getCards().get(16));
		diningRoom = new Room("Dining Room", cardDeck.getCards().get(15));
		conservatory = new Room("Conservatory", cardDeck.getCards().get(14));
		ballroom = new Room("Ballroom", cardDeck.getCards().get(13));
		kitchen = new Room("Kitchen", cardDeck.getCards().get(12));
	}
	/**
	 * Method to instantiate all of the doorways.
	 */
	public void makeDoors(){
		 studyDoor = new Doorway("Study Door", study);
		 hallDoor = new Doorway("Hall Door", hall);
		 loungeDoor = new Doorway("Lounge Door", lounge);
		 libraryDoor = new Doorway("Library Door", library);
		 billiardDoor = new Doorway("Billiard Room Door", billiardRoom);
		 diningDoor = new Doorway("Dining Room Door", diningRoom);
		 conservatoryDoor = new Doorway("Conservartory Room Door", conservatory);
		 ballroomDoor = new Doorway("Ballroom Door", ballroom);
		 kitchenDoor = new Doorway("Kitchen Door", kitchen);
	}
	/**
	 * Method to instantiate all of the players.
	 */
	public void makePlayers(){
		p1 = new Player("Colonel Mustard", board, 7, 23, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.YELLOW, cardDeck.getCards().get(4), new ImageIcon(new ImageIcon(getClass().getResource("colpiece.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
		p2 = new Player("Mrs. White", board, 24, 14, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.WHITE, cardDeck.getCards().get(5), new ImageIcon(new ImageIcon(getClass().getResource("whiteicon.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
		p3 = new Player("Professor Plum", board, 5, 0, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.MAGENTA, cardDeck.getCards().get(1), new ImageIcon(new ImageIcon(getClass().getResource("plumicon.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		p4 = new Player("Mrs. Peacock", board, 18, 0, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.BLUE, cardDeck.getCards().get(2), new ImageIcon(new ImageIcon(getClass().getResource("peaicon.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
		p5 = new Player("Mr. Green", board, 24, 9, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.GREEN, cardDeck.getCards().get(3), new ImageIcon(new ImageIcon(getClass().getResource("greenicon.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
		p6 = new Player("Miss Scarlet", board, 0, 16, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this, Color.RED, cardDeck.getCards().get(0), new ImageIcon(new ImageIcon(getClass().getResource("scaricon.jpg")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
	}
	/**
	 * This method initializes all the elements of the BoardObject array that represent the
	 * starting position of each player to player objects. 
	 */
	public void putPlayersOnBoard(){
		board.populate(p1, 7, 23);
		board.populate(p2, 24, 14);
		board.populate(p3, 5, 0);
		board.populate(p4, 18, 0);
		board.populate(p5, 24, 9);
		board.populate(p6, 0, 16);
	}
	/**
	 * This method adds all players to an ArrayList<Player>. Used for testing 
	 */
	public void populateListOfPlayers(){
		players.add(p6); 
		players.add(p1); 
		players.add(p2); 
		players.add(p5); 
		players.add(p4); 
		players.add(p3); 
	}
	/**
	 * @return Returns an ArrayList of all the players. 
	 */
	public ArrayList<Player> getPlayers(){
		return players;  
	}
	/**
	 * This method adds all rooms to an ArrayList<Room>. 
	 */
	public void populateListOfRooms(){
		rooms.add(study);
		rooms.add(kitchen);
		rooms.add(lounge);
		rooms.add(ballroom);
		rooms.add(library);
		rooms.add(conservatory);
		rooms.add(diningRoom);
		rooms.add(billiardRoom);
		rooms.add(hall);
	}
	/**
	 * @return Returns an ArrayList of all rooms. 
	 */
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	/**
	 * @return Returns the board object tied to this game object.
	 */
	public Board getBoard(){
		return board;
	}
	/**
	 * @return Returns the hallway object tied to this game object.
	 */
	public Hallway getHallway(){
		return hallWay;
	}
	/**
	 * @return Returns a full deck of cards.
	 */
	public ArrayList<Card> getFullDeck(){
		return cardDeck.getFullDeck();
	}
	/**
	 * This method adds all weapon, character, and room cards to this game objects ArrayList<Card>.
	 */
	public void populateChoices(){
		for (Card c : cardDeck.getFullDeck()){
			choices.add(c);
		}
	}
	/**
	 * @return Returns an ArrayList of all weapon character, and room cards.
	 */
	public ArrayList<Card> getChoices(){
		return choices;
	}
	public void dealCards(){
		dealDeck.makeEnvelope();
		dealDeck.shuffleDeck();
		dealDeck.dealDeck(players);
	}
	public void setTurn(Player play){
		gui.setTurn(play, this);
	}
	
}
