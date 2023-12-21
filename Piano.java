// import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Piano
{
  private List<Key> keys;
  private List<WhiteKey> whiteKeys;
  private List<BlackKey> blackKeys;

  public Piano()
  {
    keys = new ArrayList<Key>();
    whiteKeys = new ArrayList<WhiteKey>();
    blackKeys = new ArrayList<BlackKey>();

    List<Note> notes = Note.generateNotes(new Note('c', 'n', 4), new Note('c', 'n', 7));

    int whiteX = 0;
    int blackX = 35;
    int bc = 0;
    for (Note n: notes) {
      if (n.getAccidental() == 110) {
        WhiteKey key = new WhiteKey(n, whiteX);
        keys.add(key);
        whiteKeys.add(key);
        whiteX += key.getWidth();
      } else if (n.getAccidental() == 115) {
        BlackKey key = new BlackKey(n, blackX);
        keys.add(key);
        blackKeys.add(key);
        blackX += 52;
        bc++;
        if (bc == 2) {
          blackX += 52;
        } else if (bc == 5) {
          blackX += 52;
          bc = 0;
        }
      }
    }
  }

  //post - draw each key
  public void draw(Graphics window)
  {
    for (int i = 0; i < whiteKeys.size(); i++) {
      whiteKeys.get(i).draw(window);
    }
    for (int i = 0; i < blackKeys.size(); i++) {
      blackKeys.get(i).draw(window);
    }
  }

  public void setOGColor() {
    for (Key k: keys) {
      k.setOGColor();
    }
  }
  public void setColor(Color c) {
    for (Key k: keys) {
      k.setColor(c);
    }
  }

  public List<WhiteKey> getWhiteList()
  {
    return whiteKeys;
  }
  public List<BlackKey> getBlackList()
  {
    return blackKeys;
  }

  public Key getKey(Note n)
  {
    for (Key ns: keys) {
      if (ns.getNote().equals(n)) {
        return ns;
      }
    }
    Key k = new Key(new Note('c', 'n', 4));
    return k;
  }

  public String toString()
  {
    return "";
  }


}
