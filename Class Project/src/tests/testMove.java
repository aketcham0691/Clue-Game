package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import code.*; 

public class testMove {
	
	ArrayList<Player> players; 
	
	Player p1, p2, p3, p4, p5, p6; 
	Room study, hall, lounge, library, billiardRoom,
	diningRoom, conservatory, ballroom, kitchen;
	
	Board board;
	Game game;
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
		
	}
		
	@Test
	public void testCompleteMove(){
		System.out.println("TEST 0");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 21));
		assertTrue(p1.completeMove(2, moves, 7, 23, 7, 21));
	}
	
	@Test
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
	}
	@Test
	public void testVertical(){
		System.out.println("TEST 2");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p6.move(1, 16));
		moves.add(p6.move(2, 16));
		moves.add(p6.move(3, 16));
		moves.add(p6.move(4, 16));
		moves.add(p6.move(5, 16));
		moves.add(p6.move(6, 16));
		assertTrue(p1.completeMove(6, moves, 0, 16, 6, 16));
	}
	
	@Test
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
	}
	
	@Test
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
		assertTrue(p1.completeMove(12, moves, 7, 23, 5, 17));
		assertTrue(lounge.getMembers().contains(p1));
	}
	
	@Test
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
		assertTrue(p1.completeMove(12, moves, 7, 23, 5, 17));
		assertTrue(lounge.getMembers().contains(p1));
		assertTrue(p1.usePassageway());
		assertFalse(lounge.getMembers().contains(p1));
		assertTrue(conservatory.getMembers().contains(p1));
	}
	
	@Test
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
	}
	
	@Test
	public void testDiagonal(){
		System.out.println("TEST 7");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(6, 22));
		assertFalse(p1.completeMove(1, moves, 7, 23, 6, 22));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
	}
	
	@Test
	public void testNonContiguous(){
		System.out.println("TEST 8");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(7, 20));
		assertFalse(p1.completeMove(2, moves, 7, 23, 7, 20));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
	}
	
	@Test
	public void testMoveThroughWall(){
		System.out.println("TEST 9");
		ArrayList<Boolean> moves = new ArrayList<Boolean>();
		moves.add(p1.move(7, 22));
		moves.add(p1.move(8, 22));
		moves.add(p1.move(9, 22));
		assertFalse(p1.completeMove(3, moves, 7, 23, 9, 22));
		assertEquals(p1.getX(), 7);
		assertEquals(p1.getY(), 23);
	}
		
	@After
	public void runAfterTest(){
		System.out.println("END RESULT: \n");
		game.printBoard();
	}
}
