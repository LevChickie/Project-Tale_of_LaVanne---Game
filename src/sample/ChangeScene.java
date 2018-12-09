package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChangeScene {
    String namePlace;
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
            default:
                return "";
        }
    }
    public Image changePlace() throws IOException {
        File newFile;
        BufferedImage bufferedImage;
        Image image;
        switch (namePlace) {
            case "city":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\city.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "tavern":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\tavern.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "castle":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\Castle.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "house 1":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\wrong house.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "house 2":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\wronghouse2.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "house 3":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\wrong house 3.png");
                 bufferedImage = ImageIO.read(newFile);
                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "merchant":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\Merc.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "slums":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\bergaendalSLUMs.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "thieves den":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\ThievesDen.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "library":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\gaelinslibrary.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "murder scene":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\murder_scene.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "aedirn":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\Aedirn.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "murderer":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\murderer.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            case "murderer (dead)":
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\DeadMurderer.png");
                bufferedImage = ImageIO.read(newFile);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            default:
                newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne correcting\\src\\sample\\city.png");
                 bufferedImage = ImageIO.read(newFile);
                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
        }
    }
}
