package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChangeScene {
    private String namePlace;
    ChangeScene(String place)
    {
        namePlace=place;
    }
    public String changeName() {
        switch (namePlace) {
            case "city":
                return "Berg Aen Dal, city";
            case "tavern":
                return "Berg Aen Dal, tavern";
            case "castle":
                return "Berg Aen Dal, castle";
            case "house 1":
                return "Berg Aen Dal, house (1)";
            case "house 2":
                return "Berg Aen Dal, house (2)";
            case "house 3":
                return "Berg Aen Dal, house (3)";
            case "merchant":
                return "Berg Aen Dal, Merchant District";
            case "slums":
                return "Berg Aen Dal, slums";
            case "thieves den":
                return "Berg Aen Dal, thieves den";
            case "library":
                return "Berg Aen Dal, library";
            case "murder scene":
                return "Berg Aen Dal, murder scene";
            case "aedirn":
                return "Aedirn";
            case "murderer":
                return "Berg Aen Dal, house (4)";
            case "murderer (dead)":
                return "Berg Aen Dal, house (4)";
            case "murder scene (Xym dead)":
                return "murder scene (Xym dead)";
            default:
                return "";
        }
    }
    public Image changePlace()  {
                Image image;
                LoadPicture loading;
        switch (namePlace) {
            case "city":
                loading = new LoadPicture("city");
                image = loading.getItem();
                return image;
            case "tavern":
                loading = new LoadPicture("tavern");
                image = loading.getItem();
                return image;
            case "castle":
                loading = new LoadPicture("Castle");
                image = loading.getItem();
                return image;
            case "house 1":
                loading = new LoadPicture("wrong house");
                image = loading.getItem();
                return image;
            case "house 2":
                loading = new LoadPicture("wronghouse2");
                image = loading.getItem();
                return image;
            case "house 3":
                loading = new LoadPicture("wrong house 3");
                image = loading.getItem();
                return image;
            case "merchant":
                loading = new LoadPicture("Merc");
                image = loading.getItem();
                return image;
            case "slums":
                loading = new LoadPicture("bergaendalSLUMs");
                image = loading.getItem();
                return image;
            case "thieves den":
                loading = new LoadPicture("ThievesDen");
                image = loading.getItem();
                return image;
            case "library":
                loading = new LoadPicture("gaelinslibrary");
                image = loading.getItem();
                return image;
            case "murder scene":
                loading = new LoadPicture("murder_scene");
                image = loading.getItem();
                return image;
            case "aedirn":
                loading = new LoadPicture("Aedirn");
                image = loading.getItem();
                return image;
            case "murderer":
                loading = new LoadPicture("murderer");
                image = loading.getItem();
                return image;
            case "murderer (dead)":
                loading = new LoadPicture("deadmurd");
                image = loading.getItem();
                return image;
            case "murder scene (Xym dead)":
                loading = new LoadPicture("xymdead");
                image = loading.getItem();
                return image;
            default:
                loading = new LoadPicture("city");
                image = loading.getItem();
                return image;
        }
    }
}
