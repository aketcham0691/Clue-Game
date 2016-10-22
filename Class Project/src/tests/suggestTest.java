package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import code.*;

public class suggestTest {
	/**
	 * Variable for storing list of players in the game.
	 */
	ArrayList<Player> players; 
	/**
	 * The Player objects in the game.
	 */
	Player p1, p2, p3, p4, p5, p6; 
	/**
	 * The room objects in the game.
	 */
	Room study, hall, lounge, library, billiardRoom,
	diningRoom, conservatory, ballroom, kitchen;
	/**
	 * The game board object.
	 */
	Board board;
	/**
	 * The game to which all other objects are tied.
	 */
	Game game;
	/**
	 * An ArrayList of the cards in the game.
	 */
	ArrayList<Card> choices;
	/**
	 * An ArrayList of the rooms in the game.
	 */
	ArrayList<Room> rooms;
	@Before
	/**
	 * Initializes all of the above variables, including creating a new game, board, and all players.
	 */
	public void runBeforeTests(){
		game = new Game(); 
		game.startGame();
		board = game.getBoard();
		players = game.getPlayers(); 
		p1 = players.get(0); 
		p2 = players.get(1); 
		p3 = players.get(2); 
		p4 = players.get(3); 
		p5 = players.get(4); 
		p6 = players.get(5); 
		
		rooms = game.getRooms();
		study = rooms.get(0); 
		kitchen = rooms.get(1); 
		lounge = rooms.get(2); 
		ballroom = rooms.get(3); 
		library = rooms.get(4); 
		conservatory = rooms.get(5); 
		diningRoom = rooms.get(6); 
		billiardRoom = rooms.get(7); 
		hall = rooms.get(8); 
		choices = game.getChoices();
		
		p1.getPlayersCards().add(choices.get(0));
		p1.getPlayersCards().add(choices.get(6));
		p1.getPlayersCards().add(choices.get(12));
		p2.getPlayersCards().add(choices.get(1));
		p2.getPlayersCards().add(choices.get(7));
		p2.getPlayersCards().add(choices.get(13));
		p3.getPlayersCards().add(choices.get(2));
		p3.getPlayersCards().add(choices.get(8));
		p3.getPlayersCards().add(choices.get(14));
		p4.getPlayersCards().add(choices.get(3));
		p4.getPlayersCards().add(choices.get(9));
		p4.getPlayersCards().add(choices.get(15));
		p5.getPlayersCards().add(choices.get(4));
		p5.getPlayersCards().add(choices.get(10));
		p5.getPlayersCards().add(choices.get(16));
		p6.getPlayersCards().add(choices.get(18));
		p6.getPlayersCards().add(choices.get(19));
		p6.getPlayersCards().add(choices.get(17));
	}
	
	@Test
	/**
	 * Asserts that the next player has the character card.
	 */
	public void testLeftHasPlayercard(){
		System.out.println("TEST 1");
		assertEquals(p1.suggest(choices.get(1), choices.get(10), choices.get(17)), p2);
	}
	
	@Test
	/**
	 * Asserts that the next player has the room card.
	 */
	public void testLeftHasRoomCard(){
		System.out.println("TEST 2");
		assertEquals(p1.suggest(choices.get(0), choices.get(11), choices.get(13)), p2);
	}
	
	@Test
	/**
	 * Asserts that the next player has the weapon card.
	 */
	public void testLeftHasWeaponCard(){
		System.out.println("TEST 3");
		assertEquals(p1.suggest(choices.get(0), choices.get(7), choices.get(17)), p2);
	}
	
	@Test
	/**
	 * Asserts that the next player has two matching cards.
	 */
	public void testLeftHasTwoMatches(){
		System.out.println("TEST 4");
		assertEquals(p1.suggest(choices.get(0), choices.get(7), choices.get(13)), p2);
	}
	
	@Test
	/**
	 * Asserts that the player after the next player has one or more matching cards.
	 */
	public void testPlayerAfterLeft(){
		System.out.println("TEST 5");
		assertEquals(p1.suggest(choices.get(0), choices.get(6), choices.get(14)), p3);
	}
	
	@Test
	/**
	 * Asserts that the player immediately before the player making suggestion has 1 or more matching cards.
	 */
	public void testPlayerBefore(){
		System.out.println("TEST 6");
		assertEquals(p1.suggest(choices.get(0), choices.get(6), choices.get(17)), p6);
	}
	
	@Test
	/**
	 * Asserts that the player making the suggestion has 1 or more matching cards.
	 */
	public void testGuesserHasMatch(){
		System.out.println("TEST 7");
		assertEquals(p1.suggest(choices.get(0), choices.get(11), choices.get(20)), p1);
	}
	
	@Test
	/**
	 * Asserts that the player making the suggestion does not have any matching cards.
	 */
	public void testNoMatch(){
		System.out.println("TEST 8");
		assertNull(p1.suggest(choices.get(5), choices.get(11), choices.get(20)));
	}
	
	
}
