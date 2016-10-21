package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import code.*; 

public class testMove {
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
	 * An ArrayList of the rooms in the game.
	 */
	Hallway hallway;
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
		
		hallway = game.getHallway();
		
	}
	
	@Test
	/**
	 * Simulates creating 6 different horizontal one-tile movements for a dice roll of 6. Asserts that the
	 * movement is legal (true) and that the Player object was moved from its previous position 
	 * to its new position. Additionally, asserts that the player's previous position is now a hallway.
	 */
	public void testHorizontal(){
		System.out.println("TEST 1");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 21));
		moves.add(p1.move(7, 20));
		moves.add(p1.move(7, 19));
		moves.add(p1.move(7, 18));
		moves.add(p1.move(7, 17));
		assertTrue(p1.completeMove(6, moves, 7, 23, 7, 17));
		assertEquals(7, p1.getX());
		assertEquals(17, p1.getY());
		assertEquals(board.occupied(7, 17), p1);
		assertEquals(board.occupied(7, 23), hallway);
	}
	@Test
	/**
	 * Simulates creating 6 different vertical one-tile movements for a dice roll of 6. Asserts that the
	 * movement is legal (true) and that the Player object was moved from its previous position 
	 * to its new position. Additionally, asserts that the player's previous position is now a hallway.
	 */
	public void testVertical(){
		System.out.println("TEST 2");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p6.move(1, 16));
		moves.add(p6.move(2, 16));
		moves.add(p6.move(3, 16));
		moves.add(p6.move(4, 16));
		moves.add(p6.move(5, 16));
		moves.add(p6.move(6, 16));
		assertTrue(p6.completeMove(6, moves, 0, 16, 6, 16));
		assertEquals(6, p6.getX());
		assertEquals(16, p6.getY());
		assertEquals(board.occupied(6, 16), p6);
		assertEquals(board.occupied(0, 16), hallway);
	}
	
	@Test
	/**
	 * Simulates creating 10 different vertical and horiztonal one-tile movements for a dice roll of 6. 
	 * Asserts that the movement is legal (true) and that the Player object was moved from its previous 
	 * position to its new position. Additionally, asserts that the player's previous position is now a hallway.
	 */
	public void testHorizontalVertical(){
		System.out.println("TEST 3");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 21));
		moves.add(p1.move(7, 20));
		moves.add(p1.move(7, 19));
		moves.add(p1.move(7, 18));
		moves.add(p1.move(7, 17));
		moves.add(p1.move(6, 17));
		moves.add(p1.move(6, 16));
		moves.add(p1.move(7, 16));
		moves.add(p1.move(8, 16));
		assertTrue(p1.completeMove(10, moves, 7, 23, 8, 16));
		assertEquals(8, p1.getX());
		assertEquals(16, p1.getY());
		assertEquals(board.occupied(8, 16), p1);
		assertEquals(board.occupied(7, 23), hallway);
	}
	
	@Test
	/**
	 * Simulates a Player moving into a room on movement 8 of its dice roll of 12. 
	 * Asserts that the movement is legal (true) and that the Player object was moved from its previous 
	 * position into a room (the lounge). Additionally, asserts that the player's previous position is now 
	 * a hallway.
	 */
	public void testMoveIntoRoom(){
		System.out.println("TEST 4");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 21));
		moves.add(p1.move(7, 20));
		moves.add(p1.move(7, 19));
		moves.add(p1.move(7, 18));
		moves.add(p1.move(7, 17));
		moves.add(p1.move(6, 17));
		moves.add(p1.move(5, 17));
		assertTrue(p1.completeMove(12, moves, 7, 23, 0, 0));
		assertTrue(lounge.getMembers().contains(p1));
		assertEquals(0, p1.getX());
		assertEquals(0, p1.getY());
		assertEquals(board.occupied(7, 23), hallway);
	}
	
	@Test
	/**
	 * Moves a player into a room, similar to test 4 above, and then uses the passageway to move from
	 * the lounge to the conservatory. Asserts that the lounge no longer contains the player and
	 * that the player is now a member of the conservatory ArrayList.
	 */
	public void testPassageway(){
		System.out.println("TEST 5");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 21));
		moves.add(p1.move(7, 20));
		moves.add(p1.move(7, 19));
		moves.add(p1.move(7, 18));
		moves.add(p1.move(7, 17));
		moves.add(p1.move(6, 17));
		moves.add(p1.move(5, 17));
		assertTrue(p1.completeMove(8
				, moves, 7, 23, 0, 0));
		assertTrue(lounge.getMembers().contains(p1));
		assertTrue(p1.usePassageway());
		assertFalse(lounge.getMembers().contains(p1));
		assertTrue(conservatory.getMembers().contains(p1));
		assertEquals(0, p1.getX());
		assertEquals(0, p1.getY());
	}
	
	@Test
	/**
	 * Asserts that a movement is illegal (false) when the player tries to make more movements 
	 * than are rolled on the dice (the player here attempts to move 6 times on a dice roll of 4).
	 * Also asserts that the player remained in its original position.
	 */
	public void testMoreThanDice(){
		System.out.println("TEST 6");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p6.move(1, 16));
		moves.add(p6.move(2, 16));
		moves.add(p6.move(3, 16));
		moves.add(p6.move(4, 16));
		moves.add(p6.move(5, 16));
		moves.add(p6.move(6, 16));
		assertFalse(p6.completeMove(4, moves, 0, 16, 6, 16));
		assertEquals(p6.getX(), 0);
		assertEquals(p6.getY(), 16);
		assertEquals(board.occupied(0, 16), p6);
	}
	
	@Test
	/**
	 * Asserts that a movement is illegal (false) when the player tries to make a diagonal movement
	 * at any point in its movement. In this case, the player attempts to move from position (7, 23)
	 * to (6, 22). Also asserts that the player remained in its original position.
	 */
	public void testDiagonal(){
		System.out.println("TEST 7");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(6, 22));
		assertFalse(p1.completeMove(1, moves, 7, 23, 6, 22));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
		assertEquals(board.occupied(7, 23), p1);
	}
	
	@Test
	/**
	 * Asserts that a movement is illegal (false) when the player attempts to move non-contiguously. 
	 * In this case, the second movement attempts to move from position (7,22) to (7,20) (and skip over
	 * (7, 21)). Also asserts that the player remains in its original position.
	 */
	public void testNonContiguous(){
		System.out.println("TEST 8");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 20));
		assertFalse(p1.completeMove(2, moves, 7, 23, 7, 20));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
		assertEquals(board.occupied(7, 23), p1);
	}
	
	@Test
	/**
	 * Asserts that a movement is illegal (false) when the player attempts to complete the movement by
	 * moving through a wall. In this case, the second movement attempts to move into position (9, 22),
	 * which is populated by a wall. Also asserts that the player remains in its original position.
	 */
	public void testMoveThroughWall(){
		System.out.println("TEST 9");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(8, 22));
		moves.add(p1.move(9, 22));
		assertFalse(p1.completeMove(3, moves, 7, 23, 9, 22));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
		assertEquals(board.occupied(7, 23), p1);
	}
	
	/**
	 * Prints out the board in order to visualize the movement of players in each test.
	 */
	@After
	public void runAfterTest(){
		System.out.println("END RESULT: \n");
		game.printBoard();
	}
}
