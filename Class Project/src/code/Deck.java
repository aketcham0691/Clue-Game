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
		CharacterCard missScarlet = new CharacterCard("Miss Scarlet", new ImageIcon(new ImageIcon(getClass().getResource("Miss Scarlet.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		CharacterCard professorPlum = new CharacterCard("Professor Plum", new ImageIcon(new ImageIcon(getClass().getResource("Prof Plum.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		CharacterCard mrsPeacock = new CharacterCard("Mrs. Peacock", new ImageIcon(new ImageIcon(getClass().getResource("peacock.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		CharacterCard mrGreen = new CharacterCard("Mr. Green", new ImageIcon(new ImageIcon(getClass().getResource("Mr Green.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		CharacterCard colonelMustard = new CharacterCard("Colonel Mustard", new ImageIcon(new ImageIcon(getClass().getResource("Colonel Mustard.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		CharacterCard mrsWhite = new CharacterCard("Mrs. White", new ImageIcon(new ImageIcon(getClass().getResource("Mrs White.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon candlestick = new Weapon("Candlestick", new ImageIcon(new ImageIcon(getClass().getResource("Candlestick.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon knife = new Weapon("Knife", new ImageIcon(new ImageIcon(getClass().getResource("Knife.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon leadPipe = new Weapon("Lead Pipe", new ImageIcon(new ImageIcon(getClass().getResource("Lead Pipe.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon revolver = new Weapon("Revolver", new ImageIcon(new ImageIcon(getClass().getResource("Revolver.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon rope = new Weapon("Rope", new ImageIcon(new ImageIcon(getClass().getResource("Rope.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		Weapon wrench = new Weapon("Wrench", new ImageIcon(new ImageIcon(getClass().getResource("Wrench.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		RoomCard kitchen = new RoomCard("Kitchen", new ImageIcon(new ImageIcon(getClass().getResource("Kitchen.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard ballRoom = new RoomCard("Ballroom", new ImageIcon(new ImageIcon(getClass().getResource("Ballroom.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard conservatory = new RoomCard("Conservatory", new ImageIcon(new ImageIcon(getClass().getResource("Conservatory.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard diningRoom = new RoomCard("Dining Room", new ImageIcon(new ImageIcon(getClass().getResource("Dining Room.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard billiardRoom = new RoomCard("Billiard Room", new ImageIcon(new ImageIcon(getClass().getResource("Billiard Room.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard library = new RoomCard("Library", new ImageIcon(new ImageIcon(getClass().getResource("Library.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard lounge = new RoomCard("Lounge", new ImageIcon(new ImageIcon(getClass().getResource("Lounge.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard hall = new RoomCard("Hall", new ImageIcon(new ImageIcon(getClass().getResource("Hall.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		RoomCard study= new RoomCard("Study", new ImageIcon(new ImageIcon(getClass().getResource("Study.jpg")).getImage().getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH))); 
		
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
		int randNum2 = rand.nextInt(5) + 5; 
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
