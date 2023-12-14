// import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Image;
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

    List<Note> notes = Note.generateNotes(new Note('c', 'n', 4), new Note('c', 'n', 6));

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
          blackX += 2 * 52;
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

  public List<WhiteKey> getWhiteList()
  {
    return whiteKeys;
  }
  public List<BlackKey> getBlackList()
  {
    return blackKeys;
  }

  public String toString()
  {
    return "";
  }
}
