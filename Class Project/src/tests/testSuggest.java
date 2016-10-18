package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import code.*;

public class testSuggest {

	
	ArrayList<Player> players; 
	
	Player p1, p2, p3, p4, p5, p6; 
	Room study, hall, lounge, library, billiardRoom,
	diningRoom, conservatory, ballroom, kitchen;
	
	Board board;
	Game game;
	ArrayList<Card> deck;
	ArrayList<Room> rooms;
	ArrayList<Card> choices;
	@Before
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
		deck = game.getFullDeck();
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
	public void testLeftHasPlayercard(){
		System.out.println("TEST 1");
		System.out.println(choices.toString());
		System.out.println(p1.getPlayersCards().toString());
		assertEquals(p1.suggest(choices.get(1), choices.get(10), choices.get(17)), p2);
	}
	
	@Test
	public void testLeftHasRoomCard(){
		System.out.println("TEST 2");
		assertEquals(p1.suggest(choices.get(0), choices.get(11), choices.get(13)), p2);
	}
	
	@Test
	public void testLeftHasWeaponCard(){
		System.out.println("TEST 3");
		assertEquals(p1.suggest(choices.get(0), choices.get(7), choices.get(17)), p2);
	}
	
	@Test
	public void testLeftHasTwoMatches(){
		System.out.println("TEST 4");
		assertEquals(p1.suggest(choices.get(0), choices.get(7), choices.get(13)), p2);
	}
	
	@Test
	public void testPlayerAfterLeft(){
		System.out.println("TEST 5");
		assertEquals(p1.suggest(choices.get(0), choices.get(6), choices.get(14)), p3);
	}
	
	@Test
	public void testPlayerBefore(){
		System.out.println("TEST 6");
		assertEquals(p1.suggest(choices.get(0), choices.get(6), choices.get(17)), p6);
	}
	
	@Test
	public void testGuesserHasMatch(){
		System.out.println("TEST 7");
		assertEquals(p1.suggest(choices.get(0), choices.get(11), choices.get(20)), p1);
	}
	
	@Test
	public void testNoMatch(){
		System.out.println("TEST 8");
		assertNull(p1.suggest(choices.get(5), choices.get(11), choices.get(20)));
	}
	
	
}
