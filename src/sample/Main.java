package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("City.fxml"));
        primaryStage.setTitle("Tale Of LaVanne");
        primaryStage.setScene(new Scene(root, 1280, 720));
      //  primaryStage.setFullScreen(true);
        primaryStage.show();
       AudioClip audio = new AudioClip(this.getClass().getResource("City.wav").toString());
       audio.setVolume(0.25);
       audio.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
