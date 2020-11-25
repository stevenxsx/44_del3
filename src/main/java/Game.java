
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    Dice die = new Dice();
    int numberOfPlayers;
    PlayerList players;
    int previousPlacement = 0;
    int currentPlacement = 0;
    Player currentPlayer;
    boolean gameInProgress = true;
    private static int selectedLanguage;
    Language language = new Language();
    GUI gui;

    public Game() {
        GUI_Field[] fields = GUI_Fields.makeGUIFields(0);
        for (int i = 0; i < fields.length; i++) {
            fields[i].setBackGroundColor(new Color(255,255,255));
        }
        gui = new GUI(fields, Color.WHITE); //Keep this as a light color because messages use dark gray text!


    }

    public void startGame() {
        //welcome message
        gui.showMessage("Hello and welcome Wack Monopoly. I'm sorry to hear that you've been forced to play this pitiful excuse of a game. Do try to enjoy yourself regardless and good" +
                " luck beating the 5 year-old you're inevitably facing!");
        //language selection
        if (gui.getUserSelection("Please select a language!","English","Danish","Orc","Chalcatongo Mixtec (dont pick please)").equals("English")) {
            System.out.println("Language Unchanged - English");
        }
        else if (gui.getUserSelection("Please select a language!","English","Danish","Orc","Chalcatongo Mixtec (dont pick please)").equals("Danish")) {
            //remake GUI with new language
            System.out.println("Language Change - Danish");
        }

        //select number of players
        numberOfPlayers = Integer.parseInt(gui.getUserSelection("Please select a number of players!","1","2","3","4"));
        String[] playerNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = gui.getUserString("PLease enter the name of the " + (i + 1) + ". player");
        }

        players = new PlayerList(numberOfPlayers,playerNames);
        //System.out.println(Arrays.toString(playerNames)); //Debugging!
        //System.out.println(players.toString()); //Debugging

        //code for placing a car somewhere
        currentPlacement = 10;
        GUI_Player player = new GUI_Player("Steven", 2000);
        gui.addPlayer(player);
        GUI_Field currentField = gui.getFields()[currentPlacement];
        currentField.setCar(player, true);

        //code for moving car somewhere
        gui.getFields()[currentPlacement].setCar(player, true);
        gui.getFields()[previousPlacement].setCar(player, false);


        //Do stuff that sets up the GUI and puts all the players pieces at start, set their starting cash, etc etc.

        while (gameInProgress) { //Keeps game going until gameWon is called
            round();
        }
    }

    public void welcomeMessage() {
        System.out.println(language.welcomeMessage[selectedLanguage]);

    }

    public void round() {
        //for-loop each player, call turn()
    }

    public void turn() {
        //roll the die and instantly move that far.
        //check if you passed start, and what you landed on.
        //Do stuff depending on where you landed:
        //1. Property: buy if its not owned, and pay the owner if it is. Do nothing if you own it. Remember double pay if a player owns all of a color group.
        //2. Special fields: Start, Chance, Go to Jail, Just visiting haha. Free parking.
        // MAKE SURE TO CHECK IF YOU CAN AFFORD TO DO EACH AND EVERY ACTION. call endGame() if you can't!

    }

    public void endGame() {
        //players count all their money. the one with most wins the game. If there is a tie, count the value of each players'
        //property and the highest wins. If that's also a tie, then fight to the death by fist.
    }

    public static int returnLanguage() { return selectedLanguage; }

}



