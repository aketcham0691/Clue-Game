package code;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deckCards = new ArrayList<Card>(); 
	private ArrayList<Card> envelope = new ArrayList<Card>(); 
	private Random rand = new Random(System.currentTimeMillis());
	
	public Deck(){
		CharacterCard missScarlet = new CharacterCard("Miss Scarlet");
		CharacterCard professorPlum = new CharacterCard("Professor Plum");
		CharacterCard mrsPeacock = new CharacterCard("Mrs. Peacock");
		CharacterCard mrGreen = new CharacterCard("Mr. Green");
		CharacterCard colonelMustard = new CharacterCard("Colonel Mustard");
		CharacterCard mrsWhite = new CharacterCard("Mrs. White");
		Weapon candlestick = new Weapon("Candlestick");
		Weapon knife = new Weapon("Knife");
		Weapon leadPipe = new Weapon("Lead Pipe");
		Weapon revolver = new Weapon("Revolver");
		Weapon rope = new Weapon("Rope");
		Weapon wrench = new Weapon("Wrench");
		RoomCard kitchen = new RoomCard("Kitchen"); 
		RoomCard ballRoom = new RoomCard("Ballroom"); 
		RoomCard conservatory = new RoomCard("Conservatory"); 
		RoomCard diningRoom = new RoomCard("Dining Room"); 
		RoomCard billiardRoom = new RoomCard("Billiard Room"); 
		RoomCard library = new RoomCard("Library"); 
		RoomCard lounge = new RoomCard("Lounge"); 
		RoomCard hall = new RoomCard("Hall"); 
		RoomCard study= new RoomCard("Study"); 
		
		deckCards.add(missScarlet); 
		deckCards.add(professorPlum); 
		deckCards.add(mrsPeacock); 
		deckCards.add(mrGreen); 
		deckCards.add(colonelMustard); 
		deckCards.add(mrsWhite); 
		deckCards.add(candlestick); 
		deckCards.add(knife); 
		deckCards.add(leadPipe); 
		deckCards.add(revolver); 
		deckCards.add(rope); 
		deckCards.add(wrench); 
		deckCards.add(kitchen); 
		deckCards.add(ballRoom); 
		deckCards.add(conservatory); 
		deckCards.add(diningRoom); 
		deckCards.add(billiardRoom); 
		deckCards.add(library); 
		deckCards.add(lounge); 
		deckCards.add(hall); 
		deckCards.add(study); 
	}
	
	public void makeEnvelope(){
		
		int randNum = rand.nextInt(6); 
		int randNum2 = rand.nextInt(6) + 6; 
		int randNum3 = rand.nextInt(9) + 12;
		envelope.add(deckCards.remove(randNum)); 
		envelope.add(deckCards.remove(randNum2)); 
		envelope.add(deckCards.remove(randNum3)); 
		
	}
	
	public void shuffleDeck(ArrayList<Card> deck){
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		for (int i = 0; i < 18; i++){
			int randNum = rand.nextInt(deck.size());
			shuffledDeck.add(deck.remove(randNum));
		}
		deckCards = shuffledDeck;		
	}
	
	public void dealDeck(ArrayList<Card> deck, ArrayList<Player> players){
		while (!deck.isEmpty()){
			for (Player p : players){
				if (players.indexOf(p) < deck.size()){
					p.getPlayersCards().add(deck.remove(0));
				}
			}
		}
	}
	
}
