import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.Arrays;

public class Game {

    Dice die = new Dice();
    private int numberOfPlayers;
    private int previousPlacement = 0;
    private int currentPlacement = 0;
    boolean gameInProgress = true;
    private static int selectedLanguage;
    boolean[] usedChanceCards = new boolean[18];
    PlayerList players;
    GUI_Player[] guiPlayers;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
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
        if (gui.getUserSelection("Please select a language!", "English", "Danish", "Orc", "Chalcatongo Mixtec (dont pick please)").equals("English")) {
            System.out.println("Language Unchanged - English");
        } else if (gui.getUserSelection("Please select a language!", "English", "Danish", "Orc", "Chalcatongo Mixtec (dont pick please)").equals("Danish")) {
            //remake GUI with new language
            System.out.println("Language Change - Danish");
        }

        //select number of players
        numberOfPlayers = Integer.parseInt(gui.getUserSelection("Please select a number of players!", "2", "3", "4"));
        String[] playerNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = gui.getUserString("Please enter the name of the " + (i + 1) + ". player");
        }

        //creates an array of Player objects and assigns each one their name.
        players = new PlayerList(numberOfPlayers, playerNames);
        //System.out.println(Arrays.toString(playerNames)); //Debugging!
        //System.out.println(players.toString()); //Debugging

        //creates an array of GUI_Player objects. Sets their name, starting money, and car.
        guiPlayers = new GUI_Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            int startBalance = 20;
            guiPlayers[i] = new GUI_Player(players.getPlayer(i).getName(), startBalance, players.getPlayer(i).getCar());
        }

        //Mix the deck of chance cards.
        Arrays.fill(usedChanceCards, false);

        //set current field to Start.
        currentField = gui.getFields()[0];

        //puts the players on Start in the gui.
        for (int i = 0; i < numberOfPlayers; i++) {
            currentField.setCar(guiPlayers[i], true);
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

        gui.showMessage("It is now " + players.getPlayer(playerID).getName() + "'s turn.");
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
            } else {
                if (currentPlayer.getCoins() > 0) {
                    currentPlayer.addCoins(-1);
                    currentPlayer.setJailed(false);
                    turn(playerID);
                } else {
                    endGame(currentPlayer);
                }
            }
        }

    }


    public void move(int playerID) {
        previousPlacement = currentPlayer.getPlayerPosition(); //set previous placement
        currentPlayer.movePlayer(die.roll()); //changes player's position number
        currentPlacement = currentPlayer.getPlayerPosition(); //set current placement

        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField


        landOnField();
    }

    public void landOnField() {

        if (gameboard[currentPlacement] instanceof FieldStreet) {
            landOnStreet();
        } else if (gameboard[currentPlacement] instanceof FieldJail) {
            landOnJail();
        } else if (gameboard[currentPlacement] instanceof ChanceCard) {
            landOnChance();
        }

    }

    public void landOnStreet() {
        if (!gameboard[currentPlacement].getOwned()) { //checks if NOT owned
            if (currentPlayer.getCoins() < gameboard[currentPlacement].getStreetPrice()) { //checks if you're poor
                endGame(currentPlayer); //ends game if you're poor
            } else {
                gameboard[currentPlacement].setOwned(true);
                gameboard[currentPlacement].setOwner(currentPlayer);
                currentPlayer.addCoins(-(gameboard[currentPlacement].getStreetPrice())); //pays for the property
            }


        } else { //if the property is already owned
            if (currentPlayer.getCoins() < gameboard[currentPlacement].getRentPrice()) { //checks if you're poor
                endGame(currentPlayer);
            } else {
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


    public void endGame(Player currentPlayer) {
        gameInProgress = false;
        //players count all their money. the one with most wins the game. If there is a tie, count the value of each players'
        //property and the highest wins. If that's also a tie, then fight to the death by fist.
    }

    public static int returnLanguageID() {
        return selectedLanguage;
    }

    public int rollChanceCard() {
        return (int) (Math.random() * usedChanceCards.length);
    }

    public void landOnChance() {
        boolean cardsLeft = false;
        for (int i = 0; i < usedChanceCards.length; i++) { //Checks to see if at least 1 card is left.
            if (usedChanceCards[i] == false) {
                cardsLeft = true;
                break;
            }
        }
        if (!cardsLeft) { //Resets the deck
            Arrays.fill(usedChanceCards, false);
        }


        if (cardsLeft) { //Finds an unused card and calls chance() with it's ID.
            int cardID = rollChanceCard();
            while (usedChanceCards[cardID]) {
                cardID = rollChanceCard();
            }

            chance(cardID);
        }


    }

    public void chance(int cardID) { //Takes the ID of an unused card.
        switch (cardID) {
            case 0:
                System.out.println("Chance card 0");
                usedChanceCards[cardID] = true;
                break;
            case 1:
                System.out.println("Chance card 1");
                usedChanceCards[cardID] = true;
                break;
            case 2:
                System.out.println("Chance card 2");
                usedChanceCards[cardID] = true;
                break;
            case 3:
                System.out.println("Chance card 3");
                usedChanceCards[cardID] = true;
                break;
            case 4:
                System.out.println("Chance card 4");
                usedChanceCards[cardID] = true;
                break;
            case 5:
                System.out.println("Chance card 5");
                usedChanceCards[cardID] = true;
                break;
            case 6:
                System.out.println("Chance card 6");
                usedChanceCards[cardID] = true;
                break;
            case 7:
                System.out.println("Chance card 7");
                usedChanceCards[cardID] = true;
                break;
            case 8:
                System.out.println("Chance card 8");
                usedChanceCards[cardID] = true;
                break;
            case 9:
                System.out.println("Chance card 9");
                usedChanceCards[cardID] = true;
                break;
            case 10:
                System.out.println("Chance card 10");
                usedChanceCards[cardID] = true;
                break;
            case 11:
                System.out.println("Chance card 11");
                usedChanceCards[cardID] = true;
                break;
            case 12:
                System.out.println("Chance card 12");
                usedChanceCards[cardID] = true;
                break;
            case 13:
                System.out.println("Chance card 13");
                usedChanceCards[cardID] = true;
                break;
            case 14:
                System.out.println("Chance card 14");
                usedChanceCards[cardID] = true;
                break;
            case 15:
                System.out.println("Chance card 15");
                usedChanceCards[cardID] = true;
                break;
            case 16:
                System.out.println("Chance card 16");
                usedChanceCards[cardID] = true;
                break;
            case 17:
                System.out.println("Chance card 17");
                usedChanceCards[cardID] = true;
                break;
        }

    }

}



