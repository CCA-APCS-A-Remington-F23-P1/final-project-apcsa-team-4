import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.*;
import java.awt.Font;

public class Screen extends Canvas implements KeyListener, Runnable
{
  private boolean[] keys;
  private BufferedImage back;
  private Piano piano;
  private Song song;
  private MouseEvent e;
  private int counti;
  private int countj;
  private long timeFromLast;
  private long timeFromLast2;
  private boolean wait;
  private boolean fail;
  private ArrayList<Key> check;
  private Mouse m;

  public Screen()
  {
    setBackground(Color.white);

    keys = new boolean[6];
    piano = new Piano();
    song = new Song();
    wait = false;
    fail = false;
    check = new ArrayList<Key>(0);
    counti = 0;
    countj = 0;

    this.addKeyListener(this);
    new Thread(this).start();


    m = new Mouse(piano);

    // add mouseListener to the frame
    addMouseListener(m);

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    
    graphToBack.setColor(Color.gray);

    graphToBack.fillRect(0,0,780,1200);

    piano.draw(graphToBack);


    if (fail == false) {  
      if (counti < song.getSong().size()) {
        if (countj < counti+1 && Instant.now().toEpochMilli()-timeFromLast >= 800 && wait == false) {
          m.setAllowClick(false);
          timeFromLast = Instant.now().toEpochMilli();
          piano.setOGColor();
          piano.getKey(song.getSong().get(countj)).setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
          check.add(piano.getKey(song.getSong().get(countj)));
          countj++;
        }
        else if (Instant.now().toEpochMilli()-timeFromLast < 800 && wait == false) {}
        else if (wait == false){
          countj = 0;
          counti++;
          wait = true;
        }
      }
      if (wait == true) {
        m.setAllowClick(true);
        for (int i = 0; i < m.getUser().size(); i++) {
          if (!m.getUser().get(i).equals(check.get(i))) {
            System.out.println("oop");
            fail = true;
            break;
          }
          if (i == check.size()-1) {
            check.get(check.size() - 1).setColor(Color.blue);
            // try {Thread.sleep(800);} catch(Exception e){}
            m.resetUser();
            wait = false;
            check = new ArrayList<Key>();
            // System.out.println("Slayy");
            m.setAllowClick(false);
          }
        }
        timeFromLast2 = Instant.now().toEpochMilli();
      }
    }
    if (fail) {
      piano.setColor(Color.red);
    }

    if (keys[0])
    {
    }
    else if (keys[1])
    {
    
    }
    else if (keys[2])
    {
        
    }
    else if (keys[3])
    {
    
    }
    else if (keys[4]) {
    }
    

      twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_R) {
      keys[5] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_R)
    {
      keys[5] = false;
    }
    
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  
  }
}


