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
	private Hallway hallWay;
	Scanner scan = new Scanner(System.in);
	
	private Random rand = new Random(System.currentTimeMillis()); //used to generate random number 1-6 
	
	public ArrayList<Card>playersCards=new ArrayList<Card>();

	
	public Player(String name, Board board, int xPos, int yPos, Room study, Room hall, Room lounge, Room library, Room diningRoom, Room billiardRoom, Room conservatory, Room ballroom, Room kitchen, Hallway hallWay){
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
		this.hallWay = hallWay;
	}

	public boolean move (int x, int y){
		if (study.getMembers().contains(this)){
			if (x != 4 && y != 6){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				study.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (hall.getMembers().contains(this)){
			if ((x != 4 && y != 8) || (x != 7 && y != 11) || (x != 7 && y != 12) ){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				hall.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (lounge.getMembers().contains(this)){
			if ((x != 6 && y != 17)){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				lounge.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (library.getMembers().contains(this)){
			if ((x != 8 && y != 7) || (x != 11 && y != 3)){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				library.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (billiardRoom.getMembers().contains(this)){
			if ((x != 11 && y != 1) || (x != 15 && y != 6)){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				billiardRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (diningRoom.getMembers().contains(this)){
			if ((x != 8 && y != 17) || (x != 12 && y != 15)){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				diningRoom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (conservatory.getMembers().contains(this)){
			if (x != 19 && y != 5){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				conservatory.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (ballroom.getMembers().contains(this)){
			if ((x != 19 && y != 7) || (x != 19 && y != 16) || (x != 16 && y != 9) || (x != 16 && y != 14)){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				ballroom.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if (kitchen.getMembers().contains(this)){
			if (x != 17 && y != 19){
				System.out.println("You can't move there");
				return false;
			}
			else {
				BoardObject boardObject = board.occupied(x, y);
				if (boardObject instanceof Player){
					System.out.println("You can't move there");
					return false;
				}
				else {
				kitchen.remove(this);
				board.populate(this, x, y);
				this.setX(x);
				this.setY(y);
				return true;
				}
			}
		}
		if(Math.abs((x - this.getX())) + Math.abs((y - this.getY())) > 1){
			System.out.println("You can't move there");
			return false;
		}
		else{
			BoardObject boardObject = board.occupied(x, y); 
			
			if(boardObject instanceof Wall){
				System.out.println("You can't move there");
				return false; 
			}
			else if(boardObject instanceof Doorway){
				Doorway doorWay = (Doorway) boardObject; 
				doorWay.addToRoom(this);
				return true;
			}
			else if(boardObject instanceof Hallway){
				this.setX(x);
				this.setY(y);
				return true;
			}
			else if(boardObject instanceof Player){
				System.out.println("You can't move there");
				return false;
			}
		}
		System.out.println("You can't move there");
		return false;
	}

	public int roll(){
		int roll1 = rand.nextInt(6) + 1;
		int roll2 = rand.nextInt(6) + 1;
		return roll1 + roll2; 		
	}
	
	public boolean completeMove(int diceRoll, ArrayList<Boolean> moves, int initX, int initY, int finalX, int finalY){
		if (moves.size() > diceRoll){
			System.out.println("You can't move there");
			this.setX(initX);
			this.setY(initY);
			return false;
		}
		for (boolean move : moves){
			if (move == false){
				System.out.println("You can't move there");
				this.setX(initX);
				this.setY(initY);
				return false;
			}
			else if (study.getMembers().contains(this) || hall.getMembers().contains(this) || lounge.getMembers().contains(this) || library.getMembers().contains(this)
					|| billiardRoom.getMembers().contains(this) || diningRoom.getMembers().contains(this) || conservatory.getMembers().contains(this) || ballroom.getMembers().contains(this) || kitchen.getMembers().contains(this)){
				board.populate(hallWay, initX, initY);
				this.setX(0);
				this.setY(0);
				return true;
			}
		}
		this.setX(finalX);
		this.setY(finalY);
		board.populate(hallWay, initX, initY);
		board.populate(this, finalX, finalY);
		return true;
	}
	
	public boolean usePassageway(){
		if (study.getMembers().contains(this)){
			study.getMembers().remove(this);
			kitchen.getMembers().add(this);
			return true;
		}
		if (kitchen.getMembers().contains(this)){
			kitchen.getMembers().remove(this);
			study.getMembers().add(this);
			return true;
		}
		if (conservatory.getMembers().contains(this)){
			conservatory.getMembers().remove(this);
			lounge.getMembers().add(this);
			return true;
		}
		if (lounge.getMembers().contains(this)){
			lounge.getMembers().remove(this);
			conservatory.getMembers().add(this);
			return true;
		}
		return false;
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
		yPos = newY;
	}

}
