import java.io.File;
import java.util.ArrayList;

public class Note {
    
    private final char PITCH;
    private final char ACCIDENTAL;
    private final int OCTAVE;
    private final File SOUNDFILE;

    /**
     * Constructs a new {@code Note} object from a given note letter, accidental, and octave number. There are no enharmonics; all notes are written as naturals or sharps.
     * 
     * @param pitch         the note name as a single lowercase letter, without an accidental.
     * @param accidental    the accidental of the note: {@code n} for natural and {@code s} for sharp. There are no flats.
     * @param octave        the octave number of the note.
     */
    public Note(char pitch, char accidental, int octave) {
        PITCH = pitch;
        ACCIDENTAL = accidental;
        OCTAVE = octave;
        SOUNDFILE = new File("sounds\\" + this.toString() + ".mp3");
    }

    /**
     * Returns a list containing all of the notes on the chromatic scale from startNote to endNote, inclusive.
     * 
     * @param startNote the {@code Note} that the list begins on.
     * @param endNote   the {@code Note} that the list ends with.
     * @return          an {@code ArrayList} of {@code Note} objects from {@code startNote} to {@code endNote}.
     */
    public static ArrayList<Note> generateNotes(Note startNote, Note endNote) {
        ArrayList<Note> notes = new ArrayList<Note>();

        if (endNote.below(startNote)) {
            Note temp = startNote;
            startNote = endNote;
            endNote = temp;
        }

        Note currentNote = startNote;
        while (currentNote.below(endNote)) {
            notes.add(currentNote);
            currentNote = semitoneAbove(currentNote);
        }
        notes.add(endNote);

        return notes;
    }

    /**
     * Returns the note one semitone above a given note.
     * 
     * @param note  a {@code Note} object.
     * @return      a {@code Note} object representing the note located one half step above {@code note}.
     */
    public static Note semitoneAbove(Note note) {
        if (note.getPitch() == 'e')
            return new Note('f', 'n', note.getOctave());
        if (note.getPitch() == 'b')
            return new Note('c', 'n', note.getOctave() + 1);
        if (note.getPitch() == 'g' && note.getAccidental() == 's')
            return new Note('a', 'n', note.getOctave());
        else if (note.getAccidental() == 's')
            return new Note((char) (note.getPitch() + 1), 'n', note.getOctave());
        return new Note(note.getPitch(), 's', note.getOctave());
    }

    /**
     * Returns whether this note is lower than another specified note.
     * 
     * @param other the {@code Note} this object is being compared to.
     * @return      {@code true} if this object is lower than {@code other}; {@code false} otherwise.
     */
    public boolean below(Note other) {
        int pitch = PITCH;
        if (pitch < 99)
            pitch += 7;
        int oPitch = other.getPitch();
        if (oPitch < 99)
            oPitch += 7;
        return other.getOctave() > OCTAVE || (other.getOctave() == OCTAVE && oPitch > pitch) || (other.getOctave() == OCTAVE && oPitch == pitch && other.getAccidental() > ACCIDENTAL);
    }

    public char getPitch() {
        return PITCH;
    }

    public char getAccidental() {
        return ACCIDENTAL;
    }

    public int getOctave() {
        return OCTAVE;
    }

    public File getSoundFile() {
        return SOUNDFILE;
    }

    @Override
    public boolean equals(Object obj) {
        Note o = (Note) obj;
        return PITCH == o.getPitch() && ACCIDENTAL == o.getAccidental() && OCTAVE == getOctave();
    }

    @Override
    public String toString() {
        return "" + PITCH + ACCIDENTAL + Integer.toString(OCTAVE);
    }
}

