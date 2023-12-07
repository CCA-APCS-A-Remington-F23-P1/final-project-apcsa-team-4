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
    whiteKeys = new ArrayList<Key>(1);
    blackKeys = new ArrayList<Key>(1);
  }

  public void add(Key k, String color)
  {
    if (color.equals("white")) {
      whiteKeys.add(k);
    }
    else if (color.equals("black")) {
      blackKeys.add(k);
    }
  }

  //post - draw each Ammo
  public void draw(Graphics window)
  {
    for (int i = 0; i < whiteKeys.size(); i++) {
      whiteKeys.get(i).draw(window);
    }
    for (int i = 0; i < blackKeys.size(); i++) {
      blackKeys.get(i).draw(window);
    }
  }
  
  // remove any Ammo which has reached the edge of the screen

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
