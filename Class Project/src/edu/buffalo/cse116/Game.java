package edu.buffalo.cse116;

public class Game {

	
	public static void main(String[] args) {
		Board board = new Board(24, 25);
		Wall wall = new Wall();
		Room study = new Room("Study");
		Room hall = new Room("Hall");
		Room lounge = new Room("Lounge");
		Room library = new Room("Library");
		Room billiard = new Room("Billiard Room");
		Room dining = new Room("Dining Room");
		Room conservatory = new Room("Conservatory");
		Room ballroom = new Room("Ballroom");
		Room kitchen = new Room("Kitchen");
		board.populate(studyDoor, 0, 3);
		
		Doorway studyDoor = new Doorway(study);
		Doorway hallDoor = new Doorway(hall);
		Doorway loungeDoor = new Doorway(lounge);
		Doorway libraryDoor = new Doorway(library);
		Doorway billiardDoor = new Doorway(billiard);
		Doorway diningDoor = new Doorway(dining);
		Doorway consDoor = new Doorway(conservatory);
		Doorway ballroomDoor = new Doorway(ballroom);
		Doorway kitchenDoor = new Doorway(kitchen);
	}
	public void populateWalls(Board board, Wall wall){
		for (int i = 17; i < 23; i++){
			for (int j = 0; i < 5; j++){
				board.populate(wall, i, j);
			}
		}
		for (int i = 16; i < 23; i++){
			for (int j = 9; i < 15; j++){
				board.populate(wall, i, j);
			}
		}
		for (int i = 18; i < 23; i++){
			for (int j = 18; i < 23; j++){
				board.populate(wall, i, j);
			}
		}
		board.populate(wall, 6, 0);
		board.populate(wall, 8, 0);
		board.populate(wall, 15, 0);
		board.populate(wall, 0, 4);
		board.populate(wall, 0, 11);
		board.populate(wall, 0, 17);
		board.populate(wall, 6, 23);
		board.populate(wall, 6, 24);
		board.populate(wall, 7, 24);
		board.populate(wall, 8, 24);
	}
	public void populateStudy(Board board, Wall wall){
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 3; j++){
				board.populate(wall, i, j);
			}
		}
	}
	public void populateLibrary(Board board, Wall wall){
		for (int i = 0; i < 5; i++){
			for (int j = 6; i < 10; j++){
				board.populate(wall, i, j);
			}
		}
		for (int j = 7; j < 9; j++){
			board.populate(wall, 6, j);
		}
	}
	public void populateBilliard(Board board, Wall wall){
		for (int i = 0; i < 5; i++){
			for (int j = 12; i < 16; j++){
				board.populate(wall, i, j);
			}
		}
	}
	public void populateConservatory(Board board, Wall wall){
		for (int i = 0; i < 5; i++){
			board.populate(wall, i, 19);
		}
		for (int i = 0; i < 5; i++){
			for (int j = 20; i < 23; j++){
				board.populate(wall, i, j);
			}
		}
	}
	public void populateHall(Board board, Wall wall){
		for (int i = 9; i < 14; i++){
			for (int j = 0; i < 6; j++){
				board.populate(wall, i, j);
			}
		}
	}
	public void populateBallroom(Board board, Wall wall){
		for (int i = 8; i < 15; i++){
			for (int j = 17; i < 22; j++){
				board.populate(wall, i, j);
			}
		}
		for (int i = 10; i < 13; i++){
			for (int j = 23; j < 24; j++){
				board.populate(wall, i, j);
			}
		}
	}
	
}
