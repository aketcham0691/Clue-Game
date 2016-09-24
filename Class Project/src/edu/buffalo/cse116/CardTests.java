package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.Card.CardType;

public class CardTests {
	
	@Test
	public void getCardName(){
		Card card=new Card("COLONEL_MUSTARD",CardType.PERSON);
		assertEquals(card.getName(),"COLONEL_MUSTARD");
	}
	
	@Test
	public void getCardType(){
		Card card=new Card("LIBRARY",CardType.ROOM);
		assertEquals(card.getCardType(),CardType.ROOM);
	}

	
		
	}

