import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.Arrays;

public class Game {

    Dice die = new Dice();
    private int numberOfPlayers;
    //private int previousPlacement = 0;
    private int currentPlacement = 0;
    boolean gameInProgress = true;
    boolean[] usedChanceCards = new boolean[18];
    PlayerList players;
    GUI_Player[] guiPlayers;
    Player currentPlayer;
    GUI_Player currentGUIPlayer;
    Language l = new Language();
    private int o = 0;
    GUI gui;
    GUI_Field currentField;
    Field[] gameboard;


    public Game() {
        GUI_Field[] fields = GUI_Fields.makeGUIFields(o);
        gameboard = GameBoard.makeGameFields(o);

        gui = new GUI(fields, Color.WHITE); //Keep this as a light color because messages use dark gray text!


    }

    public void startGame() {
        //welcome message
        gui.showMessage("Welcome to Monopoly Junior! Please select a language.");
        //language selection
        if (gui.getUserSelection("Please select a language!", "Danish").equals("Danish")) {
            o = 0;
        } //else if (languageSelection.equals("Danish")) {
            //remake GUI with new language
        //}
        //use this as index for any displayed text in language class

        //select number of players
        numberOfPlayers = Integer.parseInt(gui.getUserSelection(l.selectNumberPlayers[o], "2", "3", "4"));
        String[] playerNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = gui.getUserString(l.pleaseEnterName[o] + (i + 1) + l.dotPlayer[o]);
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

        gui.showMessage(l.welcomeMessage[o]);

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
        if (gameInProgress) {
            gui.showMessage(l.itIsNow[o] + players.getPlayer(playerID).getName() + l.playersTurn[o]);
            currentPlayer = players.getPlayer(playerID);
            currentGUIPlayer = guiPlayers[playerID];

            if (!currentPlayer.isJailed()) {
                move(die.roll()); //move handles landing on fields etc.
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
    }


    public void move(int distance) {
        currentField = gui.getFields()[currentPlayer.getPlayerPosition()]; //makes sure the gui will remove the car of the current player's position.

        //previousPlacement = currentPlayer.getPlayerPosition(); //set previous placement
        currentPlayer.movePlayer(distance); //changes player's position number
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
        } else if (gameboard[currentPlacement] instanceof FieldGoToJail) {
            landOnJail();
        } else if (gameboard[currentPlacement] instanceof FieldChance) {
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
            if (gameboard[currentPlacement].getOwner() != currentPlayer) { //Only does something if the player doesn't own the property himself
                if (currentPlayer.getCoins() < gameboard[currentPlacement].getRentPrice()) { //checks if you're poor
                    endGame(currentPlayer);
                } else {
                    currentPlayer.addCoins(-(gameboard[currentPlacement].getRentPrice()));
                    gameboard[currentPlacement].getOwner().addCoins(gameboard[currentPlacement].getRentPrice());
                    //System.out.println(gameboard[currentPlacement].getRentPrice() + l.coinsBeenPaid[o]);
                }
            }
        }
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
                } else {
                    gameboard[i].setRentPriceMultiplier(1);
                    gameboard[propertyID].setRentPriceMultiplier(1);
                }
                gameboard[i].setRentPrice(gameboard[i].getRentPrice()); //updates rent price with the new multiplier
                gameboard[propertyID].setRentPrice(gameboard[propertyID].getRentPrice());
            }


        }

    }


    public void endGame(Player currentPlayer) {
        StringBuilder endOfGameMessage = new StringBuilder();
        for (int i = 0; i < numberOfPlayers; i++) {
            endOfGameMessage.append(players.getPlayer(i).getName()).append(l.had[o]).append(players.getPlayer(i).getCoins()).append(" ").append(l.moneyLeft[o]);
        }


        gui.showMessage(currentPlayer.getName() + l.wentBankrupt[o] + endOfGameMessage);
        gameInProgress = false;
        gui.close();
        System.out.println(l.gameEnded[o]);
        System.out.println(currentPlayer.getName() + l.wentBankrupt[o] + endOfGameMessage);
        //players count all their money. the one with most wins the game. If there is a tie, count the value of each players'
        //property and the highest wins. If that's also a tie, then fight to the death by fist.
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
        String selection = "";
        switch (cardID) {
            case 0:
                //System.out.println("Chance card Ryk frem til hvilken som helst felt");
                usedChanceCards[cardID] = true;
                //ryk frem til hvilket som helst ledigt felt og køb det.
                //Hvis der ikke er nogle ledige felter tilbage, skal du købe et fra en anden spiller.
                selection = gui.getUserSelection(l.chanceCard0[o], l.burgerbarentitel[o],l.pizzeriaettitel[o],l.slikbutikkentitel[o],l.iskioskentitel[o],l.museettitel[o],
                        l.bibliotekettitel[o],l.skaterparkentitel[o],l.svoemmebassinettitel[o],l.spillehallentitel[o],l.biografentitel[o],l.legetoejsbutikkentitel[o],
                        l.dyreHandlentitel[o],l.bowlinghallentitel[o],l.zootitel[o],l.vandlandtitel[o],l.strandpromonadentitel[o]);

                boolean areAllPropertiesPurchased = true;
                int selectedPropertyIndex = 0;
                for (int i = 0; i < gameboard.length; i++) { //checks if there are available properties
                    if (!gameboard[i].getOwned()) {
                        areAllPropertiesPurchased = false;
                        break;
                    }
                }

                for (int i = 0; i < gameboard.length; i++) { //finds ID of selected property
                    if (gameboard[i].getPropertyName().equals(selection)) {
                        selectedPropertyIndex = i;
                    }
                }

                if (areAllPropertiesPurchased) { //no properties left -> steal property
                    if (gameboard[selectedPropertyIndex].getOwner() == currentPlayer) { //checks if property is owned by the player attempting steal
                        gui.showMessage(l.chanceCard0EjerAllerede[o]);
                        chance(0);
                    } else {
                        if (currentPlayer.getCoins() >= gameboard[selectedPropertyIndex].getStreetPrice()) {//checks if the player can afford to buy the property.
                            gameboard[selectedPropertyIndex].getOwner().addCoins(gameboard[selectedPropertyIndex].getStreetPrice()); //pays the previous owner the price
                            gameboard[selectedPropertyIndex].setOwner(currentPlayer); //sets the current player as the new owner

                            currentPlayer.addCoins(-gameboard[selectedPropertyIndex].getStreetPrice()); //current player loses money equal to the cost of the new property
                            move(24 + (selectedPropertyIndex - currentPlacement) % 24); //moves player to his new property
                            gui.getFields()[currentPlacement].setSubText(currentPlayer.getName()); //sets gui property owner name
                            checkColorGroupOwned(currentPlacement);
                        } else { //triggers if the player can't afford the property
                            gui.showMessage(l.chanceCard0IkkeRåd[o]);
                            chance(0);
                        }
                    }


                } else { //Attempts to buy property
                    if (gameboard[selectedPropertyIndex].getOwned()) { //checks if property is owned first
                        gui.showMessage(l.chanceCard0AndenEjer[o]);
                        chance(0);
                    } else { //moves to selected property and buys it like normal if property isn't owned.
                        move(24 + (selectedPropertyIndex - currentPlacement) % 24);
                    }
                }


                break;
            case 1:
                //System.out.println("Chance card Ryk frem til start");
                usedChanceCards[cardID] = true;
                move(24 - currentPlacement);
                gui.getUserButtonPressed(l.chanceCard1[o], l.chanceCard1Okay);
                break;
            case 2:
                //System.out.println("Chance card Ryk op til 5 felter frem");
                usedChanceCards[cardID] = true;
                move(Integer.parseInt(gui.getUserSelection(l.chanceCard2[o],"1", "2", "3", "4", "5"))); //moves 1-5 fields forward.
                break;
            case 3:
                //System.out.println("Chance card Gratis felt (orange)");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection(l.chanceCard3[o], l.chanceCard3Valg1[o],l.chanceCard3Valg2[o]); //Move to orange fields index 10 or 11
                if (selection.equals(l.chanceCard3Valg1[o])) {
                    if (!gameboard[10].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[10].getStreetPrice());
                    }
                    move(24 + (10 - currentPlacement) % 24);
                } else if (selection.equals(l.chanceCard3Valg2[o])) {
                    if (!gameboard[11].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[10].getStreetPrice());
                    }
                    move(24 + (11 - currentPlacement) % 24);
                } else {
                    System.out.println("chance card Gratis felt (orange) messed up");
                }

                break;
            case 4:
                //System.out.println("Chance card Ryk 1 frem/Chancekort ekstra");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection("Vælg en mulighed!", "Ryk et felt frem", "Tag et chancekort mere");
                if (selection.equals("Ryk et felt frem")) {
                    move(1);
                } else if (selection.equals("Tag et chancekort mere")) {
                    landOnChance();
                } else {
                    System.out.println("chance card Ryk 1 frem/Chancekort ekstra messed up");
                }
                break;
            case 5:
            case 12:
            case 11:
                //System.out.println("Chance card Ryk frem til hvilken som helst felt 3");
                //System.out.println("Chance card Ryk frem til hvilken som helst felt 4");
                //System.out.println("Chance card Chance card Ryk frem til hvilken som helst felt 2");
                usedChanceCards[cardID] = true;
                chance(0);
                break;
            case 6:
                //System.out.println("Chance card Betal 2 til banken");
                usedChanceCards[cardID] = true;
                if (currentPlayer.getCoins() - 2 < 0) { //makes the game end if the player cant afford to pay the bank 2 dollars.
                    endGame(currentPlayer);
                } else {
                    currentPlayer.addCoins(-2);
                }
                break;
            case 7:
                //System.out.println("Chance card Gratis felt (orange/grønt)");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection("Ryk frem til et af de 4 felter og få det gratis hvis det er ledigt!", "Ryk frem til Skaterparken", "Ryk frem til Svømmebassinet", "Ryk frem til Zoologisk Have", "Ryk frem til Bowlinghallen"); //Move to orange fields index 10 or 11
                if (selection.equals("Ryk frem til Skaterparken")) {
                    if (!gameboard[10].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[-currentPlacement + 10].getStreetPrice());
                    }
                    move(24 + (10 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Svømmebassinet")) {
                    if (!gameboard[11].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[11].getStreetPrice());
                    }
                    move(24 + (11 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Zoologisk Have")) {
                    if (!gameboard[19].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[19].getStreetPrice());
                    }
                    move(24 + (19 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Bowlinghallen")) {
                    if (!gameboard[20].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[20].getStreetPrice());
                    }
                    move(24 + (20 - currentPlacement) % 24);
                } else {
                    System.out.println("chance card Gratis felt (orange/grønt) messed up");
                }
                break;
            case 8:
                //System.out.println("Chance card Gratis felt (lyseblåt)");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection("Ryk frem til et af de 2 felter og få det gratis hvis det er ledigt!", "Ryk frem til Slikbutikken", "Ryk frem til Iskiosken"); //Move to orange fields index 10 or 11
                if (selection.equals("Ryk frem til Slikbutikken")) {
                    if (!gameboard[4].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[4].getStreetPrice());
                    }
                    move(24 + (4 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Iskiosken")) {
                    if (!gameboard[5].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[5].getStreetPrice());
                    }
                    move(24 + (5 - currentPlacement) % 24);
                } else {
                    System.out.println("Chance card Gratis felt (lyseblåt) messed up");
                }
                break;
            case 9:
                //System.out.println("Chance card Løslades uden omkostninger kort!");
                usedChanceCards[cardID] = true;
                currentPlayer.changeJailCard(1); //Gives a get out of jail free card.
                break;
            case 10:
                //System.out.println("Chance card Ryk frem til Strandpromenaden");
                usedChanceCards[cardID] = true;
                move(24 + (23 - currentPlacement) % 24); //Move to "Strandpromenaden"
                break;
            case 13:
                //System.out.println("Chance card Alle giver dig 1 mønt");
                usedChanceCards[cardID] = true;
                for (int i = 0; i < numberOfPlayers; i++) { //checks that everyone can afford to pay the player (or game ends)
                    if (players.getPlayer(i).getCoins() < 1) {
                        endGame(players.getPlayer(i));
                    } else { //makes the players who aren't the currentPlayer lose 1 dollar
                        for (int j = 0; j < numberOfPlayers; j++) {
                            if (players.getPlayer(j) != currentPlayer) {
                                players.getPlayer(i).addCoins(-1);
                            }
                        }
                    }
                }
                currentPlayer.addCoins(numberOfPlayers - 1); //gives currentPlayer the money the others paid.
                break;
            case 14:
                //System.out.println("Chance card Gratis felt (pink/mørkeblåt)");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection("Ryk frem til et af de 4 felter og få det gratis hvis det er ledigt!", "Ryk frem til Museet", "Ryk frem til Biblioteket", "Ryk frem til Vandlandet", "Ryk frem til Strandpromenaden"); //Move to orange fields index 10 or 11
                if (selection.equals("Ryk frem til Museet")) {
                    if (!gameboard[7].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[7].getStreetPrice());
                    }
                    move(24 + (7 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Biblioteket")) {
                    if (!gameboard[8].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[8].getStreetPrice());
                    }
                    move(24 + (8 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Vandlandet")) {
                    if (!gameboard[22].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[22].getStreetPrice());
                    }
                    move(24 + (22 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Strandpromenaden")) {
                    if (!gameboard[23].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[23].getStreetPrice());
                    }
                    move(24 + (23 - currentPlacement) % 24);
                } else {
                    System.out.println("chance card Gratis felt (pink/mørkeblåt) messed up");
                }
                break;
            case 15:
                //System.out.println("Chance card Modtag 2 fra banken");
                usedChanceCards[cardID] = true;
                currentPlayer.addCoins(2);
                break;
            case 16:
                //System.out.println("Chance card Gratis felt (rødt)");
                usedChanceCards[cardID] = true;
                selection = gui.getUserSelection("Ryk frem til et af de 2 felter og få det gratis hvis det er ledigt!", "Ryk frem til Spillehallen", "Ryk frem til Biografen"); //Move to orange fields index 10 or 11
                if (selection.equals("Ryk frem til Spillehallen")) {
                    if (!gameboard[13].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[13].getStreetPrice());
                    }
                    move(24 + (13 - currentPlacement) % 24);
                } else if (selection.equals("Ryk frem til Biografen")) {
                    if (!gameboard[14].getOwned()) { //gives the player the price of field if its available (so its free)
                        currentPlayer.addCoins(gameboard[14].getStreetPrice());
                    }
                    move(24 + (14 - currentPlacement) % 24);
                } else {
                    System.out.println("chance card Gratis felt (rødt) messed up");
                }
                break;
            case 17:
                //System.out.println("Chance card Ryk frem til Skaterparken");
                usedChanceCards[cardID] = true;
                if (!gameboard[10].getOwned()) { //gives the player the price of field if its available (so its free)
                    currentPlayer.addCoins(gameboard[10].getStreetPrice());
                }
                move(24 + (10 - currentPlacement) % 24);
                break;
        }

    }

}



