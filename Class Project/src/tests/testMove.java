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
	public void testWallCollision(){
		System.out.println("TEST 1");
		assertFalse(p1.move(6, 23)); 
	}
	
	@Test
	public void testHallway(){
		System.out.println("TEST 2");
		p1.move(7, 22);
		assertEquals(7, p1.getX());
		assertEquals(22, p1.getY());
	}
	
	@Test
	public void testLeaveRoom(){
		System.out.println("TEST 3");
		study.add(p1);
		assertTrue(p1.move(4, 6));
		assertEquals(p1, board.occupied(4, 6));
		assertFalse(study.getMembers().contains(p1));
		assertEquals(4, p1.getX());
		assertEquals(6, p1.getY());
	}
	
	@Test
	public void testLeaveRoomFalse(){
		System.out.println("TEST 4");
		study.add(p1);
		assertFalse(p1.move(3, 7));
	}
	
	@Test
	public void testPlayerOutsideRoom(){
		System.out.println("TEST 5");
		study.add(p1);
		board.populate(p2, 4, 6);
		assertFalse(p1.move(4, 6));
	}
	
	@Test
	public void testPlayerCollision(){
		System.out.println("TEST 6");
		board.populate(p2, 7, 22);
		assertFalse(p1.move(7, 22));
	}
	
	@Test
	public void testEnterDoorway(){
		System.out.println("TEST 7");
		p3.move(5, 1);
		p3.move(5, 2);
		p3.move(5, 3);
		p3.move(5, 4);
		p3.move(5, 5);
		p3.move(5, 6);
		p3.move(4, 6);
		assertTrue(p3.move(3, 6));
		assertTrue(study.getMembers().contains(p3));
		assertTrue(p3.move(4, 6));
	}
	
	@Test
	public void testTwoMoves(){
		System.out.println("TEST 8");
		p1.move(7, 22);
		p2.move(23, 14);
	}
	
	@Test
	public void testMoveGreaterThanOne(){
		System.out.println("TEST 9");
		assertFalse(p1.move(7, 20));
	}
	@After
	public void runAfterTest(){
		System.out.println("END RESULT: \n");
		game.printBoard();
	}
}
