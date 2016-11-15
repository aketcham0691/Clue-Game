package code;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * Parent class for different card subclasses.
 * @author Andrew Ketcham, Kevin Hanley, Brian Irving.
 *
 */
public abstract class Card {
	
	protected ImageIcon picture;
	
	public ImageIcon getPicture(){
		return picture;
	}
}




