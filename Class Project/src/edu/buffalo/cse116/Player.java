package edu.buffalo.cse116;

import java.util.Random;

public class Player extends BoardObject {
	
	private String name;
	private int turnNumber;
	
	private Board board;
	
	private Random rand = new Random(System.currentTimeMillis()); //used to generate random number 1-6 
	
	public Player(String name){
		this.name = name; 
	}
	
	public Player(String name, int turnNumber, Board board){
		this.name = name; 
		this.turnNumber = turnNumber;
		this.board = board; 
	}
	
	public boolean move(Board board, int x, int y){
		board.populate(this, x, y);
		return true;
	}
	
	public int roll(){
		int roll1 = rand.nextInt(6) + 1;
		int roll2 = rand.nextInt(6) + 1;
		return roll1 + roll2; 
	}
	
	
	public String toString(){
		return "P";
	}
	
	
}
