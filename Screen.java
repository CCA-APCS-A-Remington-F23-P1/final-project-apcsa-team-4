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
import java.util.*;
import java.time.*;
import java.awt.Font;
import java.io.*;

import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;  

public class Screen extends Canvas implements Runnable
{
  private BufferedImage back;
  private Piano piano;
  private static Song song;
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
  private boolean isDone;

  public Screen()
  {
    setBackground(Color.white);

    piano = new Piano();
    song = new Song();
    wait = false;
    fail = false;
    counti = 0;
    isDone = false;
    countj = 0;

    b1 = new Button("twinkle twinkle");
    b1.setColor(Color.green);
    b2 = new Button("hot cross buns");
    b3 = new Button("old mcdonald");
    b4 = new Button("happy birthday");

    new Thread(this).start();

    try {
      File file = new File("save.txt");
      Scanner sc = new Scanner(file);
      for (int i = 0; i < 4; i++) {
        Song.progress[i] = Integer.parseInt(sc.next());
      }
      song = new Song(sc.next());
      sc.close();

    }
    catch (FileNotFoundException e) {}
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
    if (Song.isDone()) {
      isDone = true;
    }
    if (!isDone) {
    
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

    
      if (Song.progress[song.getIndex()] == 100) {
        song = new Song(Song.songs[song.getIndex()+1]);
        m.setSong(song);
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
            SimpleAudioPlayer audioPlayer;
          try {
            audioPlayer = new SimpleAudioPlayer(song.getSong().get(countj));
            audioPlayer.loop(0); 
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
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
        SimpleAudioPlayer audioPlayer;
          try {
            audioPlayer = new SimpleAudioPlayer(song.getSong().get(countj));
            audioPlayer.loop(0); 
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        piano.setColor(Color.red);
      }
    }
    else {
      graphToBack.setColor(Color.gray);

      graphToBack.fillRect(0,0,780,1200);
      graphToBack.setColor(Color.black);
      graphToBack.setFont(new Font("MS Mincho",Font.PLAIN, 53));
      graphToBack.drawString("You are Done!!", 50, 400);
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

  public static void save() {
    try {
      File myObj = new File("save.txt"); 
      if (myObj.delete()) { 
        System.out.println("Deleted the file: " + myObj.getName());
      } else {
        System.out.println("Failed to delete the file.");
      } 
      File file = new File("save.txt");
      FileWriter myWriter = new FileWriter("save.txt");
      file.createNewFile();
      for (int i = 0; i < 4; i++) {
        myWriter.write(Integer.toString(Song.progress[i]) + "\n");
      }
      myWriter.write(song.getSongName());
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}



