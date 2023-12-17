import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame
{
  private static final int WIDTH = 780;
  private static final int HEIGHT = 1200;

  public Game()
  {
    super("Game");
    setSize(WIDTH,HEIGHT);

    Screen theGame = new Screen();
    ((Component) theGame).setFocusable(true);

    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    JPanel p = new JPanel();
 
    // set the layout of the panel
    p.setLayout(new FlowLayout());

    // create an object of mouse class
    Mouse m = new Mouse();

    // add mouseListener to the frame
    theGame.addMouseListener(m);

    // add panel to the frame
    add(p);

    show();

  }

  public static void main( String args[] )
  {
    Game run = new Game();
  }
}
