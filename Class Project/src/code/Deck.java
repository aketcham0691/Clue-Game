package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
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
		CharacterCard missScarlet = new CharacterCard("Miss Scarlet", new ImageIcon(getClass().getResource("Miss Scarlet.jpg")));
		CharacterCard professorPlum = new CharacterCard("Professor Plum", new ImageIcon(getClass().getResource("Prof Plum.jpg")));
		CharacterCard mrsPeacock = new CharacterCard("Mrs. Peacock", new ImageIcon(getClass().getResource("peacock.jpg")));
		CharacterCard mrGreen = new CharacterCard("Mr. Green", new ImageIcon(getClass().getResource("Mr Green.jpg")));
		CharacterCard colonelMustard = new CharacterCard("Colonel Mustard", new ImageIcon(getClass().getResource("Colonel Mustard.jpg")));
		CharacterCard mrsWhite = new CharacterCard("Mrs. White", new ImageIcon(getClass().getResource("Mrs White.jpg")));
		Weapon candlestick = new Weapon("Candlestick", new ImageIcon(getClass().getResource("Candlestick.jpg")));
		Weapon knife = new Weapon("Knife", new ImageIcon(getClass().getResource("Knife.jpg")));
		Weapon leadPipe = new Weapon("Lead Pipe", new ImageIcon(getClass().getResource("Lead Pipe.jpg")));
		Weapon revolver = new Weapon("Revolver", new ImageIcon(getClass().getResource("Revolver.jpg")));
		Weapon rope = new Weapon("Rope", new ImageIcon(getClass().getResource("Rope.jpg")));
		Weapon wrench = new Weapon("Wrench", new ImageIcon(getClass().getResource("Wrench.jpg")));
		RoomCard kitchen = new RoomCard("Kitchen", new ImageIcon(getClass().getResource("Kitchen.jpg"))); 
		RoomCard ballRoom = new RoomCard("Ballroom", new ImageIcon(getClass().getResource("Ballroom.jpg"))); 
		RoomCard conservatory = new RoomCard("Conservatory", new ImageIcon(getClass().getResource("Conservatory.jpg"))); 
		RoomCard diningRoom = new RoomCard("Dining Room", new ImageIcon(getClass().getResource("Dining Room.jpg"))); 
		RoomCard billiardRoom = new RoomCard("Billiard Room", new ImageIcon(getClass().getResource("Billiard Room.jpg"))); 
		RoomCard library = new RoomCard("Library", new ImageIcon(getClass().getResource("Library.jpg"))); 
		RoomCard lounge = new RoomCard("Lounge", new ImageIcon(getClass().getResource("Lounge.jpg"))); 
		RoomCard hall = new RoomCard("Hall", new ImageIcon(getClass().getResource("Hall.jpg"))); 
		RoomCard study= new RoomCard("Study", new ImageIcon(getClass().getResource("Study.jpg"))); 
		
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
				if (!deckCards.isEmpty()){
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
	public ArrayList<Card> getEnvelope(){
		return envelope;
	}
}
