package code;

public class Weapon extends Card{

	private String weaponName;
	
	public Weapon(String name){
		weaponName = name;
	}
	
	public String getName(){
		return weaponName;
	}
}
