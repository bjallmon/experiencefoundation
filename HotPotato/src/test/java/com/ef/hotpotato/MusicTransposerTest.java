package com.ef.hotpotato;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MusicTransposerTest {

    public static List<String> NOTES = Arrays.asList(
            "C", "C#", "D", "D#", "E",
            "F", "G", "G#", "A", "A#", "B"
    );

    @Test
    public void transposeForwardFromKeyOfBToC() {
        List<String> newChords = MusicTransposer.transpose("B", "C", NOTES);
        assertEquals("C#", newChords.get(0));
        assertEquals("D", newChords.get(1));
        assertEquals("D#", newChords.get(2));
        assertEquals("E", newChords.get(3));
        assertEquals("F", newChords.get(4));
        assertEquals("F#", newChords.get(5));
        assertEquals("G#", newChords.get(6));
        assertEquals("A", newChords.get(7));
        assertEquals("A#", newChords.get(8));
        assertEquals("B", newChords.get(9));
        assertEquals("C", newChords.get(10));
    }

    @Test
    public void transposeBackwardFromKeyOfCToB() {
        List<String> newChords = MusicTransposer.transpose("C", "B", NOTES);
        assertEquals("B", newChords.get(0));
        assertEquals("C", newChords.get(1));
        assertEquals("C#", newChords.get(2));
        assertEquals("D", newChords.get(3));
        assertEquals("D#", newChords.get(4));
        assertEquals("E", newChords.get(5));
        assertEquals("F#", newChords.get(6));
        assertEquals("G", newChords.get(7));
        assertEquals("G#", newChords.get(8));
        assertEquals("A", newChords.get(9));
        assertEquals("A#", newChords.get(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionWhenOriginalKeyIsBad() {
        MusicTransposer.transpose("BAD", "C", NOTES);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionWhenNewKeyIsBad() {
        MusicTransposer.transpose("B", "BAD", NOTES);
    }

    @Test
    public void transposeMusicFromBToC() {
        String musicToTranspose = makeMusicToTranspose().toString();
        String result = MusicTransposer.transposeMusic(musicToTranspose, "B", "C");
        assertEquals(makeExpectedTransposedMusic(), result.toString());
    }

    private StringBuilder makeMusicToTranspose() {
        StringBuilder music = new StringBuilder();
        music.append("G     B       C    D    F#\n");
        music.append("TEXT  BLAH YAY  HELLO   GOOD BYE!\n");
        music.append("C     A       F    E    D#\n");
        music.append("MORE TEXT  BLAH YAY  HELLO   HELLO HELLO!\n");
        System.out.println(music.toString());
        return music;
    }

    private StringBuilder makeExpectedTransposedMusic() {
        StringBuilder music = new StringBuilder();
        music.append("G#     C       C#    D#    G\n");
        music.append("TEXT  BLAH YAY  HELLO   GOOD BYE!\n");
        music.append("C#     A#       F#    F    E\n");
        music.append("MORE TEXT  BLAH YAY  HELLO   HELLO HELLO!\n");
        return music;
    }

}
