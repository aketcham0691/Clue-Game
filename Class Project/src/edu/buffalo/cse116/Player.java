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
	
	public boolean move(int x, int y){
		
		
		
		
		return true; 
	}
	
	public int roll(){
		return rand.nextInt(6) + 1; 
	}
	
	
	public String toString(){
		return "P";
	}
	
	
}
