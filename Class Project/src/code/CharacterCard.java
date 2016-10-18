package code;

public class CharacterCard extends Card{
	
	private String characterName;
	
	public CharacterCard(String name){
		characterName = name;
	}
	
	
	public String toString(){
		return characterName;
	}
}
