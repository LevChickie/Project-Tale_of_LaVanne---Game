package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayMusicTest {

    @Test
    public void play() {
        PlayMusic playing = new PlayMusic("theme");
        playing.play();
        assertTrue(playing.audio.isPlaying());
    }
}