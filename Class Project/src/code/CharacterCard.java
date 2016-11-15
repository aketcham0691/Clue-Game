package code;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * Subclass of Card used for the different suspects in the game.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public class CharacterCard extends Card{
	/**
	 * Stores the suspect's name.
	 */
	private String characterName;
	/**
	 * Constructor that sets the suspect's name.
	 * @param name The name of the suspect.
	 */
	public CharacterCard(String name, ImageIcon picture){
		characterName = name;
		this.picture = picture;
	}
	
	/**
	 * Returns the character's name.
	 */
	public String toString(){
		return characterName;
	}
}
