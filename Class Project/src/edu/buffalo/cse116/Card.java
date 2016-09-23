package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	//first, create three different groups that will represent what kinds of cards we'll be dealing with

	//the weapons of the game
	public enum Weapons{
		KNIFE,ROPE,REVOLVER,WRENCH,PIPE,CANDLESTICK;
	}
	
	//the game's potential suspects
	public enum Suspects{
		MISSSCARLET,MRSWHITE,PROFESSORPLUM,COLONELMUSTARD,MRGREEN,MRSPEACOCK;
	}
	
	//the rooms that are in the game
	public enum Rooms{
		KITCHEN, BALLROOM, CONSERVATORY, DININGROOM, SAFE, BILLARDROOM, LIBRARY, LOUNGE, HALL, STUDY;
	}

	//this variable will represent the card's absolute type for use thruought the game
	final Suspects suspects;
	final Rooms rooms;
	final Weapons weapons;
	
	//the constructor will assign a card to a type permanently
	
	private Card(final Weapons weapons,final Suspects suspects, final Rooms rooms)
	{
		this.weapons=weapons;
		this.rooms=rooms;
		this.suspects=suspects;

	}
	
	//here we'll begin creating the deck of cards, which will need to have one card from each group removed eventually to make the solutions group, 
	//the rest will have to be distributed evenly among the players
	
	//i chose an arraylist since the order of elements isn't relevant and i'll probably be manipulating the elements inside it often
	private static final List<Card>Test=new ArrayList<Card>();
	
	
	//three for each loops that will loop thru the enum elements of the respected cardtype, 
	//it will insert the element into 
	static{
		for (Weapons weapons:Weapons.values()){
			for(Suspects suspects:Suspects.values()){
				for(Rooms rooms:Rooms.values()){
				Test.add(new Card(weapons,suspects,rooms));
				}
			}
		}
	}
	
	public static ArrayList<Card>initialDeck(){
		return new ArrayList<Card>(Test);
	}
	
	
	//public ArrayList<Card>SolutionSet();
	
	public static ArrayList<Card>deal(final List<Card>deck,final int n){
		final int deckSize=deck.size();
		final List<Card>visibleHand=deck.subList(deckSize-n, deckSize);
		final ArrayList<Card>hand=new ArrayList<Card>(visibleHand);
		visibleHand.clear();
		return hand;
	}

	//cards are grouped by type
	
	//at start, 3 cards are randomly chosen, one from each group
	//these will be the solution set of cards
	
	//depending on number of players, deal out remainder of cards
}
