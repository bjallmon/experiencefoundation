package com.ef.hotpotato;

import java.util.ArrayList;
import java.util.List;

public class MusicTransposer {

    public static final String[] NATURAL_NOTES = new String[]{
            "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public static String transposeMusic(final String music, final String originalKey, final String newKey) {

        return music;
    }

    public static List<String> transpose(final String originalKey, final String newKey, final List<String> chords) {
        int originalKeyIndex = retrieveKeyIndex(originalKey);
        int newKeyIndex = retrieveKeyIndex(newKey);
        int halfSteps = (newKeyIndex + NATURAL_NOTES.length) - originalKeyIndex;

        return retrieveTransposedChords(chords, halfSteps);
    }

    private static List<String> retrieveTransposedChords(List<String> chords, int halfSteps) {
        List<String> newChords = new ArrayList<String>();
        for (String oldChord : chords) {
            for (int i = 0; i < NATURAL_NOTES.length; i++) {
                int newChordIndex;
                if (oldChord == NATURAL_NOTES[i]) {
                    int chordValue = i;
                    newChordIndex = (chordValue + halfSteps) % NATURAL_NOTES.length;
                    String newChord = NATURAL_NOTES[newChordIndex];
                    newChords.add(newChord);
                    System.out.println("\nThe original Chord, " + oldChord + ", has been transposed to " + newChord);
                }
            }
        }

        return newChords;
    }

    private static int retrieveKeyIndex(final String key) {
        for (int i = 0; i < NATURAL_NOTES.length; i++) {
            if (NATURAL_NOTES[i] == key) {
                return i;
            }
        }
        throw new IllegalArgumentException("Key not found.");
    }

}
