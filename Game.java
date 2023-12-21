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
    Screen theGame = new Screen();
    ((Component) theGame).setFocusable(true);
    WindowListener listener = new WindowAdapter() {

        public void windowClosing(WindowEvent w) {
            // int response = JOptionPane.showConfirmDialog(null, " Are you sure you want isuue the ticket?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            int confirm = JOptionPane.showConfirmDialog(null,"are you sure you want to Exit","Exit",JOptionPane.YES_NO_OPTION, 1);
            theGame.save();
            if(confirm == 0) {
              // close();
              System.exit(0);
            }
        }
    };

    addWindowListener(listener);
    setSize(WIDTH,HEIGHT);


    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setVisible(true);

    JPanel p = new JPanel();
 
    // set the layout of the panel
    p.setLayout(new FlowLayout());

    // create an object of mouse class

    // add panel to the frame
    add(p);

    show();

  }

  public static void main( String args[] )
  {
    Game run = new Game();
  }
}
