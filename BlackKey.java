import java.awt.Color;

public class BlackKey extends Key {

    public BlackKey(Note NOTE) {
        super(NOTE);
        this.setWidth(25);
        this.setHeight(125);
        this.setColor(Color.BLACK);
    }

    public BlackKey(Note NOTE, int y) {
        super(NOTE, y, 50, 300, Color.BLACK);
    }
}