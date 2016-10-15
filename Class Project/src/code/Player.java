package code;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Player extends BoardObject {
	
	private String name;
	private int xPos;
	private int yPos;
	private Board board;
	private Room study;
	private Room hall;
	private Room lounge;
	private Room library;
	private Room diningRoom;
	private Room billiardRoom;
	private Room conservatory;
	private Room ballroom;
	private Room kitchen;
	Scanner scan = new Scanner(System.in);
	
	private Random rand = new Random(System.currentTimeMillis()); //used to generate random number 1-6 
	
	public ArrayList<Card>playersCards=new ArrayList<Card>();

	
	public Player(String name, Board board, int xPos, int yPos, Room study, Room hall, Room lounge, Room library, Room diningRoom, Room billiardRoom, Room conservatory, Room ballroom, Room kitchen){
		this.name = name; 
		this.board = board; 
		this.xPos = xPos; 
		this.yPos = yPos;
		this.study = study;
		this.ballroom = ballroom;
		this.billiardRoom = billiardRoom;
		this.conservatory = conservatory;
		this.diningRoom = diningRoom;
		this.hall = hall;
		this.kitchen = kitchen;
		this.library = library;
		this.lounge = lounge;
	}

	public boolean move(int x, int y){
		if (study.getMembers().contains(this)){
			if (x != 4 && y != 6){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				study.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (hall.getMembers().contains(this)){
			if ((x != 4 && y != 8) || (x != 7 && y != 11) || (x != 7 && y != 12) ){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				hall.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (lounge.getMembers().contains(this)){
			if ((x != 6 && y != 17)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				lounge.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (library.getMembers().contains(this)){
			if ((x != 8 && y != 7) || (x != 11 && y != 3)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				library.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (billiardRoom.getMembers().contains(this)){
			if ((x != 11 && y != 1) || (x != 15 && y != 6)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				billiardRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (diningRoom.getMembers().contains(this)){
			if ((x != 8 && y != 17) || (x != 12 && y != 15)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				diningRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (conservatory.getMembers().contains(this)){
			if (x != 19 && y != 5){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				conservatory.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (ballroom.getMembers().contains(this)){
			if ((x != 19 && y != 7) || (x != 19 && y != 16) || (x != 16 && y != 9) || (x != 16 && y != 14)){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				ballroom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if (kitchen.getMembers().contains(this)){
			if (x != 17 && y != 19){
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					return false;
				}
				else {
				kitchen.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setX(y);
				return true;
				}
			}
		}
		if(x - this.getX() + y - this.getY() > 1){
			return false;
		}
		else{
			BoardObject boardObject = board.occupied(x, y); 
			
			if(boardObject instanceof Wall){
				return false; 
			}
			else if(boardObject instanceof Doorway){
				Doorway doorWay = (Doorway) boardObject; 
				doorWay.addToRoom(this);
				board.populate(new Hallway(), this.getX(), this.getY());
				this.setX(0);
				this.setY(0);
				return true;
			}
			else if(boardObject instanceof Hallway){
				board.populate(new Hallway(), this.getX(), this.getY());
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
			}
			else if(boardObject instanceof Player){
				return false;
			}
		}
		return false;
	}

	public int roll(){
		int roll1 = rand.nextInt(6) + 1;
		int roll2 = rand.nextInt(6) + 1;
		return roll1 + roll2; 
		
		
	}

	public ArrayList<Card> getPlayersCards(){
		return playersCards;
	}

//	public String toString(){
//		return getPlayersCards().toString();
//	}
	
	
	public String toString(){
		return "P";
	}
	
	
	public void addCard(Card card) {

		playersCards.add(card);
	}
	
	public int getX(){
		return xPos; 
	}
	
	public int getY(){
		return yPos; 
	}
	
	public void setX(int newX){
		xPos = newX;
	}
	
	public void setY(int newY){
		xPos = newY;
	}

}
