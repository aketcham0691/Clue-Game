package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
	
private String name;

public enum CardType{
	PERSON,WEAPON,ROOM;
}
private CardType type;

public CardType getCardType(){
	return type;
}

public void setCardType(CardType cardType){
	this.type=cardType;
}

public String getName(){
	return name;
}

public void setName(String name){
	this.name=name;
}

public Card(String name,CardType type){
	super();
	this.name=name;
	this.type=type;
}


@Override
public int hashCode(){
	final int prime=31;
	int result=1;
	result=prime*result+((name==null)?0:name.hashCode());
	result=prime*result+((type==null)?0:name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj){
	if(this==obj)
		return true;
	if(obj==null)
		return false;
	if(getClass()!=obj.getClass())
		return false;
	Card other=(Card)obj;
	if(name==null){
		if(other.name!=null)
			return false;
	}else if(!name.equals(other.name))
		return false;
 if(type !=other.type)
	 return false;
 return true;}
}