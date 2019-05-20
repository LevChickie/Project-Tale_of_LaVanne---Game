package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;


public class LoadPicture {
    private Image item;

    LoadPicture(String name)
    {
        String path = name+".png";
        item = new Image(LoadPicture.class.getResourceAsStream(path));

    }
    public Image getItem ()
    {
        return item;
    }
}
