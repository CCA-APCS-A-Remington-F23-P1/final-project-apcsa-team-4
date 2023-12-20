import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;

public class Button implements Clickable {
    public static ArrayList<Button> buttons = new ArrayList<Button>();
    private String song;
    private Song mySong;
    private static int xVal = 152-120/2;
    private int xPos, yPos, width, height;
    private Color color;
    public Button() {
        song = "twinkle twinkle";
    }

    public Button(String songName) {
        song = songName;
        xPos = xVal;
        xVal += 152;
        yPos = 600;
        width = 120;
        height = width;
        color = Color.white;
        buttons.add(this);
        mySong = new Song(song);
    }

    public Button(String songName, int x, int y, int w, int h) {
        song = songName;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = Color.white;
        buttons.add(this);
        mySong = new Song(song);
    }

    @Override
    public boolean isClicked(MouseEvent e) {
        if (e.getX() >= xPos && e.getX() <= xPos + width && e.getY() >= yPos && e.getY() <= yPos + height)
        {
            return true;
        }
        return false;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setColorAll(Color c) {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setColor(c);
        }
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getSong() {
        return song;
    }

    public void draw(Graphics window) {
        window.setColor(Color.black);
        window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());

        window.setColor(color);
        window.fillRect(getXPos()+1,getYPos()+1,getWidth()-2,getHeight()-2);

        window.setColor(Color.black);
        window.drawString(song, getXPos() + 12, getYPos() + getHeight()/2-10);
        // System.out.println(song);
        // window.drawString("progress: " + Integer.toString(Song.progress[(new Song(song)).getIndex()]), getXPos() + 12, getYPos() + getHeight()/2+10); // TODO show progress
        window.drawString("progress: " + Integer.toString(Song.progress[mySong.getIndex()]) + "%", getXPos() + 12, getYPos() + getHeight()/2+10);
        // window.drawString(Integer.toString(Song.progress[mySong.getIndex()]), getXPos() + 12, getYPos() + getHeight()/2+10); // TODO show progress

    }
}
