import java.awt.Color;

public class WhiteKey extends Key {

    public WhiteKey(Note NOTE) {
        super(NOTE);
        this.setWidth(52);
        this.setHeight(300);
        this.setColor(Color.WHITE);
    }

    public WhiteKey(Note NOTE, int x) {
        super(NOTE, x, 50, 300, Color.WHITE);
    }
}