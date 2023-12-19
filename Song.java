import java.util.*;

public class Song {
    private ArrayList<Note> song;
    private static String[] songs = {"twinkle twinkle", "old macdonald", "happy birthday", "hot cross buns", "row your boat", "itsy bitsy spider"};

    public Song() {
        setSong("twinkle twinkle");
    }

    public Song(String s) {
        setSong(s);
    }

    public void setSong(String s) {
        song = new ArrayList<Note>(0);
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
        if (s.equals("old macdonald")) {
            song.add(new Note('c', 'n', 5));
            song.add(new Note('c', 'n', 5));
            song.add(new Note('c', 'n', 5));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('e', 'n', 5));
            song.add(new Note('e', 'n', 5));
            song.add(new Note('d', 'n', 5));
            song.add(new Note('d', 'n', 5));
            song.add(new Note('c', 'n', 5));
        }
        if (s.equals("happy birthday")) {
            song.add(new Note('c', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('d', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('f', 'n', 4));
            song.add(new Note('e', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('d', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('f', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('c', 'n', 4));
            song.add(new Note('c', 'n', 5));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('e', 'n', 4));
            song.add(new Note('d', 'n', 4));
            song.add(new Note('a', 's', 4));
            song.add(new Note('a', 's', 4));
            song.add(new Note('a', 'n', 4));
            song.add(new Note('f', 'n', 4));
            song.add(new Note('g', 'n', 4));
            song.add(new Note('f', 'n', 4));
        }
        if (s.equals("hot cross buns")) {
            song.add(new Note('b', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('b', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('g', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('b', 'n', 5));
            song.add(new Note('a', 'n', 5));
            song.add(new Note('g', 'n', 5));
        }
        
    }

    public ArrayList<Note> getSong() {
        return song;
    }
}