package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Class that develops the deck used in the game as well as methods for creating the envelope and dealing cards.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Deck {
	
	/**
	 * ArrayList used for storing the cards in the deck.
	 */
	private ArrayList<Card> deckCards = new ArrayList<Card>();
	/**
	 * ArrayList used for storing the cards in the envelope.
	 */
	private ArrayList<Card> envelope = new ArrayList<Card>(); 
	/**
	 * Random object used to create a random envelope of suspect, weapon, and room.
	 */
	private Random rand = new Random(System.currentTimeMillis());
	/**
	 * ArrayList used for storing a full deck of cards used as choices to be made when making a suggestion.
	 */
	private ArrayList<Card> fullDeck = new ArrayList<Card>();
	/**
	 * Constructor adds each card in the game to the new deck.
	 */
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
		fullDeck = deckCards;
	}
	/**
	 * Method takes a random CharacterCard (suspect), Weapon, and Room, removes them from the deck, and
	 * adds them to the envelope.
	 */
	public void makeEnvelope(){
		
		int randNum = rand.nextInt(6); 
		int randNum2 = rand.nextInt(6) + 5; 
		int randNum3 = rand.nextInt(9) + 10;
		envelope.add(deckCards.remove(randNum)); 
		envelope.add(deckCards.remove(randNum2)); 
		envelope.add(deckCards.remove(randNum3)); 
		
	}
	
	/**
	 * Method shuffles the deck to randomize the card order in the deck to be used when dealing.
	 */
	public void shuffleDeck(){
		Collections.shuffle(deckCards);
	}
	
	/**
	 * Deals the top card of the deck to each player until the deck is empty.
	 * @param players
	 */
	public void dealDeck(ArrayList<Player> players){
		while (!deckCards.isEmpty()){
			for (Player p : players){
				if (players.indexOf(p) < deckCards.size()){
					p.getPlayersCards().add(deckCards.remove(0));
				}
			}
		}
	}
	/**
	 * @return Returns the current deck of cards.
	 */
	public ArrayList<Card> getCards(){
		return deckCards;
	}
	/**
	 * @return Returns a full deck of cards.
	 */
	public ArrayList<Card> getFullDeck(){
		return fullDeck;
	}
}
