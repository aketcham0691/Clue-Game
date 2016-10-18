package tests;

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
	Deck deck;
	ArrayList<Room> rooms;
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
		deck = game.getDeck();
		
	}
	
	@Test
	public void testPlayerToTheLeft(){
		deck.dealCard(p1, 0);
		deck.dealCard(p1, 5);
		deck.dealCard(p1, 10);
		deck.dealCard(p2, 0);
		deck.dealCard(p2, 5);
		deck.dealCard(p2, 10);
		deck.dealCard(p3, 0);
		deck.dealCard(p3, 5);
		deck.dealCard(p3, 10);
		deck.dealCard(p4, 0);
		deck.dealCard(p4, 5);
		deck.dealCard(p4, 10);
		deck.dealCard(p5, 0);
		deck.dealCard(p5, 5);
		deck.dealCard(p5, 10);
		deck.dealCard(p6, 0);
		deck.dealCard(p6, 5);
		deck.dealCard(p6, 10);
		p1.suggest(mrsPeacock, knife, room)
	}
	
	
}
