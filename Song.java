import java.util.*;

public class Song {
    private ArrayList<Note> song;
    private static String[] songs = {"twinkle twinkle", "old mcdonald", "happy birthday", "hot cross buns"};
    private String songName;
    public static ArrayList<Key> check;
    private static double[] progress;

    public Song() {
        setSong("twinkle twinkle");
        songName = "twinkle twinkle";
        check = new ArrayList<Key>();
    }

    public Song(String s) {
        setSong(s);
        songName = s;
        check = new ArrayList<Key>();
    }

    public String getSongName() {
        return songName;
    }

    public static void addCheck(Key k) {
        check.add(k);
    } 

    public static void resetCheck() {
        check = new ArrayList<Key>();
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
        if (s.equals("old mcdonald")) {
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