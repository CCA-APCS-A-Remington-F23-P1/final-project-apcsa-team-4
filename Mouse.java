// Java program to handle MouseListener events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Mouse extends Frame implements MouseListener {

	// Jlabels to display the actions of events of mouseListener
	// static JLabel label1, label2, label3;
    private Piano piano;
    private ArrayList<Key> user;
    private boolean allowClick;
    private Song song;

	// default constructor
	Mouse(Piano p)
	{
        piano = p;
        user = new ArrayList<Key>();
        song = new Song();
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

    public ArrayList<Key> getUser() {
        return user;
    }

    public void resetUser() {
        user = new ArrayList<Key>();
    }

    public void setAllowClick(boolean b) {
        allowClick = b;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song s) {
        song = s;
    }

	// this function is invoked when the mouse is pressed or released
	public void mouseClicked(MouseEvent e)
	{
        if (allowClick) {

            for (int i = 0; i < piano.getBlackList().size(); i++) {
                if (piano.getBlackList().get(i).isClicked(e)){
                    piano.setOGColor();
                    piano.getBlackList().get(i).setColor(Color.blue);
                    user.add(piano.getBlackList().get(i));
                    return;
                }

                piano.getBlackList().get(i).setColor(Color.black);
            }
            for (int i = 0; i < piano.getWhiteList().size(); i++) {
                if (piano.getWhiteList().get(i).isClicked(e)){
                    piano.setOGColor();
                    // System.out.println(Color.blue);
                    piano.getWhiteList().get(i).setColor(Color.blue);
                    user.add(piano.getWhiteList().get(i));
                    return;
                }

                piano.getWhiteList().get(i).setColor(Color.white);
            }
        }
        for (int i = 0; i < Button.buttons.size(); i++) {
            if (Button.buttons.get(i).isClicked(e)) {
                Button.buttons.get(0).setColorAll(Color.white);
                Button.buttons.get(i).setColor(Color.green);
                song = new Song(Button.buttons.get(i).getSong());
                user = new ArrayList<Key>();
                Song.resetCheck();
            }
        }
	}
}
