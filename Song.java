import java.util.*;

public class Song {
    private ArrayList<Note> song;
    private static String[] songs = {"twinkle twinkle", "row your boat", "itsy bitsy spider"};

    public Song() {
        setSong("twinkle twinkle");
    }

    public Song(String s) {
        setSong(s);
    }

    public void setSong(String s) {
        if (s.equals("twinkle twinkle")) {
            song.add(new Note('c', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('f', 'n', 4));
            song.add(new Note('f', 'n', 4));
            song.add(new Note('e', 'n', 4));
            song.add(new Note('e', 'n', 4));
            song.add(new Note('d', 'n', 4));
            song.add(new Note('d', 'n', 4));
            song.add(new Note('c', 'n', 4));
        }
        
    }
}