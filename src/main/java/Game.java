import gui_fields.GUI_Car;
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
            //System.out.println("Language Unchanged - English");
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

        //Creates 4 cars that can be used for players.
        GUI_Car[] cars = GUI_Cars.makeCars(numberOfPlayers);

        //creates an array of GUI_Player objects. Sets their name, starting money, and car.
        guiPlayers = new GUI_Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            int defaultBalance = 20;
            guiPlayers[i] = new GUI_Player(players.getPlayer(i).getName(), defaultBalance, cars[i]);
        }

        //Mix the deck of chance cards.
        Arrays.fill(usedChanceCards, false);

        //set current field to Start.
        currentField = gui.getFields()[0];

        //Creates the name/car/money part on the left and puts the players on Start in the gui.
        for (int i = 0; i < numberOfPlayers; i++) {
            gui.addPlayer(guiPlayers[i]);
            currentField.setCar(guiPlayers[i], true);
        }

        //updates gui money
        updateGUIMoney(players.getPlayers(), guiPlayers);

        while (gameInProgress) { //Keeps game going until gameWon is called
            round();
        }



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

        updateGUIMoney(players.getPlayers(), guiPlayers);

    }


    public void move(int playerID) {
        currentField = gui.getFields()[currentPlayer.getPlayerPosition()]; //makes sure the gui will remove the car of the current player's position.

        previousPlacement = currentPlayer.getPlayerPosition(); //set previous placement
        currentPlayer.movePlayer(die.roll()); //changes player's position number
        currentPlacement = currentPlayer.getPlayerPosition(); //set current placement

        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField

        if (currentPlayer.hasPassedGoThisTurn()) { //adds money if player passes go when moving.
            currentPlayer.addCoins(2);
        }
        currentPlayer.resetHasPassedGo(); //sets boolean back to false.
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
            } else { //buys property and assigns player's name to the gui.
                gameboard[currentPlacement].setOwned(true);
                gameboard[currentPlacement].setOwner(currentPlayer);
                gui.getFields()[currentPlacement].setSubText(currentPlayer.getName()); //gui property owner name updated here
                currentPlayer.addCoins(-(gameboard[currentPlacement].getStreetPrice())); //pays for the property
                checkColorGroupOwned(currentPlacement);
            }


        } else { //if the property is already owned
            if (currentPlayer.getCoins() < gameboard[currentPlacement].getRentPrice()) { //checks if you're poor
                endGame(currentPlayer);
            } else {
                currentPlayer.addCoins(-(gameboard[currentPlacement].getRentPrice()));
                gameboard[currentPlacement].getOwner().addCoins(gameboard[currentPlacement].getRentPrice());
                System.out.println(gameboard[currentPlacement].getRentPrice() + " coins have been paid");
            }
        }
        //update gui ?
    }

    public void landOnJail() {

        currentField.setCar(currentGUIPlayer, false); //sets gui player's position on currentField

        currentPlayer.setPlayerPosition(6); //sets player position to jail cell
        currentPlacement = currentPlayer.getPlayerPosition(); //updates currentPlacement
        currentPlayer.setJailed(true);
        currentField.setCar(currentGUIPlayer, false); //removes old position on gui
        currentField = gui.getFields()[currentPlacement]; //sets new position on gui
        currentField.setCar(currentGUIPlayer, true); //sets gui player's position on currentField
    }

    private void updateGUIMoney(Player[] players, GUI_Player[] guiPlayers) {

        for (int i = 0; i < players.length; i++) {
            guiPlayers[i].setBalance(players[i].getCoins());
        }

    }

    private void checkColorGroupOwned(int propertyID) {
        char type = gameboard[propertyID].getType(); //sets type equal to purchased property's type
        for (int i = 0; i < gameboard.length; i++) {
            if (gameboard[i].getType() == type && (i != propertyID)) { //checks for the matching property
                if (gameboard[i].getOwner() == gameboard[propertyID].getOwner()) { //checks if both properties are now owned by the same person or not.
                    gameboard[i].setRentPriceMultiplier(2);
                    gameboard[propertyID].setRentPriceMultiplier(2);
                }
                else {
                    gameboard[i].setRentPriceMultiplier(1);
                    gameboard[propertyID].setRentPriceMultiplier(1);
                }
            }
            gameboard[i].setRentPrice(gameboard[i].getRentPrice()); //updates rent price with the new multiplier
            gameboard[propertyID].setRentPrice(gameboard[i].getRentPrice());

        }


        /*for (int i = 0; i < gameboard.length; i++) {
            if (gameboard[(i % gameboard.length)].getType() == gameboard[(i + 1) % gameboard.length].getType()) { //checks if 2 adjacent fields are of same type
                if (gameboard[(i % gameboard.length)].getOwner() == gameboard[(i + 1) % gameboard.length].getOwner()) { //checks if those same 2 fields are owned by 1 person
                    if (gameboard[(i % gameboard.length)].getRentPriceMultiplier() == 1) { //checks to see if the price has already been doubled
                        gameboard[(i % gameboard.length)].setRentPriceMultiplier(2); //doubles rent price
                        gameboard[((i + 1) % gameboard.length)].setRentPriceMultiplier(2);


                    }
                    gameboard[(i % gameboard.length)].setRentPrice(gameboard[(i % gameboard.length)].getRentPrice()); //doubles rent price of those 2 fields. (MUST UNDO IF OWNERSHIP LOST)
                    gameboard[(i + 1) % gameboard.length].setRentPrice(gameboard[(i + 1) % gameboard.length].getRentPrice());
                }
            }
        }*/

    }


    public void endGame(Player currentPlayer) {
        gameInProgress = false;
        System.out.println("game ended");
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
            if (!usedChanceCards[i]) {
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



