public class Note {
    
    private final String PITCH;
    private final String ACCIDENTAL;
    private final int OCTAVE;

    public Note(String PITCH, String ACCIDENTAL) {
        this(PITCH, ACCIDENTAL, 3);
    }

    public Note(String PITCH, String ACCIDENTAL, int OCTAVE) {
        this.PITCH = PITCH;
        this.ACCIDENTAL = ACCIDENTAL;
        this.OCTAVE = OCTAVE;
    }

    public String getPitch() {
        return PITCH;
    }

    public String getAccidental() {
        return ACCIDENTAL;
    }

    public int getOctave() {
        return OCTAVE;
    }
}