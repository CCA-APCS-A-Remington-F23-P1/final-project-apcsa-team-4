import java.util.*;

public class Tester {
    
    public static void main(String[] args) {
        Note c4 = new Note('c', 'n', 4);
        System.out.println(c4.getOctave());
        System.out.println(c4.toString() + "\n");
        Note gs5 = new Note('g', 's', 5);
        ArrayList<Note> scale = Note.generateNotes(c4, gs5);
        // System.out.println(c4.below(gs5));
        for (Note n: scale)
            System.out.println(n);
    }
}