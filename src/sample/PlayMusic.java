package sample;

import javafx.scene.media.AudioClip;

public class PlayMusic {
    AudioClip audio;
    String pathToMusic;
    PlayMusic(String nameOfMusic)
    {
        pathToMusic=nameOfMusic+".wav";
        audio = new AudioClip(this.getClass().getResource(pathToMusic).toString());
    }
    public void play()
    {
        audio.play();
    }
    public void stop(){audio.stop();}
}
