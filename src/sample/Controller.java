package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Controller {


    //VARIABLES
    public TextField responseContainerA;
    public TextField responseContainerB;
    public TextField responseContainerC;
    public TextArea dialogueContainer;
    public TextArea ToDoList;
    public TextArea Inventory;
    public TextField nameOfPartner;
    public TextField Location;

    AudioClip audio1;

    boolean end_conversation;
    boolean activeChat = false;

    public Button talkCaerme = new Button("talk: Cáermé");
    public Button talkOrell = new Button("talk: Orell");
    public Button talkBartender = new Button("talk: Bartender");
    public Button talkThug = new Button("talk: Thug");
    public Button talkChepard = new Button("talk: Chepard");
    public Button pickUpSilver = new Button("talk: Pick up Silver");
    public Button pickUpAnotherSilver = new Button("talk: Pick up Silver");
    public Button pickUpJewellery = new Button("talk: Steal Jewellery");
    public Button buyBeer = new Button("talk: Buy a beer");
    public Button talkBardolf = new Button("talk: Bardolf");
    public Button talkEloise = new Button("talk: Eloise");
    public Button talkFicsur = new Button("talk: Ficsur");
    public Button talkGaelin = new Button("talk: Gaelin");
    public Button talkKathrin = new Button("talk: Kathrin");
    public Button talkLuna = new Button("talk: Luna");
    public Button talkGuard =new Button("talk: Guard");

    public Button enterTavern = new Button("Enter Tavern");
    public Button enterCastle = new Button("Enter Castle");
    public Button enterThievesDen = new Button("Enter Thieves Den");
    public Button returnCity = new Button("Return to City");
    public Button goToMerchantDistrict = new Button("Enter Merchant District");
    public Button enterMurderScene = new Button("Go to murder scene");
    public Button enterLibrary = new Button("Enter Library");

    int numberOfCurrentIndex;

    public ImageView playGroundImageView;
    public ImageView heroView;
    public ImageView speechPartnerView;

    public int round;

    String response;
    String textFieldArea;
    String activeTasks;
    String[] dialogue;
    String[] dialogueCaerme = {"I have a problem, there was a murder.\n We cought each suspects in time, but we are needed elsewhere.\n You seem like some'one, who could handle it.\n We pay in gold, if you're up to the task\"",
            "Who was murdered?", "How lovely, the little elf lass needs some help. Gladly. (Get task.)(End conversation)", "I don't have the time. Bye! (End conversation.)", "A girl called Lilith. She was left in cold blood. Poor girl...", "I will help you find her killer! (Get task. End conversation.)", "I see. I want to ask something else", "Nope, not interested. (End conversation.)"};
    String[] dialogueOrell = {"Bastien. I am not surprised. Where the problem, you're around.", "Just like you and your friends.", "Greetings as well, witcher.", "Yeah, sure. Don't care (End conversation.)", "But we want to solve them, but you seems to make the troubles.", "That makes us two. But I also solve them. For gold. (End conversation.)", "You are so untrustful, I have to laugh (End conversation.)", "I won't waste my time on you, witcher. (End conversation.)", "What brought you here?", "I was sent by Ragwald, he said you need the man.(End conversation.)", "That bold guy in Branburg paid me. (End conversation.)", "Just came by. (End conversation.)", "I told you Cáermé. We can't trust him with this task. I will solve it."};
    String[] dialogueBartender = {"Hello there. You are with the lady and the guy? They are watching you since you arrived.", "Yes, I fought with them.", "Yes, I had... some good time with the lass", "Nope. (End conversation.)", "Really? What? Where?", "We occupied the fortress of Titus de Achtenberg.", "Gimme a beer. (End conversation.)", "Why do you care? (End conversation.)", "She's... sorry, sir... I didn't mean to...", "It was like fighting a dragon. Fervid and long (End conversation.)", "Gimme a beer (End conversation.)", "Yeah. (End conversation.)", "Wow... that's something. But they say the Dracheturm family stormed the fort.","They merely entered the empty fortress. We slayed the guards. (End conversation)","What a surprise... (End conversation)", "I would like to ask something else."};
    String[] dialogueBardolf = {"Who are you, halfhand?", "I am Sebastien LaVanne, Lord Alain. I'm here to ask about the murder.","I'm the guy, who solve your problems for coin.","I am just looking around. (End conversation.)","LaVanne? Isn't it a southern family?", "I came from Toussaint, sir", "Indeed, it is.", "I'm leaving. (End conversation)","A mercenary eh? All right. What do you need?", "I have to speak with your daughter, sir","I "};
    String[] dialogueEloise = {"Hello there", "hello (End conversation)", "bye (End conversation)", "you pretty... (End conversation)"};
    String[] dialogueChepard = {"Is something wrong? What can I help you, mercenary?", "I wonder if you have some job for a veteran sword-wielder, or not.", "I must speak with the lord. (End conversation)", "Goodbye. (End conversation)","You are lucky! We need someone to find the hideout of the bandits in the slums. You look someone who could handle this problem.","Yes, I am honored to do that task for you (Get task) (End conversation", "I want to speak about something else.", "Not interested (End conversation)"};
    String[] dialogueThug = {"He! Who ar you! It is private quarter. Whattadoyou want?", "Me? Just want a well paid job, if you know what I mean.", "I search for the murderer of that girl", "Okay. I shall leave. (End Conversation)","Really? We have a decent job! But first, you shall defeat Ficsur","Sounds like a good job. (Get task) (End conversation)", "I want to ask about something else","Not interested (End conversation)", "I would like to help you. But as you can see, we have other things to do.", "What about the blood on the floor, under the barrels? (End conversation)", "Okay. I want to ask about something else.","Than I shall leave (End conversation)" };
    String[] dialogueFicsurTask= {"You are the new guy eh? Let's see what are you made of, halfman!","I beat you with one hand. (End conversation) (Fight Ficsur)", "Let's roll! (End conversation) (Fight Ficsur)","I am not ready yet. (End conversation)"};
    String[] dialogueFicsurNoTask= {"Who the fuck are you? Get lost before I mess you up like a... Mess.","Thank you kindly. (End conversation)","Fuck you too. (End conversation","Ahemm... (End conversation)"};
    String[] dialogueGaelin = {"Greetings. How can be at your assistance?","I want to know the details of the murder","I shall leave (End conversation)","Bye (End conversation)","All we know, that it was...","Thanks (End conversation)","I would like to ask something else","Bye(End conversation)"};
    String[] dialogueLuna = {"Hi! My name is Luna. What can I do for you?","End conversation","I think you could help me... (End conversation)","End conversation"};
    String[] dialogueKathrin = {"Hello","End conversation","End conversation","End conversation"};
    String[] dialogueGuard = {"Move along citizen!","End conversation","End conversation","End conversation"};

    //MAIN MENU
    public void loadGame()
    {
        try {
            FileInputStream inPut= new FileInputStream("saveGame");
            ObjectInputStream objectOut = new ObjectInputStream(inPut);
            String loadGame=(String)objectOut.readObject();
            inPut.close();
            String[] data = loadGame.split("@");
            Inventory.setText(data[0]);
            ToDoList.setText(data[1]);
            Location.setText(data[2]);
            if(Location.getText().contains("tavern"))
            {
                enterTavern.fire();
            }
            else if(Location.getText().contains("castle"))
            {
                enterCastle.fire();
            }
            else if(Location.getText().contains("thieves den"))
            {
                enterThievesDen.fire();
            }
            else if(Location.getText().contains("city"))
            {
                returnCity.fire();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveGame()
    {
        try {
            FileOutputStream outPut= new FileOutputStream("saveGame");
            ObjectOutputStream objectOut = new ObjectOutputStream(outPut);
            String savedGame= Inventory.getText()+"@"+ToDoList.getText()+"@"+ Location.getText();
            objectOut.writeObject(savedGame);
            outPut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //EXIT from game
    public void clickOnExit() {
        System.exit(0);
    }


    //MAPPING

    //CHARACTER INTERACTION
    public void clickOnPerson() {
        if (nameOfPartner.getText().contains("Cáermé")) {
            dialogueContainer.setText("\"That elven girl has moved my fantasy for sometime. They say she is as furious in battle, as in the bed... \"");
        }
        else if(nameOfPartner.getText().contains("Orell, the Witcher"))
        {
            dialogueContainer.setText("\"Orell... The always suspicious witcher never liked me. He is one of the key members of the Company of Courageous.\n Great warrior, I have to admit.\n They say he even fought in the Battle of Sodden Hill.\"");
        }
        else if(nameOfPartner.getText().contains("Borisz, the bartender"))
        {
            dialogueContainer.setText("\"I just wonder, why every single bartender called Borisz.\"");
        }
        else if(nameOfPartner.getText().contains("Eloise Alain"))
        {
            dialogueContainer.setText("\"Fiery girl... I have to admit. But some kind of magic smells around her. Better watch out.\"");
        }
        else if(nameOfPartner.getText().contains("Bardolf Alain"))
        {
            dialogueContainer.setText("\"Lord of Berg Aen Dal, the ambitious ruler of this region. I wonder if he needs sellswords...\"");
        }
        else if(nameOfPartner.getText().contains("Doris"))
        {
            dialogueContainer.setText("\"An idiot lowlife... On the otherside, I could work for him for some serious gold....\"");
        }
        else if(nameOfPartner.getText().contains("Ficsur"))
        {

        }
    }
    public void clickOnBastien() {
        audio1 = new AudioClip(this.getClass().getResource("ArthasPissed6.wav").toString());
        audio1.play();
        dialogueContainer.setText("\"I fought in the war against Nilfgaard alongside the northern kingdoms with my band of sellswords.\n In the battle of Marnadal one bastards chopped my right hand off. \n They look at me like a degenerated since... Luckily I my left is my better hand...\n I showed that a year later in the battle of Sodden, where we demolished the lines of the southern dogs.\"");
    }

    public void changeImageOnPushForOrell() {
        try {
            nameOfPartner.setText("Orell, the Witcher");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\Orell.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeImageOnPushForBartender() {
        try {
            nameOfPartner.setText("Borisz, the bartender");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\bartender.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeImageOnPushForCaerme() {
        try {
            nameOfPartner.setText("Cáermé");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\Aenyelle.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeImageOnPushForEloise() {
        try {
            nameOfPartner.setText("Eloise Alain");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\Eloise Bardolf.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForBardolf() {
        try {
            nameOfPartner.setText("Bardolf Alain");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\Bardolf Alain.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForChepard() {
        try {
            nameOfPartner.setText("Sommander Chepard");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\sommander Chepard.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForThug() {
        try {
            nameOfPartner.setText("Doris");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\Doris.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForFicsur() {
        try {
            nameOfPartner.setText("Ficsur");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sampleficsur.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForGuard() {
        try {
            nameOfPartner.setText("Berg Aen Dal Guard");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\guard.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForGaelin()
    {
        try {
            nameOfPartner.setText("Orell, the Witcher");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\gaelin.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForLuna()
    {
        try {
            nameOfPartner.setText("Luna");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\luna.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeImageOnPushForKathrin()
    {
        try {
            nameOfPartner.setText("Kathrin");
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\kathrin.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            speechPartnerView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //MAPPING
    public void setEnterTavern() {
        try {
            playGroundImageView.setScaleY(1.12);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(30);
            playGroundImageView.setX(-1);

            talkCaerme.setVisible(true);
            talkOrell.setVisible(true);
            talkBartender.setVisible(true);
            buyBeer.setVisible(true);
            returnCity.setVisible(true);
            pickUpAnotherSilver.setVisible(true);


            pickUpJewellery.setVisible(false);
            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            talkThug.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            talkGuard.setVisible(false);

            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);



            Location.setText("Berg Aen Dal, tavern");

            audio1 = new AudioClip(this.getClass().getResource("ValeeraBase_Pissed04 (1).wav").toString());
            audio1.play();
            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\tavern.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setReturnCity() {
        try {
            playGroundImageView.setScaleY(1.28);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(60);
            playGroundImageView.setX(-1);

            enterCastle.setVisible(true);
            enterTavern.setVisible(true);
            enterThievesDen.setVisible(true);
            goToMerchantDistrict.setVisible(true);

            pickUpAnotherSilver.setVisible(false);
            pickUpJewellery.setVisible(false);
            pickUpSilver.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            buyBeer.setVisible(false);
            returnCity.setVisible(false);
            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            talkThug.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            talkGuard.setVisible(false);

            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);

            Location.setText("Berg Aen Dal, city");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\city.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setEnterCastle() {
        try {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1.02);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(10);
            playGroundImageView.setX(10);

            returnCity.setVisible(true);
            pickUpSilver.setVisible(true);
            talkBardolf.setVisible(true);
            talkChepard.setVisible(true);
            talkEloise.setVisible(true);
            pickUpSilver.setVisible(true);
            pickUpJewellery.setVisible(true);

            pickUpAnotherSilver.setVisible(false);
            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            talkGuard.setVisible(false);
            talkThug.setVisible(false);
            buyBeer.setVisible(false);

            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);

            Location.setText("Berg Aen Dal, castle");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\Castle.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setEnterThievesDen() {
        try {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1.02);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(10);
            playGroundImageView.setX(10);

            talkThug.setVisible(true);
            returnCity.setVisible(true);

            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            talkGuard.setVisible(false);
            buyBeer.setVisible(false);
            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);


            Location.setText("Berg Aen Dal, thieves den");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\homework_Java\\src\\sample\\ThievesDen.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void goMerchantDistrict() {
        try {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1.05);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(30);

            returnCity.setVisible(true);
            enterLibrary.setVisible(true);
            enterMurderScene.setVisible(true);

            pickUpAnotherSilver.setVisible(false);
            pickUpJewellery.setVisible(false);
            pickUpSilver.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            buyBeer.setVisible(false);
            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            talkThug.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            talkGuard.setVisible(false);

            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            Location.setText("Berg Aen Dal, Merchant District");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\Merc.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setGoToMurderScene() {
        try {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            talkGuard.setVisible(true);


            pickUpAnotherSilver.setVisible(false);
            pickUpJewellery.setVisible(false);
            pickUpSilver.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            buyBeer.setVisible(false);
            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            talkThug.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);


            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            Location.setText("Berg Aen Dal, murder scene");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\murder_scene.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setEnterLibrary() {
        try {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            talkGaelin.setVisible(true);
            talkLuna.setVisible(true);
            talkKathrin.setVisible(true);


            pickUpAnotherSilver.setVisible(false);
            pickUpJewellery.setVisible(false);
            pickUpSilver.setVisible(false);
            talkCaerme.setVisible(false);
            talkOrell.setVisible(false);
            talkBartender.setVisible(false);
            buyBeer.setVisible(false);
            pickUpSilver.setVisible(false);
            talkBardolf.setVisible(false);
            talkChepard.setVisible(false);
            talkEloise.setVisible(false);
            talkThug.setVisible(false);
            talkGuard.setVisible(false);

            enterCastle.setVisible(false);
            enterTavern.setVisible(false);
            enterThievesDen.setVisible(false);
            goToMerchantDistrict.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);

            Location.setText("Berg Aen Dal, library");

            File newFile = new File("C:\\Users\\MrGamble\\IdeaProjects\\Tale of LaVanne\\src\\sample\\gaelinslibrary.png");
            BufferedImage bufferedImage = ImageIO.read(newFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            playGroundImageView.setImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //INVETORY MANIPULATION
    public void pickUpSilverCastle() {
        String inventory = Inventory.getText();
        inventory += "\nSilver";
        pickUpSilver.setVisible(false);
        Inventory.setText(inventory);
    }
    public void pickUpSilverTavern() {
        String inventory = Inventory.getText();
        inventory += "\nSilver";
        pickUpAnotherSilver.setVisible(false);
        Inventory.setText(inventory);
    }
    public void pickUpJewellery() {
        String inventory = Inventory.getText();
        inventory += "\nGolden Amulet with sapphire stone";
        pickUpJewellery.setVisible(false);
        Inventory.setText(inventory);
    }
    public void loseSilver() {
        String inventory = Inventory.getText();
        String parts = "";
        int length;
        ArrayList<String> inventoryList = new ArrayList<>();
        for (length = 0; length < inventory.length(); length++) {
            if (inventory.charAt(length) == '\n') {
                inventoryList.add(parts);
                parts = "";
            } else {
                parts += inventory.charAt(length);
            }
        }

        if (inventoryList.contains("Silver")) {
            inventoryList.remove("Silver");
        }
        inventory = "";
        for (length = 0; length < inventoryList.size(); length++) {
            inventory += inventoryList.get(length);
            if (length != inventoryList.size() - 1) {
                inventory += "\n";
            }
        }
        Inventory.setText(inventory);
        return;
    }


    public void greetingMonologueCaerme() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        audio1 = new AudioClip(this.getClass().getResource("ValeeraBase_UI_Purchase00 (1).wav").toString());
        audio1.play();
        changeImageOnPushForCaerme();
        activeChat = true;
        dialogue = dialogueCaerme;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "\"LaVanne!\n" +
                "I should have known that our paths will cross each other once again.\n";
        Dialogue();
    }

    public void greetingMonologueOrell() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        audio1 = new AudioClip(this.getClass().getResource("UtherWhat1.wav").toString());
        audio1.play();
        changeImageOnPushForOrell();
        activeChat = true;
        dialogue = dialogueOrell;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "Greetings, mercenary.\n";
        Dialogue();
    }

    public void greetingMonologueBartender() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForBartender();
        activeChat = true;
        dialogue = dialogueBartender;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "Greetings, good Sir, what can I help you with?\n";
        Dialogue();
    }

    public void greetingMonologueEloise() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForEloise();
        activeChat = true;
        dialogue = dialogueEloise;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "But who are you?";
        Dialogue();
    }

    public void greetingMonologueBardolf() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForBardolf();
        activeChat = true;
        dialogue = dialogueBardolf;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "Who are you?";
        Dialogue();
    }

    public void greetingMonologueChepard() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        audio1 = new AudioClip(this.getClass().getResource("maleshepherd-somethingwrong.wav").toString());
        audio1.play();
        changeImageOnPushForChepard();
        activeChat = true;
        dialogue = dialogueChepard;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "\"Mercenary...\"";
        Dialogue();
    }

    public void greetingMonologueThug() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForThug();
        activeChat = true;
        dialogue = dialogueThug;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "\"What are you lurking around, halfhand?\n" ;
        Dialogue();
    }
    public void greetingMonologueFicsur () throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForThug();
        activeChat = true;
        if(ToDoList.getText().contains("Beat Ficsur"))
        {
            dialogue =dialogueFicsurTask;
        }
        else
        {
            dialogue =dialogueFicsurNoTask;
        }
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "\"What are you lurking around, halfhand?\n" ;
        Dialogue();
    }
    public void greetingMonologueGaelin() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForGaelin();
        activeChat = true;
        dialogue = dialogueGaelin;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueLuna() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForLuna();
        activeChat = true;
        dialogue = dialogueLuna;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueKathrin() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForKathrin();
        activeChat = true;
        dialogue = dialogueKathrin;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueGuard() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        changeImageOnPushForGuard();
        activeChat = true;
        dialogue = dialogueGuard;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }


    public void Dialogue() throws Exception {

        round++;
        if (activeChat == false) {
            return;
        }
        textFieldArea += dialogue[numberOfCurrentIndex];
        dialogueContainer.setText(textFieldArea);
        responseContainerA.setText(dialogue[numberOfCurrentIndex + 1]);
        responseContainerB.setText(dialogue[numberOfCurrentIndex + 2]);
        responseContainerC.setText(dialogue[numberOfCurrentIndex + 3]);
        textFieldArea = "";
    }

    public void goodByeMonologue() throws InterruptedException {
        if (dialogue == dialogueCaerme && !ToDoList.getText().contains("Find the murderer")) {
            changeImageOnPushForOrell();
            dialogue = dialogueOrell;
            dialogueContainer.setText(dialogue[12]);
            dialogue = dialogueCaerme;
            return;
        }
        else if(nameOfPartner.getText().contains("Cáermé"))
        {
            audio1 = new AudioClip(this.getClass().getResource("thanksfriend.wav").toString());
            audio1.play();
        }
        else if (nameOfPartner.getText().contains("Chepard"))
        {
            audio1 = new AudioClip(this.getClass().getResource("maleshepherd-ishouldgo.wav").toString());

            audio1.play();
        }
        else if( nameOfPartner.getText().contains("Eloise Alain"))
        {
            audio1 = new AudioClip(this.getClass().getResource( "liara-neverhappened (1).wav").toString());
            audio1.play();
        }
        dialogueContainer.setText("Until next time!");
        System.out.println("Until next time!");
    }

    public void clickOnDialA() throws Exception {
        if (activeChat == false) {
            return;
        }
        response = responseContainerA.getText();
        System.out.println(response);
        if (response.contains("End conversation")) {
            if (nameOfPartner.getText().contains("Cáermé")&& response.contains("Get task.")){
                activeTasks= ToDoList.getText();
                activeTasks += "\nFind the murderer!";
                ToDoList.setText(activeTasks);
            }
            else if(nameOfPartner.getText().contains("Doris")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="\nJoin to the Thieves Guild.\n Beat Ficsur!";
                ToDoList.setText(activeTasks);
            }
            else if(nameOfPartner.getText().contains("Chepard")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="\nFind the Thieves Guild.";
                ToDoList.setText(activeTasks);
            }
            dialogueContainer.setText("");
            responseContainerA.setText("");
            responseContainerB.setText("");
            responseContainerC.setText("");
            activeChat = false;
            goodByeMonologue();
            return;

        } else if (nameOfPartner.getText().contains("Cáermé")&&response.contains("Get task.")) {
            activeTasks = "Check out the Tavern. SUCCEEDED.\n Speak with Cáermé. SUCCEEDED.\n Find the murderer!";
            ToDoList.setText(activeTasks);
        }
        else if(nameOfPartner.getText().contains("Doris")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="\nJoin up with the Thieves Guild.\n Beat Ficsur!";
                ToDoList.setText(activeTasks);
            }
        else if (response.contains("something else")) {
            numberOfCurrentIndex = 0;
            Dialogue();
            return;
        }
        numberOfCurrentIndex += 4;

        Dialogue();
    }

    public void clickOnDialB() throws Exception {
        if (activeChat == false) {
            return;
        }
        if(nameOfPartner.getText().contains("Borisz, the bartender"))
        {
            if(numberOfCurrentIndex ==0)
            {
                 audio1 = new AudioClip(this.getClass().getResource("ValeeraBase_IntroResponse_Negative00 (1).wav").toString());
                audio1.play();
            }
        }
        response = responseContainerB.getText();
        System.out.println(response);
        if (response.contains("End conversation")) {
            if (response.contains("Get task.")) {
                activeTasks= ToDoList.getText();
                activeTasks += "\nFind the murderer!";
                ToDoList.setText(activeTasks);
            }
            dialogueContainer.setText("");
            responseContainerA.setText("");
            responseContainerB.setText("");
            responseContainerC.setText("");
            activeChat = false;
            goodByeMonologue();
            return;
        } else if (response.contains("Get task.")) {
            activeTasks = "Check out the Tavern. SUCCEEDED.\n Speak with Cáermé. SUCCEEDED.\n Find the murderer!";
            ToDoList.setText(activeTasks);
        } else if (response.contains("something else")) {
            numberOfCurrentIndex = 0;
            Dialogue();
            return;
        }
        numberOfCurrentIndex += 8;
        Dialogue();

    }


    public void clickOnDialC() throws Exception {
        if (activeChat == false) {
            return;
        }

        response = responseContainerC.getText();
        System.out.println(response);
        if (response.contains("End conversation")) {
            if (response.contains("Get task.")) {
                activeTasks = "Check out the Tavern. SUCCEEDED.\n Speak with Cáermé. SUCCEEDED.\n Find the murderer!";
                ToDoList.setText(activeTasks);
            }
            dialogueContainer.setText("");
            responseContainerA.setText("");
            responseContainerB.setText("");
            responseContainerC.setText("");
            activeChat = false;
        goodByeMonologue();

        return;
    } else if (response.contains("Get task.")) {
        activeTasks = "Check out the Tavern. SUCCEEDED.\n Speak with Cáermé. SUCCEEDED.\n Find the murderer!";
        ToDoList.setText(activeTasks);
    } else if (response.contains("something else")) {
        numberOfCurrentIndex = 0;
        Dialogue();
        return;
    }
    numberOfCurrentIndex += 12;
    Dialogue();

    }

}
