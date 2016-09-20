package edu.buffalo.cse116;

public class Game {
	public static void main(String[] args) {
		Wall wall = new Wall();
		Board board = new Board(24, 25);
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
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 3; j++){
				board.populate(wall, i, j);
			}
		}
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
	
}
