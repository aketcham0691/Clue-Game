package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CardTests {

	@Test 
	public void getCardNameTest01(){
	 Card testCard=new Card(1,1);
String  test = testCard.toString();
String expected="Professor White";

assertEquals(test,expected);
	 
		
	}
	
@Test public void getCardNameTest02(){
		Card testCard=new Card(1,6);
		String test=testCard.toString();
		String ex="Knife";
		assertEquals(test,ex);
	}

@Test public void newDeckTests(){
Card test=new Card();
ArrayList<Card> testDeck = test.newDeck();
int correctSize=21;

int deckSize=testDeck.size();
assertEquals(correctSize,deckSize);
}

@Test public void newDeckContents(){
	Card test=new Card();
	ArrayList<Card> testDeck = test.newDeck();
	Card x=Card.Billard;
	boolean isCardInDeck=testDeck.contains(x);
	assertEquals(true,isCardInDeck);
	//System.out.println("The cards in the new deck are..."+testDeck.toString());
}


@Test public void shuffledDeckTests(){
	Card test=new Card();
	ArrayList<Card> testDeck = test.newDeck();
ArrayList<Card> newDeck = test.shuffleDeck(testDeck);
//System.out.println("The cards in the shuffled deck are..."+newDeck.toString()+"It's size is "+newDeck.size());

}



@Test public void dealedDeckTests(){
Player one=new Player();
Player two=new Player();
Player three=new Player();
Player four=new Player();

System.out.println("Player One's Cards Are: "+one.getPlayersCards());
System.out.println("Player One's Cards Are: "+two.getPlayersCards());
System.out.println("Player One's Cards Are: "+three.getPlayersCards());
System.out.println("Player One's Cards Are: "+four.getPlayersCards());


}
	

@Test public void gameSolutionTests(){
Card test=new Card();	
ArrayList<Card> testDeck = test.newDeck();
ArrayList<Card> newDeck = test.shuffleDeck(testDeck);
ArrayList<Card>solutionDeck=test.gameSolution(newDeck);
int expected=1;
int actual=solutionDeck.size();
assertEquals(expected,actual);
System.out.println("Here's an example of a solution set: "+ solutionDeck.toString());
}}

