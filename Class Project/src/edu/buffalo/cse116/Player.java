package edu.buffalo.cse116;

<<<<<<< Upstream, based on origin/master
import java.util.Random;
=======
import java.util.ArrayList;
>>>>>>> 7502fdd j

public class Player extends BoardObject {
	
	private String name;
	private int turnNumber;
<<<<<<< Upstream, based on origin/master
	
	private Board board;
	
	private Random rand = new Random(System.currentTimeMillis()); //used to generate random number 1-6 
	
	public Player(String name){
		this.name = name; 
=======
	Board _b;
	BoardObject[][] board;
	public ArrayList<Card>playersCards=new ArrayList<Card>();
	public Player(){
		
		
>>>>>>> 7502fdd j
	}
	
	public Player(String name, int turnNumber, Board board){
		this.name = name; 
		this.turnNumber = turnNumber;
		this.board = board; 
	}
	
<<<<<<< Upstream, based on origin/master
	public boolean move(Board board, int x, int y){
		board.populate(this, x, y);
		return true;
=======
	public boolean move(int x, int y){
		return false;
		
>>>>>>> 7502fdd j
	}
	
	public int roll(){
<<<<<<< Upstream, based on origin/master
		int roll1 = rand.nextInt(6) + 1;
		int roll2 = rand.nextInt(6) + 1;
		return roll1 + roll2; 
=======
		return turnNumber;
		
>>>>>>> 7502fdd j
	}

	public ArrayList<Card> getPlayersCards(){
		return playersCards;
	}

	public String toString(){
		return getPlayersCards().toString();
	}
	
<<<<<<< Upstream, based on origin/master
	
	public String toString(){
		return "P";
	}
	
	
}
=======
	public void addCard(Card card) {

		playersCards.add(card);
	}
	

}
>>>>>>> 7502fdd j
