// Java program to handle MouseListener events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Mouse extends Frame implements MouseListener {

	// Jlabels to display the actions of events of mouseListener
	// static JLabel label1, label2, label3;
    private Piano piano = new Piano();

	// default constructor
	Mouse()
	{
    }

	// getX() and getY() functions return the
	// x and y coordinates of the current
	// mouse position
	// getClickCount() returns the number of
	// quick consecutive clicks made by the user

	// this function is invoked when the mouse is pressed
	public void mousePressed(MouseEvent e)
	{
	}

	// this function is invoked when the mouse is released
	public void mouseReleased(MouseEvent e)
	{
	}

	// this function is invoked when the mouse exits the component
	public void mouseExited(MouseEvent e)
	{
	}

	// this function is invoked when the mouse enters the component
	public void mouseEntered(MouseEvent e)
	{
	}

	// this function is invoked when the mouse is pressed or released
	public void mouseClicked(MouseEvent e)
	{
        for (int i = 0; i < piano.getBlackList().size(); i++) {
            if (piano.getBlackList().get(i).isClicked(e)){
                System.out.println(piano.getBlackList().get(i).getNote());
            }
        }
        for (int i = 0; i < piano.getWhiteList().size(); i++) {
            if (piano.getWhiteList().get(i).isClicked(e)){
                System.out.println(piano.getWhiteList().get(i).getNote());
            }
            //TODO fix the piano. the black kes for the second octae are not in the rifhr place. look at c5
            //TODO does not check for click if its close to the border of the key
        }
	}
}
