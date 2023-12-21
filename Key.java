import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File; 
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 

public class Key implements Clickable {
    //instance vars
    private final Note NOTE;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;
    private Color ogColor;
    private boolean isClicked;
    private boolean compTurn;
    private Polygon key;

    //constructors
    public Key(Note NOTE) {
        this.NOTE = NOTE;
        isClicked = false;
        int[] xpoints = {0, 52, 0, 52};
        int[] ypoints = {0, 0, 300, 300};
        key = new Polygon(xpoints, ypoints, 4);
        compTurn = false;
    }

    public Key(Note NOTE, int x, int y, int w, int h, Color c) {
        this.NOTE = NOTE;
        xPos=x;
        yPos=y;
        width=w;
        height=h;
        color=c;
        ogColor = c;
        isClicked = false;
        int[] xpoints = {x, x+w, x, x+w};
        int[] ypoints = {y, y, y+h, y+h};
        key = new Polygon(xpoints, ypoints, 4);
        compTurn = false;
    }

    public Key(Note NOTE, int x, int w, int h, Color c) {
        this.NOTE = NOTE;
        xPos=x;
        width=w;
        height=h;
        color=c;
        ogColor = c;
        isClicked = false;
        int[] xpoints = {x, x+w, x, x+w};
        int[] ypoints = {0, 0, h, h};
        key = new Polygon(xpoints, ypoints, 4);
        compTurn = false;
    }

    //getters
    public Note getNote() {
        return NOTE;
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

    public Color getColor() {
        return color;
    }

    //setters
    public void setColor(Color col) {
        color = col;
    }

    public void setOGColor() {
        color = ogColor;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCompTurn(boolean b) {
        compTurn = b;
    }

    public boolean getIsClicked() {
        return isClicked;
    }
    
    //methods
    public void draw(Graphics window) {
        window.setColor(Color.black);
        window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());

        window.setColor(color);
        window.fillRect(getXPos()+1,getYPos()+1,getWidth()-2,getHeight()-2);
    }

    @Override
    public String toString() {
        return NOTE + " " + getXPos() + " " + getYPos() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }

    @Override
    public boolean isClicked(MouseEvent e) {
        if ((e.getX() >= xPos && e.getX() <= xPos + width && e.getY() >= yPos && e.getY() <= yPos + height) || compTurn == true)
        {
            SimpleAudioPlayer audioPlayer;
            try {
                audioPlayer = new SimpleAudioPlayer(getNote());
                audioPlayer.loop(0); 
                return true;
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            // TODO Auto-generated catch block
            event.printStackTrace();
          }
        }
        return false;
    }
}