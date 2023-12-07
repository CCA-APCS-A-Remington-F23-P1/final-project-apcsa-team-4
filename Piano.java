// import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Piano
{
  private List<Key> whiteKeys;
  private List<Key> blackKeys;

  public Piano()
  {
    whiteKeys = new ArrayList<Key>(15);
    blackKeys = new ArrayList<Key>(10);
    char[] naturalKeys = {'c', 'd', 'e', 'f', 'g', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'a', 'b', 'c'};

    char[] sharpKeys = {'c', 'd', 'f', 'g', 'a', 'c', 'd', 'f', 'g', 'a'};
    int count = 0;

    int octave = 4;

    for (int i = 0; i < whiteKeys.size(); i++) {
      if (count == 6)
        octave = 5;
      if (count == 14)
        octave = 6;
      whiteKeys.set(i, new WhiteKey(new Note(naturalKeys[i], 'n', octave)));
      count++;
    }

    octave = 4;
    count = 0;

    for (int i = 0; i < blackKeys.size(); i++) {
      if (count == 4)
        octave++;
      blackKeys.set(i, new BlackKey(new Note(sharpKeys[i], 's', octave)));
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

  public List<Key> getWhiteList()
  {
    return whiteKeys;
  }
  public List<Key> getBlackList()
  {
    return blackKeys;
  }

  public String toString()
  {
    return "";
  }
}
