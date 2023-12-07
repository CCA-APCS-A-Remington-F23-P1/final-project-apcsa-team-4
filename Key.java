import java.awt.Color;
import java.awt.Graphics;

public class Key {
    //instance vars
    private final Note NOTE;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;
    //check

    //constructors
    public Key(Note NOTE) {
        this.NOTE = NOTE;
    }

    public Key(Note NOTE, int x, int y, int w, int h, Color c) {
        this.NOTE = NOTE;
        xPos=x;
        yPos=y;
        width=w;
        height=h;
        color=c;
    }

    public Key(Note NOTE, int y, int w, int h, Color c) {
        this.NOTE = NOTE;
        yPos=y;
        width=w;
        height=h;
        color=c;
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
    
    //methods
    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
    }

    @Override
    public String toString() {
        return NOTE + " " + getXPos() + " " + getYPos() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }
}