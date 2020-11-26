import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class Game {

    int startBalance = 20;
    Dice die = new Dice();
    int numberOfPlayers;
    PlayerList players;
    GUI_Player[] guiPlayers;
    int previousPlacement = 0;
    int currentPlacement = 0;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
    boolean gameInProgress = true;
    private static int selectedLanguage;
    Language language = new Language();
    GUI gui;
    GUI_Field currentField;
    Field[] gameboard;

    public Game() {
        GUI_Field[] fields = GUI_Fields.makeGUIFields(0);
        gameboard = GameFields.makeGameFields();

        gui = new GUI(fields, Color.WHITE); //Keep this as a light color because messages use dark gray text!



    }

    public void startGame() {
        //welcome message
        gui.showMessage("Welcome Message :)");
        //language selection
        if (gui.getUserSelection("Please select a language!","English","Danish","Orc","Chalcatongo Mixtec (dont pick please)").equals("English")) {
            System.out.println("Language Unchanged - English");
        }
        else if (gui.getUserSelection("Please select a language!","English","Danish","Orc","Chalcatongo Mixtec (dont pick please)").equals("Danish")) {
            //remake GUI with new language
            System.out.println("Language Change - Danish");
        }

        //select number of players
        numberOfPlayers = Integer.parseInt(gui.getUserSelection("Please select a number of players!","2","3","4"));
        String[] playerNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = gui.getUserString("Please enter the name of the " + (i + 1) + ". player");
        }

        //creates an array of Player objects and assigns each one their name.
        players = new PlayerList(numberOfPlayers,playerNames);
        //System.out.println(Arrays.toString(playerNames)); //Debugging!
        //System.out.println(players.toString()); //Debugging

        //creates an array of GUI_Player objects. Sets their name, starting money, and car.
        guiPlayers = new GUI_Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            guiPlayers[i] = new GUI_Player(players.getPlayer(i).getName(), startBalance, players.getPlayer(i).getCar());
        }

        while (gameInProgress) { //Keeps game going until gameWon is called
            round();
        }


        /*code for placing a car somewhere
        currentPlacement = 10;
        GUI_Player player = new GUI_Player("Steven", 2000);
        gui.addPlayer(player);
        GUI_Field currentField = gui.getFields()[currentPlacement];
        currentField.setCar(player, true);

        //code for moving car somewhere
        gui.getFields()[currentPlacement].setCar(player, true);
        gui.getFields()[previousPlacement].setCar(player, false);*/

    }


    public void round() {
        //for-loop each player, call turn()

        for (int i = 0; i < numberOfPlayers; i++) {
            turn(i);
        }
    }

    public void turn(int playerID) {
        //roll the die and instantly move that far.
        //check if you passed start, and what you landed on.
        //Do stuff depending on where you landed:
        //1. Property: buy if its not owned, and pay the owner if it is. Do nothing if you own it. Remember double pay if a player owns all of a color group.
        //2. Special fields: Start, Chance, Go to Jail, Just visiting haha. Free parking.
        // MAKE SURE TO CHECK IF YOU CAN AFFORD TO DO EACH AND EVERY ACTION. call endGame() if you can't!

        currentPlayer = players.getPlayer(playerID);
        currentGUIPlayer = guiPlayers[playerID];
        if (!currentPlayer.isJailed()) {
            move(playerID); //move handles landing on fields etc.
        }

        //handling of jailed players
        else {
            //pay 1 money or use get out of jail free card and call turn() again.
            if (currentPlayer.hasJailCard()) {
                currentPlayer.changeJailCard(-1);
                currentPlayer.setJailed(false);
                turn(playerID);
            }
            else {
                if (currentPlayer.getCoins() > 0) {
                    currentPlayer.addCoins(-1);
                    currentPlayer.setJailed(false);
                    turn(playerID);
                }
                else { endGame(currentPlayer); }
            }
        }

        endGame(currentPlayer);

    }



    public void move(int playerID) {
        previousPlacement = currentPlayer.getPlayerPosition(); //set previous placement
        currentPlayer.movePlayer(die.roll()); //changes player's position number
        currentPlacement = currentPlayer.getPlayerPosition(); //set current placement

        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField


        landOnField(playerID);





    }

    public void landOnField(int playerID) {

        if (gameboard[currentPlacement] instanceof FieldStreet) {
            landOnStreet();
        }
        else if (gameboard[currentPlacement] instanceof FieldJail) {
            landOnJail();
        }
        else if (gameboard[currentPlacement] instanceof ChanceCard) {
            landOnChance();
        }



       /*(String[] allNames, Player[] arrayPlayers, GUI_Player[] guiPlayers, int i, int diceSum) {
            Field currentField;
            Field otherField;
            do {
                currentField = board[arrayPlayers[i].getPosition()];
                if (currentField instanceof ChanceCard) {
                    ChanceCard chanceField = (ChanceCard) currentField;
                    handleChanceCard(arrayPlayers, i, currentField, chanceField, guiPlayers[i]);
                } else if (currentField instanceof FieldStreet) {
                    FieldStreet street = (FieldStreet) currentField;
                    handleStreet(allNames[i], arrayPlayers[i], guiPlayers[i], street);
                } else if (currentField instanceof FieldJail) {
                    FieldJail jailField = (FieldJail) currentField;
                    handleJailField(arrayPlayers[i], guiPlayers[i], jailField);
                }
                otherField = board[arrayPlayers[i].getPosition()];
            } while (otherField != currentField);

            return i;*/


    }

    public void landOnStreet() {
        if (!gameboard[currentPlacement].getOwned()) { //checks if NOT owned
            if (currentPlayer.getCoins() < gameboard[currentPlacement].getStreetPrice()) { //checks if you're poor
                endGame(currentPlayer); //ends game if you're poor
            }
            else {
                gameboard[currentPlacement].setOwned(true);
                gameboard[currentPlacement].setOwner(currentPlayer);
                currentPlayer.addCoins(-(gameboard[currentPlacement].getStreetPrice())); //pays for the property
            }


        }
        else { //if the property is already owned
            if (currentPlayer.getCoins() < gameboard[currentPlacement].getRentPrice()) { //checks if you're poor
                endGame(currentPlayer);
            }
            else {
                currentPlayer.addCoins(-(gameboard[currentPlacement].getRentPrice()));
                gameboard[currentPlacement].getOwner().addCoins(gameboard[currentPlacement].getRentPrice());
            }
        }
        //update gui ?
    }

    public void landOnJail() {
        currentPlayer.setPlayerPosition(6);
        currentPlayer.setJailed(true);
        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField
        }

    public void landOnChance() {

    }

    public void endGame(Player currentPlayer) {
        gameInProgress = false;
        //players count all their money. the one with most wins the game. If there is a tie, count the value of each players'
        //property and the highest wins. If that's also a tie, then fight to the death by fist.
    }

    public static int returnLanguageID() { return selectedLanguage; }

}



