package code;

import java.util.ArrayList;

public class Game {

	Board board; 
	
	Room study, hall, lounge, library, billiardRoom,
				diningRoom, conservatory, ballroom, kitchen; 
	
	Doorway studyDoor, hallDoor, loungeDoor, libraryDoor, billiardDoor, 
	            diningDoor, conservatoryDoor, ballroomDoor, kitchenDoor; 
	
	Card missScarletCard, professorPlumCard, mrsPeacockCard, mrGreenCard, colonelMustardCard, mrsWhiteCard,
	candlestickCard, knifeCard, leadPipeCard, revolverCard, ropeCard, wrenchCard, kitchenCard, ballRoomCard,
	conservatoryCard, diningRoomCard, billiardRoomCard, libraryCard, loungeCard, hallCard, studyCard;
	
	ArrayList<Card> choices = new ArrayList<Card>();
	Wall wall;
	
	Hallway hallWay;
 
	Player p1, p2, p3, p4, p5, p6;
	
	Deck cardDeck = new Deck();
	ArrayList<Player> players = new ArrayList<Player>(); 
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static void main(String[] args) {
		new Game().startGame(); 
	}
	
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
		cardDeck.makeEnvelope();
		cardDeck.shuffleDeck();
		//cardDeck.dealDeck(players);
		
		System.out.print("this is are board so far...\n\n");
		printBoard();         //just so we can see that 2d array
	}
	
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
	public void populateStairCase(){
		for(int i = 8; i < 15; i++){
			for(int j = 9; j < 14; j++){
				board.populate(wall, i, j);
			}
		}
	}
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
	public void populateKitchen(){
		for(int i = 18; i < 25; i++){
			for(int j = 18; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(kitchenDoor, 18, 19);
	}
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
	public void populateConservatory(){
		for(int i = 19; i < 25; i++){
			for(int j = 0; j < 6; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(conservatoryDoor, 19, 4);
		board.populate(null, 19, 5);
	}
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
	public void populateBilliardRoom(){
		for(int i = 12; i < 17; i++){
			for(int j = 0; j < 6; j++){
				board.populate(wall, i, j);
			}
		}	
		board.populate(billiardDoor, 12, 1);
		board.populate(billiardDoor, 15, 5);
	}
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
	public void populateLounge(){
		for(int i = 0; i < 6; i++){
			for(int j = 17; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(loungeDoor, 5, 17);
	}
	public void populateStudy(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 7; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(studyDoor, 3, 6);
	}
	
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
	
	public void makeRooms(){
		study = new Room("Study");
		hall = new Room("Hall");
		lounge = new Room("Lounge");
		library = new Room("Library");
		billiardRoom = new Room("Billiard Room");
		diningRoom = new Room("Dining Room");
		conservatory = new Room("Conservatory");
		ballroom = new Room("Ballroom");
		kitchen = new Room("Kitchen");
	}

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
	
	public void makePlayers(){
		
		p1 = new Player("Colonel Mustard", board, 7, 23, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this); 
		p2 = new Player("Mrs. White", board, 24, 14, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this); 
		p3 = new Player("Professor Plum", board, 5, 0, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this);
		p4 = new Player("Mrs. Peacock", board, 18, 0, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this); 
		p5 = new Player("Mr. Green", board, 24, 9, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this); 
		p6 = new Player("Miss Scarlet", board, 0, 16, study, hall, lounge, library, diningRoom, billiardRoom, conservatory, ballroom, kitchen, hallWay, this);
		
	}
	
	public void putPlayersOnBoard(){
		board.populate(p1, 7, 23);
		board.populate(p2, 24, 14);
		board.populate(p3, 5, 0);
		board.populate(p4, 18, 0);
		board.populate(p5, 24, 9);
		board.populate(p6, 0, 16);
	}
	
	public void populateListOfPlayers(){
		players.add(p1); 
		players.add(p2); 
		players.add(p3); 
		players.add(p4); 
		players.add(p5); 
		players.add(p6); 
	}
	public ArrayList<Player> getPlayers(){
		return players;  
	}
	
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
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public ArrayList<Card> getFullDeck(){
		return cardDeck.getFullDeck();
	}
	public void populateChoices(){
		for (Card c : cardDeck.getFullDeck()){
			choices.add(c);
		}
	}
	public ArrayList<Card> getChoices(){
		return choices;
	}
}
