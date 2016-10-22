package code;
/**
 * Subclass of Card used for the different weapons in the game.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class Weapon extends Card{
	/**
	 * Stores the name of the weapon.
	 */
	private String weaponName;
	/**
	 * Constructor that sets the weapon's name.
	 * @param name Name of the weapon.
	 */
	public Weapon(String name){
		weaponName = name;
	}
	
	/**
	 * Returns the weapon's name.
	 */
	public String toString(){
		return weaponName;
	}
}
