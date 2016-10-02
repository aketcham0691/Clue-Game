package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Card {
	
	
private int cards;
private String name;
ArrayList<Card>deck;
ArrayList<Card>shuffled;
ArrayList<Player>players;




public int type=0;
public int value=0;

public static final int suspect=0;
public static final int weapon=1;
public static final int room=2;

public static final int numOfSuspects=6;
public static final int x=5;
public static final int numOfRooms=9;
public static final int y=11;
public static final int numOfWeapons=6;
public static final int z=20;
public static final int total=numOfSuspects+numOfRooms+numOfWeapons;

public static final int suspectScarlet=0;
public static final int suspectWhite=1;
public static final int suspectPlum=2;
public static final int suspectMustard=3;
public static final int suspectGreen=4;
public static final int suspectPeacock=5;

public static final int weaponKnife=6;
public static final int weaponRope=7;
public static final int weaponRevolver=8;
public static final int weaponWrench=9;
public static final int weaponPipe=10;
public static final int weaponCandle=11;

public static final int roomStudy=12;
public static final int roomHall=13;
public static final int roomLounge=14;
public static final int roomLibrary=15;
public static final int roomBillard=16;
public static final int roomDining=17;
public static final int roomConservatory=18;
public static final int roomBallRoom=19;
public static final int roomKitchen=20;

public static final Card Knife=new Card(weapon,weaponKnife);
public static final Card Rope=new Card(weapon,weaponRope);
public static final Card Revolver=new Card(weapon,weaponRevolver);
public static final Card Wrench=new Card(weapon,weaponWrench);
public static final Card Pipe=new Card(weapon,weaponPipe);
public static final Card Candle=new Card(weapon,weaponCandle);

public static final Card Scarlet=new Card(suspect, suspectScarlet);
public static final Card White=new Card(suspect, suspectWhite);
public static final Card Plum=new Card(suspect, suspectPlum);
public static final Card Mustard=new Card(suspect,suspectMustard);
public static final Card Green=new Card(suspect,suspectGreen);
public static final Card Peacock=new Card(suspect, suspectPeacock);

public static final Card Study=new Card(room,roomStudy);
public static final Card Hall=new Card(room, roomHall);
public static final Card Lounge=new Card(room, roomLounge);
public static final Card Conservatory=new Card(room, roomConservatory);
public static final Card BallRoom=new Card(room, roomBallRoom);
public static final Card Kitchen=new Card(room,roomKitchen);
public static final Card Library=new Card(room, roomLibrary);
public static final Card Billard=new Card(room, roomBillard);
public static final Card Dining=new Card(room, roomDining);

public String toString(){
	String translate=null;
	
	switch(value){
	
	//0
	case suspectScarlet:
	translate="Ms Vivienne Scarlet";
	break;
	
	case suspectWhite:
	translate="Professor White";
	break;
	
	case suspectPlum:
	translate="Prof. Peter Plum";
	break;
	
	case suspectMustard:
		translate="Col Michael Mustard";
		break;
		
	case suspectGreen:
	translate="Jonathan Green";
			break;
	
	//5
	case suspectPeacock:
		translate="Elizabeth Peacock";
		break;
		
	case weaponKnife:
		translate="Knife";
		break;
		
	case weaponRope:
		translate="Rope";
		break;
		
	case weaponRevolver:
		translate="Revolver";
		break;
	
	case weaponWrench:
		translate="Wrench";
		break;
		
		//10
	case weaponPipe:
		translate="Pipe";
		break;
		
	case weaponCandle:
		translate="Candle";
		break;
		
	case roomStudy:
		translate="Study";
		break;
		
	case roomHall:
		translate="Hall";
		break;
		
	case roomLounge:
		translate="Lounge";
		break;
		
	//15
	case roomLibrary:
		translate="Library";
		break;
		
	case roomBillard:
		translate="Billard Room";
		break;
		
	case roomDining:
		translate="Dining Room";
		break;
		
	case roomConservatory:
		translate="Conservatory";
		break;
		
	case roomBallRoom:
		translate="BallRoom";
		break;
	
	case roomKitchen:
		translate="Kitchen";
		break;
	}
	return translate;

}
public int  getCardType(){
	return type;
}





public Card(int type,int value){
	this.type=type;
	this.value=value;
}





public Card() {
	// TODO Auto-generated constructor stub
}
public ArrayList<Card> newDeck(){
	
//creates a new card array with the size equal to the number of suspects, weapons, and rooms available in the game
	ArrayList<Card>deck=new ArrayList<Card>(total);

	//suspects
deck.add(Scarlet);
deck.add(White);
deck.add(Plum);
deck.add(Mustard);
deck.add(Green);
deck.add(Peacock);


//weapons
deck.add(Knife);
deck.add(Rope);
deck.add(Revolver);
deck.add(Wrench);
deck.add(Pipe);
deck.add(Candle);


//rooms
deck.add(Study);
deck.add(Hall);
deck.add(Lounge);
deck.add(Library);
deck.add(Billard);
deck.add(Dining);
deck.add(Conservatory);
deck.add(BallRoom);
deck.add(Kitchen);


return deck;

}
public ArrayList<Card> shuffleDeck(ArrayList<Card>deck){
	
	ArrayList<Card>shuffled=new ArrayList<Card>(total);
	
	Random rand=new Random();
	for(int i=0;i<total;i++){
		int r=rand.nextInt(deck.size());
		Card c=deck.get(r);
		shuffled.add(c);
		}
	return shuffled;
}

public ArrayList <Card> getShuffledDeck(){
	
	return shuffled;
}

public void  dealTheShuffledDeck(ArrayList<Card>deck)  {

Player player = new Player();;
for(int i=0;i<deck.size();i++){
	Card card=deck.get(i);
	player.addCard(card);

	}

}

public ArrayList<Card>  gameSolution(ArrayList<Card> shuffled){
int solutionTotal = 3;
Card card = new Card(type,value);
ArrayList<Card>solutionSet=new ArrayList<Card>(solutionTotal);
for(int i=0;i<shuffled.size();i++){
	card.type=0;
	card.value=i;
	if(solutionSet.isEmpty()){
		solutionSet.add(card);
		i++;
	}
	else if(solutionSet.size()==1&&!solutionSet.contains(card)){
		card.type=1;
		card.value=i;
		i++;
		solutionSet.add(card);
		
	}
	else if(solutionSet.size()==2&&!solutionSet.contains(card)){
		card.type=2;
		card.value=i;
		solutionSet.add(card);
		i++;
	}
	else{
		i++;
	}

}	return solutionSet;}
	
	

	
	
	
	
}




