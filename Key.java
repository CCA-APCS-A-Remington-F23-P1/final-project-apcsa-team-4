import java.awt.Color;
import java.awt.Graphics;

public class Key implements Clickable {
    //instance vars
    private final Note NOTE;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

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

    public Key(Note NOTE, int x, int w, int h, Color c) {
        this.NOTE = NOTE;
        xPos=x;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
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
}