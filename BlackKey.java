import java.awt.Color;

public class BlackKey extends Key {

    public BlackKey(Note NOTE) {
        super(NOTE);
        this.setWidth(34);
        this.setHeight(150);
        this.setColor(Color.BLACK);
    }

    public BlackKey(Note NOTE, int x) {
        super(NOTE, x, 34, 150, Color.BLACK);
    }
}