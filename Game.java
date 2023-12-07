import javax.swing.JFrame;
import java.awt.*;

public class Game extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public Game()
  {
    super("Game");
    setSize(WIDTH,HEIGHT);

    Screen theGame = new Screen();
    ((Component) theGame).setFocusable(true);

    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main( String args[] )
  {
    Game run = new Game();
  }
}
