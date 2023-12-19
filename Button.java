import java.awt.event.MouseEvent;
import java.awt.*;

public class Button implements Clickable {
    private String song;
    private static int xVal = 152-120/2;
    private int xPos, yPos, width, height;
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
    }

    public Button(String songName, int x, int y, int w, int h) {
        song = songName;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    @Override
    public boolean isClicked(MouseEvent e) {
        
        return false;
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

    public void draw(Graphics window) {
        window.setColor(Color.black);
        window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());

        window.setColor(Color.white);
        window.fillRect(getXPos()+1,getYPos()+1,getWidth()-2,getHeight()-2);

        window.setColor(Color.black);
        window.drawString(song, getXPos() + 12, getYPos() + getHeight()/2);
    }
}
