import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.*;
import java.awt.Font;

public class Screen extends Canvas implements Runnable
{
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
  private Mouse m;
  private Button b1;
  private Button b2;
  private Button b3;
  private Button b4;

  public Screen()
  {
    setBackground(Color.white);

    piano = new Piano();
    song = new Song();
    wait = false;
    fail = false;
    counti = 0;
    countj = 0;

    b1 = new Button("twinkle twinkle");
    b1.setColor(Color.green);
    b2 = new Button("hot cross buns");
    b3 = new Button("old mcdonald");
    b4 = new Button("happy birthday");

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
    b1.draw(graphToBack);
    b2.draw(graphToBack);
    b3.draw(graphToBack);
    b4.draw(graphToBack);

    
    if (song != m.getSong()) {
      song = m.getSong();
      counti = 0;
      countj = 0;
      fail = false;
      wait = false;
      m.setAllowClick(false);
    }

    graphToBack.setFont(new Font("MS Mincho",Font.PLAIN, 53));
    graphToBack.drawString(song.getSongName(), 200, 400);

    if (fail == false) {  
      if (counti < song.getSong().size()) {
        if (countj < counti+1 && Instant.now().toEpochMilli()-timeFromLast >= 800 && wait == false) {
          m.setAllowClick(false);
          timeFromLast = Instant.now().toEpochMilli();
          piano.setOGColor();
          piano.getKey(song.getSong().get(countj)).setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
          Song.check.add(piano.getKey(song.getSong().get(countj)));
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
          if (!m.getUser().get(i).equals(Song.check.get(i))) {
            // System.out.println("oop");
            fail = true;
            break;
          }
          if (i == Song.check.size()-1) {
            Song.check.get(Song.check.size() - 1).setColor(Color.blue);

            if (Song.progress[song.getIndex()] <  m.getUser().size()* 100 / song.getLength())
              Song.progress[song.getIndex()] =  m.getUser().size() * 100 / song.getLength();
            // System.out.println(( m.getUser().size()) * 100 / song.getLength());
            // try {Thread.sleep(800);} catch(Exception e){}
            m.resetUser();
            wait = false;
            Song.check = new ArrayList<Key>();
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
    

      twoDGraph.drawImage(back, null, 0, 0);
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


