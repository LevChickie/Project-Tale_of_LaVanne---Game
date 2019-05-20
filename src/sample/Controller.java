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
    private InventoryManager inventory;
    private JournalManager journal;
    private PlayMusic backgroundMusic;
    private PlayMusic voices;
    private LoadPicture loading;
    private ChangeScene changeScene;
    private Image image;

    public TextField responseContainerA;
    public TextField responseContainerB;
    public TextField responseContainerC;
    public TextArea dialogueContainer;
    public TextArea ToDoList;
    public TextArea Inventory;
    public TextField nameOfPartner;
    public TextField Location;

    private AudioClip audio1;

    private boolean end_conversation;
    private boolean activeChat = false;
    private boolean talked_shady = false;
    private boolean xymeritaDead=false;
    private boolean ficsurBeaten= false;
    private boolean murdererKilled=false;

    public Button toBergAenDal = new Button("Berg Aen Dal");
    public Button exitCity = new Button("Exit city");

    public Button talkCaerme = new Button("talk: Cáermé");
    public Button talkOrell = new Button("talk: Orell");
    public Button talkBartender = new Button("talk: Bartender");
    public Button talkThug = new Button("talk: Thug");
    public Button talkChepard = new Button("talk: Chepard");

    public Button talkBardolf = new Button("talk: Bardolf");
    public Button talkEloise = new Button("talk: Eloise");
    public Button talkFicsur = new Button("talk: Ficsur");
    public Button talkGaelin = new Button("talk: Gaelin");
    public Button talkKathrin = new Button("talk: Kathrin");
    public Button talkLuna = new Button("talk: Luna");
    public Button talkGuard =new Button("talk: Guard");
    public Button talkXymerita =new Button("talk: Xymerita");
    public Button talkLoretta =new Button("talk: Guard");
    public Button talkHag =new Button("talk: Guard");
    public Button talkKid =new Button("talk: Guard");
    public Button talkJaques =new Button("talk: Guard");
    public Button talkCitizen1_1 = new Button( "Talk: Villager");
    public Button talkCitizen2_1 = new Button( "Talk: Villager");
    public Button talkCitizen2_2 = new Button( "Talk: Villager");
    public Button talkCitizen3_1 = new Button( "Talk: Villager");

    public Button inspect1 =new Button("Inspect");
    public Button inspect2 =new Button("Inspect");
    public Button inspect3 =new Button("Inspect");
    public Button inspect4 =new Button("Inspect");
    public Button searchBody =new Button("Search body");
    public Button pickUpSilver = new Button("talk: Pick up Silver");
    public Button pickUpAnotherSilver = new Button("talk: Pick up Silver");
    public Button pickUpJewellery = new Button("talk: Steal Jewellery");
    public Button buyBeer = new Button("talk: Buy a beer");

    public Button enterTavern = new Button("Enter Tavern");
    public Button enterCastle = new Button("Enter Castle");
    public Button enterThievesDen = new Button("Enter Thieves Den");
    public Button returnCity = new Button("Return to City");
    public Button goToMerchantDistrict = new Button("Enter Merchant District");
    public Button enterMurderScene = new Button("Go to murder scene");
    public Button enterLibrary = new Button("Enter Library");
    public Button enterHouse1 = new Button("Enter House");
    public Button enterHouse2 = new Button("Enter House");
    public Button enterHouse3 = new Button("Enter House");
    public Button enterHouse4 = new Button("Enter House");
    public Button enterHouse5 = new Button("Enter House");
    public Button enterHouse6 = new Button("Enter House");
    public Button enterHouse7 = new Button("Enter House");
    public Button enterHouse8 = new Button("Enter House");
    public Button enterHouse9 = new Button("Enter House");
    public Button enterHouse10 = new Button("Enter House");
    public Button enterMine = new Button("Enter Mine");
    public Button enterSlums = new Button("Enter Slums");


    private int numberOfCurrentIndex;

    public ImageView playGroundImageView;
    public ImageView heroView;
    public ImageView speechPartnerView;

    public int round;

    private ArrayList<String> itemList = new ArrayList<>();
    private ArrayList<String> toDoList = new ArrayList<>();

    private  String response;
    private  String textFieldArea;
    private   String activeTasks;
    private  String [] activeTask = {"Enter the tavern","Speak with Cáermé"};
    private   String[] dialogue;
    private  String[] dialogueCaerme = {"I have a problem, there was a murder.\n We cought each suspects in time, but we are needed elsewhere.\n You seem like some'one, who could handle it.\n We pay in gold, if you're up to the task\"",
            "Who was murdered?", "How lovely, the little elf lass needs some help. Gladly. (Get task.)(End conversation)", "I don't have the time. Bye! (End conversation.)", "A girl called Lilith. She was killed yesterday in cold blood in the Merchant District. Poor girl...", "I will help you find her killer! (Get task. End conversation.)", "I see. I want to ask something else", "Nope, not interested. (End conversation.)"};
    private  String[] dialogueCaermeTask = {"Do you have any news, LaVanne?", "I have a suspect.","I need some information.","I am still investigating(End conversation)",
            "Really? Tell me more, please!", "He is a scum hiding in the slums. (End conversation)(Finish)", "The killer is Xymerita, the elf girl.(End conversation)(Finish)","The murderer is Jaques.(End conversation)(Finish)", "All right... So the murder...", "Thank you kindly! (End conversation)", "I want to ask about something else.","Good bye! (End conversation)"};

    private  String[] dialogueOrell = {"Bastien. I am not surprised. Where the problem, you're around.", "Just like you and your friends.", "Greetings as well, witcher.", "Yeah, sure. Don't care (End conversation.)", "But we want to solve them, but you seems to make the troubles.", "That makes us two. But I also solve them. For gold. (End conversation.)", "You are so untrustful, I have to laugh (End conversation.)", "I won't waste my time on you, witcher. (End conversation.)", "What brought you here?", "I was sent by Ragwald, he said you need the man.(End conversation.)", "That bold guy in Branburg paid me. (End conversation.)", "Just came by. (End conversation.)", "I told you Cáermé. We can't trust him with this task. I will solve it."};
    private  String[] dialogueBartender = {"Hello there. You are with the lady and the guy? They are watching you since you arrived.", "Yes, I fought with them.", "Yes, I had... some good time with the lass", "Nope. (End conversation.)", "Really? What? Where?", "We occupied the fortress of Titus de Achtenberg.", "Gimme a beer. (End conversation.)", "Why do you care? (End conversation.)", "She's... sorry, sir... I didn't mean to...", "It was like fighting a dragon. Fervid and long (End conversation.)", "Gimme a beer (End conversation.)", "Yeah. (End conversation.)", "Wow... that's something. But they say the Dracheturm family stormed the fort.","They merely entered the empty fortress. We slayed the guards. (End conversation)","What a surprise... (End conversation)", "I would like to ask something else."};
    private  String[] dialogueBardolf = {"Who are you, halfhand?", "I am Sebastien LaVanne, Lord Alain. I'm here to ask about the murder.","I'm the guy, who solve your problems for coin.","I am just looking around. (End conversation)","LaVanne? Isn't it a southern family?", "I came from Toussaint, sir (End conversation)", "Indeed, it is. (End converastion)", "I'm leaving. (End conversation)","A mercenary eh? All right. What do you need?", "I have to speak with your daughter, sir. (End conversation)","I want to ask about something (End conversation)", "I am leaving. (End conversation)"};
    private String[] dialogueEloise = {"Hello there, what brought you to me?", "Greetings to you, mylady, I'd have some questions about the murder", "The beauty of your higness, of course", "I think I will leave now(End conversation)","I see. I have some informations. Lilith was a great girl.\n Not like the other girls. She was different.\nI am pretty sure she was killed right after the word came out, that she supported the Ard Scoia'tel.\nA fake rumor, if you ask me.","Intriguiging.(End conversation)","I want to ask about something else","I leave now.(End conversation)","Oh, an other charmer. What makes you more then the others?","I am  Bastien LaVanne, son of a count of Toussaint(End conversation)","Nothing.(End conversation)","I leave now(End conversation)"};
    private String[] dialogueChepard = {"Is something wrong? What can I help you, mercenary?", "I wonder if you have some job for a veteran sword-wielder, or not.", "I must speak with the lord. (End conversation)", "Goodbye. (End conversation)","You are lucky! We need someone to find the hideout of the bandits in the slums. You look someone who could handle this problem.","Yes, I am honored to do that task for you (Get task) (End conversation", "I want to speak about something else.", "Not interested (End conversation)"};
    private   String[] dialogueThug = {"He! Who ar you! It is private quarter. Whattadoyou want?", "Me? Just want a well paid job, if you know what I mean.", "I search for the murderer of that girl", "Okay. I shall leave. (End conversation)","Really? We have a decent job! But first, you shall defeat Ficsur","Sounds like a good job. (Get task) (End conversation)", "I want to ask about something else","Not interested (End conversation)", "I would like to help you. But as you can see, we have other things to do.", "What about the blood on the floor, under the barrels? (End conversation)", "Okay. I want to ask about something else.","Than I shall leave (End conversation)" };
    private  String[] dialogueThugJoined = {"Nice! You've beaten the bastard! Welcome to our family!","Thanks.(End conversation","Not interested. (End conversation)","Bye! (End conversation)"};
    private  String[] dialogueFicsurTask= {"You are the new guy eh? Let's see what are you made of, halfman!","I beat you with one hand. (End conversation) (Fight Ficsur)", "Let's roll! (End conversation) (Fight Ficsur)","I am not ready yet. (End conversation)"};
    private  String[] dialogueFicsurNoTask= {"Who the fuck are you? Get lost before I mess you up like a... Mess.","Thank you kindly. (End conversation)","Fuck you too. (End conversation","Ahemm... (End conversation)"};
    private  String[] dialogueGaelin = {"Greetings. How can be at your assistance?","I want to know the details of the murder","I shall leave (End conversation)","Bye (End conversation)","All we know, that it was an hour ago.\n A young hooker by the name of Lilith was fatally wounded by a shortsword.\n She tried... to run, but her attacker was quicker, or she was already wounded\nIt did not seem an act of a monster, better a typival 'human works","Thanks (End conversation)","I would like to ask something else","Bye(End conversation)"};
    private  String[] dialogueLuna = {"Hi! My name is Luna. What can I do for you?","Hi little girl, I need to speak to your parents (End conversation)","I think you could help me... ","So long, Luna (End conversation)","","","","","I know much about the girl. Lilith. She was a friend of mine\nShe worked in the merchant district...She sold love to people.\n She was very nice, but she had a certain style...\n which made it difficult to like her. She had recent quarrells with Xym, she talked about it yesterday...","Xym? You mean Xymerita? (End conversation)","It might be useful (End conversation)", "That's not of my concern(End conversation)"};
    private    String[] dialogueKathrin = {"Hello! My name is Kathrin, I am the Leader of the Guard of Honour. What can I help you with?","I am investigating the murder","Hi, I am Bastien, Leader of the Sons of None. The pleasure is mine","I have to go (End conversation)","You should speak with Gaelin. He knows more.\nMaybe I could help you a bit... If I recall corectly, she was a hooker under the wings of Loretta.\nYou might should speak with her.","Thanks for the tip!(End conversation)", "I need to ask about something else.","Good bye! (End conversation)","So, what do you need?","I need information about the murder","I am looking for the Thieves Guild.","Good bye(End conversation)","","","","","","","","","","","","" ,"","","","","You should speak with Gaelin. He knows more.\nMaybe I could help you a bit... If I recall corectly, she was a hooker under the wings of Loretta.\nYou might should speak with her.","Thanks for the tip!(End conversation)", "I need to ask about something else.","Good bye! (End conversation)","The Thieves Guild has it's nest in the Slums. I don't know more." ,"Thanks! (End conversation)", "See you!(End coneversation)","Good bye! (End conversation)"} ;
    private  String[] dialogueGuard = {"Move along citizen!","I need information about the murder.","I am investigating the murder you moron.","As you wish. (End conversation)","As everyone else and I have lost my patience!","I am the investigator.","Then fuck you. (End conversation)","I don't want trouble. (End conversation)","Oh, in that case you might know the followings.\nShe must have run for her life. She might be dead for an hour now.\nThere are some blood, and over there some more, by the crates.\nShe was... a nice girl. We should say no bad things about the dead. All we need now is a furious ghost...\n",
                    "I see, thank you (End conversation)","That's not much. Maybe it will help a bit though. (End conversation)","Bye! (End conversation)" };
    private  String[] dialogueVillager1= {"Move along! Leave me be!", "All right! All right (End conversation)", "Give me all your money first!(End conversation)", "I leave, then (End conversation)"};
    private String[] dialogueVillager2= {"You are tresspassing! I will call the guards!", "All right! All right (End conversation)", "Give me all your money or I will slash you in pieces!(End conversation)", "I leave, then (End conversation)"};
    private String[] dialogueLoretta = {"Greetings, sire! I heard you are investigating this hineous act!\nYou must find the bloody killer! Please, kill him on sight if you find him.","Tell me about her, and what you know about the murder","For the right price I will make him suffer.","I'm leaving now.","Of course, if it helps you, I give you every detail. She was quite a girl. She had standards.\nI respected her elegance, she took only those offers which one was quite promising.\nA knight, a rich merchant, a spellcaster... Maybe that's the reason she was killed. The bastards!", "Thanks! (End conversation)", "I wanted to talk with you about something else","Goodbye (End conversation)",
            "I am ready to pay... With gold, or with my body. Or both, if the screams of the bastards will be heard through the city","In this case I pity him a bit... (Get task)(End conversation)","That's not worth it to me. (End conversation)","I'm leaving (End conversation)"};
    private  String[] dialogueLorettaKilledMurderer = {"Have you killed that bastard yet?","Yes, you should have heard his screams","Yes, I did.","I will come back later!","Oh my hero! What can I bring you for your service?","Money will do. (End conversation)","Nothing would be more valueable than yourself, my lady (Make love)(End conversation)","Nothing, it was my pleasure (End conversation)","Great! What could I give you for your service?","Money will do. (End conversation)","Nothing would be more valueable than yourself, my lady (Make love)(End conversation)","Nothing, it was my pleasure (End conversation)"};
    private   String[] dialogueLorettaNotKilledMurderer = {"Have you killed that bastard yet?","Could you tell me something about her?","I'm on it (End conversation)", "I'll leave now","Of course, if it helps you, I give you every detail. She was quite a girl. She had standards.\nI respected her elegance, she took only those offers which one was quite promising...\nA knight, a rich merchant, a spellcaster... Maybe that's the reason she was killed. The bastards!","Thanks (End conversation","I will find the murderer (End conversation)","I leave now(End conversation)"};
    private String[] dialogueXymerita = {"Greetings, knight! You came to find the murderer?","Yes, I did. Can you tell me something about it?", "No, I came for you, pretty one","I'm leaving(End conversation)","Of course! I was working and I saw her. I saw here in the distance.\nNot the murder. But I know that some shady guy met with her.\nI am not sure if it was about work or something... more. She was quite mysterious to us all.", "I see, thanks.(End conversation)","I wanted to ask something else","Good bye! (End conversation)"
            ,"Oh, it was really nice of you! I know a place which is less... Noisy.", "Lead the way, my lady.(End conversation) (Pay hooker)","Not this time, I have thing to do(End conversation)","I have to leave (End conversation)"};
    private   String[] dialogueXymeritaBlamed = {"Greetings, knight! You came to find the murderer?","I did.","I found a man who blamed you for the murderer","I came for you, my sweet.","Did you kill him?\nPlease tell me, you did so! That monster deserves death!","No, I did not kill him.(End conversation)", "I killed him.(End conversation)","I cannot speak about it. Bye! (End conversation)","Me? That bastard lied to you! I did nothing, she was my best friend!\nI could never hurt her! Please, don't say you believe him!","I guess I do.(End conversation)","No, I'm not.(End conversation)","Your lies won't save your life!(End conversation)(Kill her)",
            "Oh, it was really nice of you! I know a place which is less... Noisy.", "Lead the way, my lady.(End conversation) (Pay hooker)","Not this time, I have thing to do(End conversation)","I have to leave (End conversation)"};
    private  String[] dialogueJaques = {"She earned it. She was a ruthless prostitute. Whatever they say, it's not true. She was a wench.","Why do you think so?","You just incriminating yourself(End conversation)","I have no time for this.(End conversation)","How? She was a scheming wench! Nothing else! Everyone hated her, but now she's dead,\n they fear their happiness would made them suspicious.","Intriguing(End conversation)","I heard enough. (End conversation)","I have not time for you(End conversation)"};
    private String[] dialogueHag = {"She... was killed by a slim shadow! I saw them fighting.\n Then she run here, but soon she fell to the ground. The shadow was disappeared by the time.","A shadow?","What else did you see, old woman?", "I have no time for this.(End conversation)","Indeed. A shadow murdered her. A shadow... {with face of Stannis Baratheon!}","You are mad. (End conversation)","Then we should need a witcher... If you are correct(End conversation)","Old fool (End conversation)","I saw... A slim shadow, wielding a shortsword and cutting the lady. She cried out and ran here.","I see...(End conversation)","Maybe useful. Maybe not(End conversation)","Old fool (End conversation)"};
    private   String[] dialogueKid = {"Hi there! You my daddy?", "No. Kid move along", "Yes, I am your dad, now go, fetch some wine to Father! (End conversation)","I have no time for your foolishness. (End conversation)","I thought you might be. You are alike my ma's discription", "Sorry boy. (End conversation)","I was just joking, I'm your dad, no go, bring me some wine!(End conversation)","I better leave.(End conversation)","Yes! Yes!"};
    private    String[] dialogueAssassin = {"This is not what it looks like. I did not murder anyone", "Then what it looks like?","You might right. I won't lock you up... for now (End conversation)","You'll only die with dirty conscience.(Kill him)(End conversation)","It was not me. I seen the murder. I was about to visit her, when I heared her screams.\n I ran as fast I could, and there I saw an elf woman fighting with her.\nWhen the elf saw my blade, she turned away, and Lilith ran away. But she was a damn good fighter, I almost escaped with my life.\nThis is my blood.","An elf woman. I am not lock you up for now(End conversation)"
            ,"Always the elfs. Maybe that's why the whole racism shit started.(End conversation)","You murdered her in cold blood, I shall do the same.(End conversation)(Kill him)","Please, you must listen to me!","Enough! I will come back. (End conversation)"};
//I won't lock you up... for now

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
            else if(Location.getText().contains("library"))
            {
                enterLibrary.fire();
            }
            else if(Location.getText().contains("merchant"))
            {
                goToMerchantDistrict.fire();
            }
            else if(Location.getText().contains("house"))
            {
                returnCity.fire();
            }
            else if(Location.getText().contains("slums"))
            {
                enterSlums.fire();
            }
            else if(Location.getText().contains("murder scene"))
            {
                enterMurderScene.fire();
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
        if(Location.getText().contains("house"))
        {
            dialogueContainer.setText("You cannot save while tresspassing!");
            return;
        }
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
            dialogueContainer.setText("\"Fat idiot. He seems to be strong tho.\"");
        }
        else if(nameOfPartner.getText().contains("Xymerita"))
        {
            dialogueContainer.setText("\"I have to tell you... She has fire in her eyes. She walks like a lioness...\"");
        }
        else if(nameOfPartner.getText().contains("Loretta"))
        {
            dialogueContainer.setText("\"The madam of Berg Aen Dal... Quite powerful.\n If someone killed her girl, that means someone challenged her.\"");
        }
        else if(nameOfPartner.getText().contains("Kid"))
        {
            dialogueContainer.setText("\"Foolish kid...\"");
        }
        else if(nameOfPartner.getText().contains("Guard"))
        {
            dialogueContainer.setText("\"Guards... Always on the edge, never on the track.\"");
        }
        else if(nameOfPartner.getText().contains("Hag"))
        {
            dialogueContainer.setText("\"Why didn't she died already? She must be mad...\"");
        }
        else if(nameOfPartner.getText().contains("Villager"))
        {
            dialogueContainer.setText("\"I might just can get some coin from them.\"");
        }
        else if(nameOfPartner.getText().contains("Luna"))
        {
            dialogueContainer.setText("\"Cute little girl. Why I have the feeling that she is much more than she shows?\"");
        }
        else if(nameOfPartner.getText().contains("Gaelin"))
        {
            dialogueContainer.setText("\"An ancient old elf librarian? Quite strange, I suppose...\"");
        }
        else if(nameOfPartner.getText().contains("Kathrin"))
        {
            dialogueContainer.setText("\"Those eyes... I don't like 'em. Seems to be on my side, though.\"");
        }
        else if(nameOfPartner.getText().contains("Jaques"))
        {
            dialogueContainer.setText("\"An idiot knight. Why always the great people fell in battle?\"");
        }
        else if(nameOfPartner.getText().contains("Villager")&& Location.getText().contains("4"))
        {
            dialogueContainer.setText("\"How did this guy find not just one, but two swords?\"");
        }
    }
    public void clickOnBastien() {

        voices = new PlayMusic("ArthasPissed6");
        voices.play();
        dialogueContainer.setText("\"I fought in the war against Nilfgaard alongside the northern kingdoms with my band of sellswords.\n In the battle of Marnadal one bastards chopped my right hand off. \n They look at me like a degenerated since... Luckily I my left is my better hand...\n I showed that a year later in the battle of Sodden, where we demolished the lines of the southern dogs.\"");
    }

    public void changeImageOnPushForOrell() {
            nameOfPartner.setText("Orell, the Witcher");
            loading = new LoadPicture("Orell");
            image = loading.getItem();
            speechPartnerView.setImage(image);
    }

    public void changeImageOnPushForBartender() {
            nameOfPartner.setText("Borisz, the bartender");
            loading = new LoadPicture("bartender");
            image = loading.getItem();
            speechPartnerView.setImage(image);

    }

    public void changeImageOnPushForCaerme() {
            nameOfPartner.setText("Cáermé");
            loading = new LoadPicture("Aenyelle");
            image = loading.getItem();
            speechPartnerView.setImage(image);

    }

    public void changeImageOnPushForEloise() {
            nameOfPartner.setText("Eloise Alain");
            loading = new LoadPicture("Eloise Bardolf");
            image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForBardolf() {
            nameOfPartner.setText("Bardolf Alain");
        loading = new LoadPicture("Bardolf Alain");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForChepard() {
            nameOfPartner.setText("Sommander Chepard");
        loading = new LoadPicture("Sommander Chepard");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForThug() {
        nameOfPartner.setText("Doris");
        loading = new LoadPicture("doris");
        image = loading.getItem();
        speechPartnerView.setImage(image);

    }
    public void changeImageOnPushForFicsur() {
            nameOfPartner.setText("Ficsur");
        loading = new LoadPicture("ficsur");
        image = loading.getItem();speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForGuard() {
            nameOfPartner.setText("Berg Aen Dal Guard");
        loading = new LoadPicture("guard");
        image = loading.getItem();
        speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForGaelin()
    {
            nameOfPartner.setText("Gaelin");
            loading = new LoadPicture("gaelin");
            image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForLuna()
    {
            nameOfPartner.setText("Luna");
        loading = new LoadPicture("luna");
        image = loading.getItem();
            speechPartnerView.setImage(image);

    }
    public void changeImageOnPushForKathrin()
    {
            nameOfPartner.setText("Kathrin");
        loading = new LoadPicture("kathrin");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForXymerita()
    {
            nameOfPartner.setText("Xymerita");
        loading = new LoadPicture("lady");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForLoretta()
    {
            nameOfPartner.setText("Loretta");
        loading = new LoadPicture("loretta");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForJaques()
    {
            nameOfPartner.setText("Jaques");
        loading = new LoadPicture("jaques");
        image = loading.getItem();
            speechPartnerView.setImage(image);
    }
    public void changeImageOnPushForHag()
    {
            nameOfPartner.setText("Old lady");
            loading = new LoadPicture("hag");
            image = loading.getItem();
            speechPartnerView.setImage(image);

    }
    public void changeImageOnPushForKid()
    {
            nameOfPartner.setText("Kid");
        loading = new LoadPicture("boy");
        image = loading.getItem();
            speechPartnerView.setImage(image);

    }
    public void changeImageOnPushForVillager()
    {
            nameOfPartner.setText("Villager");
            loading = new LoadPicture("Othovir");
            image = loading.getItem();
            speechPartnerView.setImage(image);
    }





    //MAPPING
    public void setEnterTavern() {
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

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            journal= new JournalManager(ToDoList.getText());
            journal.removeItem("Enter the Tavern");
            ToDoList.setText(journal.writeJournal());

            voices = new PlayMusic("povertyAndFamine");
            voices.audio.setVolume(0.2);
            voices.play();

            changeScene = new ChangeScene("tavern");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }

    public void setReturnCity() {
            playGroundImageView.setScaleY(1.28);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(60);
            playGroundImageView.setX(-1);

            enterCastle.setVisible(true);
            enterTavern.setVisible(true);
            enterSlums.setVisible(true);
            goToMerchantDistrict.setVisible(true);
            enterHouse1.setVisible(true);
            exitCity.setVisible(true);

            toBergAenDal.setVisible(false);
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

            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterThievesDen.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("city");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }

    public void setEnterCastle() {
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

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("castle");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }

    public void setEnterThievesDen() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1.02);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(10);
            playGroundImageView.setX(10);

            talkThug.setVisible(true);
            returnCity.setVisible(true);
            talkFicsur.setVisible(true);
            inspect1.setVisible(true);

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            if(ToDoList.getText().contains("Find the Thieves Guild."))
            {
                journal= new JournalManager(ToDoList.getText());
                journal.removeItem("Find the Thieves Guild.");
                ToDoList.setText(journal.writeJournal());
            }

            changeScene = new ChangeScene("thieves den");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }

    public void goMerchantDistrict() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1.05);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(30);

            returnCity.setVisible(true);
            enterLibrary.setVisible(true);
            enterMurderScene.setVisible(true);
            enterHouse2.setVisible(true);
            enterHouse9.setVisible(true);
            enterHouse6.setVisible(true);
            enterHouse8.setVisible(true);

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("merchant");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }
    public void setGoToMurderScene() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            toBergAenDal.setVisible(false);
            returnCity.setVisible(true);
            talkGuard.setVisible(true);
            talkHag.setVisible(true);
            talkJaques.setVisible(true);
            talkKid.setVisible(true);
            talkLoretta.setVisible(true);
            talkXymerita.setVisible(true);
            searchBody.setVisible(true);
            inspect2.setVisible(true);

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            inspect1.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            inventory = new InventoryManager(Inventory.getText());
            if(inventory.writeInventory().contains("Lilith"))
            {
                searchBody.setVisible(false);
            }

            if(xymeritaDead)
            {
                talkXymerita.setVisible(false);
                changeScene = new ChangeScene("murder scene (Xym dead)");
                Location.setText(changeScene.changeName());
                playGroundImageView.setImage(changeScene.changePlace());
            }
            else {
                changeScene = new ChangeScene("murder scene");
                Location.setText(changeScene.changeName());
                playGroundImageView.setImage(changeScene.changePlace());
            }

    }
    public void setEnterLibrary() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            talkGaelin.setVisible(true);
            talkLuna.setVisible(true);
            talkKathrin.setVisible(true);

            toBergAenDal.setVisible(false);
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


            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("library");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }
    public void setEnterHouse1() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            talkCitizen1_1.setVisible(true);
            talkCitizen2_1.setVisible(true);


            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("house 1");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }
    public void setEnterHouse2() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            talkCitizen2_2.setVisible(true);

            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);

            toBergAenDal.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("house 2");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }
    public void setEnterHouse3() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            inspect4.setVisible(true);

            toBergAenDal.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
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

            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);


            changeScene = new ChangeScene("house 3");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }
    public void setEnterHouse10() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            returnCity.setVisible(true);
            inspect3.setVisible(true);
            talkCitizen3_1.setVisible(true);

            toBergAenDal.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);


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

            enterHouse1.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);

            Location.setText("Berg Aen Dal, house (4)");
            if(murdererKilled)
            {
                talkCitizen3_1.setVisible(false);
                changeScene = new ChangeScene("murderer (dead)");
                Location.setText(changeScene.changeName());
                playGroundImageView.setImage(changeScene.changePlace());
            }
            else{
                changeScene = new ChangeScene("murderer");
                Location.setText(changeScene.changeName());
                playGroundImageView.setImage(changeScene.changePlace());
            }

    }
    public void setEnterMines() {
       changeImageOnPushForGuard();
       dialogueContainer.setText("Halt! It is forbidden to enter the mines after the bloodbath in there.");
    }
    public void setEnterSlums() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);


            enterHouse7.setVisible(true);
            returnCity.setVisible(true);
            enterThievesDen.setVisible(true);
            enterHouse4.setVisible(true);
            enterHouse3.setVisible(true);
            enterHouse10.setVisible(true);

            toBergAenDal.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);

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
            goToMerchantDistrict.setVisible(false);
            enterLibrary.setVisible(false);
            enterMurderScene.setVisible(false);
            enterHouse1.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);

            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("slums");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

        }
    public void leaveCity() {
            playGroundImageView.setScaleY(1);
            playGroundImageView.setScaleX(1);
            playGroundImageView.setScaleZ(1);
            playGroundImageView.setY(0);
            playGroundImageView.setX(0);

            toBergAenDal.setVisible(true);

            returnCity.setVisible(false);
            talkGaelin.setVisible(false);
            talkLuna.setVisible(false);
            talkKathrin.setVisible(false);
            exitCity.setVisible(false);

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
            enterHouse1.setVisible(false);
            enterHouse2.setVisible(false);
            enterHouse3.setVisible(false);
            enterHouse4.setVisible(false);
            enterHouse5.setVisible(false);
            enterHouse6.setVisible(false);
            enterHouse7.setVisible(false);
            enterHouse8.setVisible(false);
            enterHouse9.setVisible(false);
            enterHouse10.setVisible(false);
            enterSlums.setVisible(false);
            enterMine.setVisible(false);
            talkFicsur.setVisible(false);
            talkHag.setVisible(false);
            talkJaques.setVisible(false);
            talkKid.setVisible(false);
            talkLoretta.setVisible(false);
            talkXymerita.setVisible(false);
            inspect1.setVisible(false);
            inspect2.setVisible(false);
            inspect3.setVisible(false);
            inspect4.setVisible(false);
            searchBody.setVisible(false);

            talkCitizen1_1.setVisible(false);
            talkCitizen2_1.setVisible(false);
            talkCitizen2_2.setVisible(false);
            talkCitizen3_1.setVisible(false);

            changeScene = new ChangeScene("aedirn");
            Location.setText(changeScene.changeName());
            playGroundImageView.setImage(changeScene.changePlace());

    }



    //Inspection!
    public void inspectionOne()
    {
        dialogueContainer.setText("There is blood under the barrels in the Thieves Guild...\nIt's in the shade of black... so it seems old blood...");
    }
    public void inspectionTwo()
    {
        dialogueContainer.setText("It seems he was ambushed at those barrels, and he died while running away from his attacker.");
    }
    public void inspectionThree()
    {
        dialogueContainer.setText("There's fresh blood on the floor and the dagger of the man is freshly cleared.");
        voices = new PlayMusic("BanditPissed1");
        voices.play();
    }
    public void inspectionFour()
    {
        dialogueContainer.setText("Dead people. It seems something came out from that tunnel and murdered them during night.");
        voices = new PlayMusic("RatWhat2");
        voices.play();
    }

    //INVETORY MANIPULATION

    public void pickUpJournal()
    {
        inventory = new InventoryManager(Inventory.getText());
        inventory.addItem("\nJournal of Lilith");
        searchBody.setVisible(false);
        dialogueContainer.setText("Looks like she has been charged with the support of the Ard Scoia'tel.\nAnd she had some quarrel with another girl she did not mentioned");
        Inventory.setText(inventory.writeInventory());
    }
    public void pickUpSilverCastle() {
        inventory = new InventoryManager(Inventory.getText());
        inventory.addItem("\nSilver");
        pickUpSilver.setVisible(false);
        Inventory.setText(inventory.writeInventory());
    }
    public void getGold() {
        inventory = new InventoryManager(Inventory.getText());
        inventory.addItem("\nGold");
        Inventory.setText(inventory.writeInventory());
    }
    public void pickUpSilverTavern() {
        inventory = new InventoryManager(Inventory.getText());
        inventory.addItem("\nSilver");
        pickUpAnotherSilver.setVisible(false);
        Inventory.setText(inventory.writeInventory());
    }
    public void pickUpJewellery() {
        inventory = new InventoryManager(Inventory.getText());
        inventory.addItem("\nGolden amulet");
        pickUpJewellery.setVisible(false);
        Inventory.setText(inventory.writeInventory());
    }
    public void buyBeer()
    {
        voices= new PlayMusic("bartender");
        voices.play();
        loseSilver();
        saveGame();
        dialogueContainer.setText("Game Saved!");
    }
    public void loseSilver() {
        inventory = new InventoryManager(Inventory.getText());
        inventory.removeItem("Silver");
        Inventory.setText(inventory.writeInventory());
    }


    //DIALOGUES
    //DIALOGUES

    public void greetingMonologueCaerme() throws Exception {

        if(ToDoList.getText().contains("Speak with Cáermé"))
        {
            journal= new JournalManager(ToDoList.getText());
            journal.removeItem("Speak with Cáermé");
            ToDoList.setText(journal.writeJournal());
        }


        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("ValeeraBase_UI_Purchase00 (1)");
        voices.play();
        changeImageOnPushForCaerme();
        String list = ToDoList.getText();
        if(list.contains("Find the murderer")||murdererKilled)
        {
            dialogue =dialogueCaermeTask;
        }
        else
        {
            dialogue =dialogueCaerme;
        }
        activeChat = true;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "\"LaVanne!\n" +
                "I should have known that our paths will cross each other once again.\n";
        Dialogue();
    }

    public void greetingMonologueOrell() throws Exception {
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("UtherWhat1");
        voices.play();
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
        voices = new PlayMusic("HeroAlchemistWhat3");
        voices.play();
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
        voices = new PlayMusic("IllidanWhat4");
        voices.play();
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
        voices = new PlayMusic("maleshepherd-somethingwrong");
        voices.play();
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
        voices = new PlayMusic("BanditPissed3");
        voices.play();
        changeImageOnPushForThug();
        activeChat = true;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        if(!ficsurBeaten) {
            dialogue = dialogueThug;
            textFieldArea += "\"What are you lurking around, halfhand?\n";
        }
        else{
            dialogue=dialogueThugJoined;
            textFieldArea += "\"You showed him!\n";
            journal=new JournalManager(ToDoList.getText());
            journal.removeItem("Talk with Doris");
            ToDoList.setText(journal.writeJournal());
        }
        Dialogue();
    }
    public void greetingMonologueFicsur () throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("GruntWhat4");
        voices.play();
        changeImageOnPushForFicsur();
        activeChat = true;
        String list = ToDoList.getText();
        if(list.contains("Beat Ficsur"))
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
        voices = new PlayMusic("SpellbreakerWhat2");
        voices.play();
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
        voices = new PlayMusic("VillagerF1");
        voices.play();
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
        voices = new PlayMusic("NaishaWhat3");
        voices.play();
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
        voices = new PlayMusic("FootmanWhat4");
        voices.play();
        changeImageOnPushForGuard();
        activeChat = true;
        dialogue = dialogueGuard;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueXymerita() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("SorceressWhat1");
        voices.play();
        changeImageOnPushForXymerita();
        activeChat = true;
        if(!talked_shady)
        dialogue = dialogueXymerita;
        else {dialogue = dialogueXymeritaBlamed;}
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueLoretta() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("ShandrisWhat3");
        voices.play();
        changeImageOnPushForLoretta();
        activeChat = true;
        if(murdererKilled)
        {
            dialogue=dialogueLorettaKilledMurderer;
        }
        else if(ToDoList.getText().contains("Kill the murderer"))
        {
          dialogue = dialogueLorettaNotKilledMurderer;
        }
        else{
        dialogue = dialogueLoretta;
        }
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueJaques() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("KnightPissed4");
        voices.play();
        changeImageOnPushForJaques();
        activeChat = true;
        dialogue = dialogueJaques;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueHag() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("RunnerWhat5");
        voices.play();
        changeImageOnPushForHag();
        activeChat = true;
        dialogue = dialogueHag;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueKid() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("GoblinSapperPissed1");
        voices.play();
        changeImageOnPushForKid();
        activeChat = true;
        dialogue = dialogueKid;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueVillager1() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("VillagerMAWhat3");
        voices.play();
        changeImageOnPushForVillager();
        activeChat = true;
        dialogue = dialogueVillager1;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueVillager2() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("VillagerMAWhat1");
        voices.play();
        changeImageOnPushForVillager();
        activeChat = true;
        dialogue = dialogueVillager2;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }
    public void greetingMonologueVillager3() throws Exception{
        round=0;
        speechPartnerView.setVisible(true);
        voices = new PlayMusic("GarithosWhat4");
        voices.play();
        changeImageOnPushForVillager();

        activeChat = true;
        dialogue = dialogueAssassin;
        numberOfCurrentIndex = 0;
        textFieldArea = "";
        textFieldArea += "";
        Dialogue();
    }


    public void Dialogue()  {

        round++;
        if (!activeChat ) {
            return;
        }
        textFieldArea += dialogue[numberOfCurrentIndex];
        dialogueContainer.setText(textFieldArea);
        responseContainerA.setText(dialogue[numberOfCurrentIndex + 1]);
        responseContainerB.setText(dialogue[numberOfCurrentIndex + 2]);
        responseContainerC.setText(dialogue[numberOfCurrentIndex + 3]);
        textFieldArea = "";
    }

    public void goodByeMonologue() {
        if (dialogue == dialogueCaerme && !ToDoList.getText().contains("Find the murderer")) {
            changeImageOnPushForOrell();
            dialogue = dialogueOrell;
            dialogueContainer.setText(dialogue[12]);
            dialogue = dialogueCaerme;
            return;
        }
        else if(nameOfPartner.getText().contains("Cáermé")&&ToDoList.getText().contains("Find the murderer"))
        {
            voices= new PlayMusic("thanksfriend");
            voices.play();
            getGold();
            getGold();
            getGold();

        }
        else if (nameOfPartner.getText().contains("Chepard"))
        {
            voices= new PlayMusic("maleshepherd-ishouldgo");
            voices.play();
        }
        else if( nameOfPartner.getText().contains("Eloise Alain"))
        {
            voices= new PlayMusic("liara-neverhappened (1)");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Bardolf"))
        {
            voices= new PlayMusic("IllidanYes3");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Kathrin"))
        {
            voices= new PlayMusic("NaishaWhat5");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Gaelin"))
        {
            voices= new PlayMusic("SpellbreakerYes1");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Luna"))
        {
            voices= new PlayMusic("VillagerF2");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Xymerita")&&!xymeritaDead)
        {
            voices= new PlayMusic("SorceressYes1");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Loretta")&&response.contains("Make love"))
        {
            voices= new PlayMusic("ShandrisWhat1");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Loretta")&&murdererKilled)
        {
            voices= new PlayMusic("ShandrisYes1");
            getGold();
            getGold();
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Loretta"))
        {
            voices= new PlayMusic("ShandrisPissed2");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Kid"))
        {
            voices= new PlayMusic("GoblinSapperPissed4");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Guard"))
        {
            voices= new PlayMusic("FootmanPissed1");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Doris"))
        {
            voices= new PlayMusic("BanditYes3");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Ficsur"))
        {
            voices= new PlayMusic("BanditWhat2");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Borisz"))
        {
            voices= new PlayMusic("HeroAlchemistWhat4");
            voices.play();
        }
        else if(nameOfPartner.getText().contains("Villager")&&Location.getText().contains("4")&&!murdererKilled)
        {
            voices= new PlayMusic("GarithosPissed3");
            voices.play();
        }


       if(murdererKilled&&nameOfPartner.getText().contains("Villager")&&Location.getText().contains("4"))
           dialogueContainer.setText("Aaaaaaarrgghh!");
        else{   dialogueContainer.setText("Until next time!");}
    }

    public void clickOnDialA() throws Exception {
        if (!activeChat) {
            return;
        }
        response = responseContainerA.getText();
        if (response.contains("End conversation")) {
            if(nameOfPartner.getText().contains("Cáermé")&& response.contains("Finish"))
            {
                voices = new PlayMusic("UtherReturns");
                voices.play();
                inventory=new InventoryManager(Inventory.getText());
                inventory.addItem("\nA bag of coin");
                Inventory.setText(inventory.writeInventory());
                journal=new JournalManager(ToDoList.getText());
                journal.removeItem("Find the murderer!");
                ToDoList.setText(journal.writeJournal());
            }
            if (nameOfPartner.getText().contains("Cáermé")&& response.contains("Get task")){
                activeTasks= ToDoList.getText();
                activeTasks += "Find the murderer!\n";
                ToDoList.setText(activeTasks);
            }
            if (nameOfPartner.getText().contains("Loretta")&& response.contains("Get task")){
                activeTasks= ToDoList.getText();
                activeTasks += "Kill the murderer!\n";
                ToDoList.setText(activeTasks);
            }
            else if(nameOfPartner.getText().contains("Doris")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="Join to the Thieves Guild.\nBeat Ficsur!\n";
                ToDoList.setText(activeTasks);
            }
            else if(nameOfPartner.getText().contains("Chepard")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="Find the Thieves Guild.\n";
                getGold();
                getGold();
                ToDoList.setText(activeTasks);
            }
            else if(nameOfPartner.getText().contains("Xymerita")&&response.contains("Pay"))
            {
                loseSilver();
                loseSilver();
                ToDoList.setText(activeTasks);
            }
            else if (Location.getText().contains("4")) {
                talked_shady=true;
            }
            else if (nameOfPartner.getText().contains("Ficsur")&& response.contains("Fight Ficsur")){
                journal = new JournalManager(ToDoList.getText());
                journal.removeItem("Beat Ficsur!");
                journal.addItem("\nTalk with Doris\n");
                ToDoList.setText(journal.writeJournal());
                voices=new PlayMusic("ficsurBEAT");
                voices.play();
                ficsurBeaten=true;
            }
            else if(nameOfPartner.getText().contains("Doris")&&ficsurBeaten)
            {
                journal=new JournalManager(ToDoList.getText());
                journal.removeItem("Join the Thieves Guild.");
                ToDoList.setText(journal.writeJournal());
            }

            dialogueContainer.setText("");
            responseContainerA.setText("");
            responseContainerB.setText("");
                    responseContainerC.setText("");
            activeChat = false;
            goodByeMonologue();
            return;

        }
        else if(nameOfPartner.getText().contains("Doris")&&response.contains("Get task"))
            {
                activeTasks=ToDoList.getText();
                activeTasks+="\nJoin up with the Thieves Guild. \nBeat Ficsur!";
                getGold();
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
        response = responseContainerB.getText();
        if(nameOfPartner.getText().contains("Borisz, the bartender"))
        {
            if(numberOfCurrentIndex ==0)
            {
                 audio1 = new AudioClip(this.getClass().getResource("ValeeraBase_IntroResponse_Negative00 (1).wav").toString());
                audio1.play();
            }
        }

        if (response.contains("End conversation")) {
            if(nameOfPartner.getText().contains("Cáermé")&& response.contains("Finish"))
            {
                voices = new PlayMusic("UtherReturns");
                voices.play();
                inventory=new InventoryManager(Inventory.getText());
                inventory.addItem("\nA bag of coin");
                Inventory.setText(inventory.writeInventory());
                journal=new JournalManager(ToDoList.getText());
                journal.removeItem("Find the murderer!");
                ToDoList.setText(journal.writeJournal());
            }
            else if (response.contains("Get task.")&&nameOfPartner.getText().contains("Cáermé")) {
                activeTasks= ToDoList.getText();
                activeTasks += "\nFind the murderer!";
                ToDoList.setText(activeTasks);
            }
            else if (Location.getText().contains("4")&& response.contains("Kill")) {
                if(inventory.writeInventory().contains("Longsword"))
                {
                    murdererKilled = true;
                    voices = new PlayMusic("PeasantDeath");
                    voices.play();
                    loading = new LoadPicture("DeadMurderer");
                    image = loading.getItem();
                    playGroundImageView.setImage(image);
                    journal = new JournalManager(ToDoList.getText());
                    journal.removeItem("Find the murderer!");
                    ToDoList.setText(journal.writeJournal());
                    talkCitizen3_1.setVisible(false);
                }
                else
                {
                    voices = new PlayMusic("HeroPaladinDeath");
                    voices.play();
                    loading = new LoadPicture("died");
                    image = loading.getItem();
                    playGroundImageView.setImage(image);
                    returnCity.setVisible(false);
                    inspect3.setVisible(false);
                    talkCitizen3_1.setVisible(false);
                    exitCity.setVisible(false);
                }
            }
            if (nameOfPartner.getText().contains("Ficsur")&& response.contains("Fight Ficsur")){
                journal = new JournalManager(ToDoList.getText());
                journal.removeItem("Beat Ficsur!");
                journal.addItem("\nTalk with Doris");
                ToDoList.setText(journal.writeJournal());
                voices=new PlayMusic("ficsurBEAT");
                voices.play();
                ficsurBeaten=true;
            }
            else if(response.contains("Give me all your money"))
            {
                voices=new PlayMusic("PeasantPissed3");
                voices.play();
                getGold();
            }

            dialogueContainer.setText("");
            responseContainerA.setText("");
            responseContainerB.setText("");
            responseContainerC.setText("");
            activeChat = false;
            goodByeMonologue();
            return;

        } else if (response.contains("Get task.")) {
            activeTasks= ToDoList.getText();
            activeTasks += "\nFind the murderer!";
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
        if (nameOfPartner.getText().contains("Villager")&& response.contains("Kill")) {
            inventory = new InventoryManager(Inventory.getText());
           if (inventory.writeInventory().contains("Longsword")) {
                  murdererKilled = true;
              voices = new PlayMusic("PeasantDeath");
               voices.play();
               loading = new LoadPicture("deadmurd");
               image = loading.getItem();
                playGroundImageView.setImage(image);
                journal = new JournalManager(ToDoList.getText());
                if (journal.writeJournal().contains("Find the murderer")) {
                    journal.removeItem("Find the murderer!");
                }
                if (journal.writeJournal().contains("Kill the murderer!")) {
                    journal.removeItem("Kill the murderer!");
                }
                ToDoList.setText(journal.writeJournal());
               talkCitizen3_1.setVisible(false);
            }
            else
            {
                voices = new PlayMusic("HeroPaladinDeath");
                voices.play();
                loading = new LoadPicture("died");
                image = loading.getItem();
                playGroundImageView.setImage(image);
                returnCity.setVisible(false);
                inspect3.setVisible(false);
                talkCitizen3_1.setVisible(false);
                exitCity.setVisible(false);
          }
        }
        else if(nameOfPartner.getText().contains("Xymerita")&&response.contains("Kill her"))
        {
            voices = new PlayMusic("SorceressDeath");
            voices.play();
            xymeritaDead=true;
            loading = new LoadPicture("xymdead");
            image = loading.getItem();
            playGroundImageView.setImage(image);
            journal = new JournalManager(ToDoList.getText());
            if (journal.writeJournal().contains("Find the murderer")) {
                journal.removeItem("Find the murderer!");
            }
            if (journal.writeJournal().contains("Kill the murderer!")) {
                journal.removeItem("Kill the murderer!");
            }
            ToDoList.setText(journal.writeJournal());
            talkXymerita.setVisible(false);
        }
        if (response.contains("End conversation")) {
            if(nameOfPartner.getText().contains("Cáermé")&& response.contains("Finish"))
            {
                voices = new PlayMusic("UtherReturns");
                voices.play();
                inventory=new InventoryManager(Inventory.getText());
                inventory.addItem("A bag of coin");
                Inventory.setText(inventory.writeInventory());
                journal=new JournalManager(ToDoList.getText());
                journal.removeItem("Find the murderer!");
                ToDoList.setText(journal.writeJournal());
            }
           if (response.contains("Get task.")) {
                activeTasks= ToDoList.getText();
                activeTasks += "\nFind the murderer!\n";
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
            activeTasks= ToDoList.getText();
            activeTasks += "\nFind the murderer!";
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
