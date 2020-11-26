import gui_fields.*;
import gui_main.*;

import java.awt.*;
import java.util.Scanner;

public class Game {

    //opretter og instantiere arrayLister og variabler

    private GUI_Fields guiBoard = new GUI_Fields();

    private GUI_Field[] fields = guiBoard.makeGUIFields();

    private GUI gui = new GUI(fields, new Color(222, 222, 222));

    GUI_Car[] G_cars = GUI_Cars.makeCars();

    Dice die = new Dice();

    int newField;

    int oldField;

    Boolean gameOver = false;

    //De næste to linjer henter vores arraylist fra GameBoardController klassen:

    GameBoard gameBoard = new GameBoard();

    Field[] board = gameBoard.getArray();

    Scanner typeName = new Scanner(System.in);
    Scanner typeLanguage = new Scanner(System.in);
    Scanner typeEnter = new Scanner(System.in);
    String typedText;
    String typedLanguage;
int numberOfPlayers;

    Player player1;
    Player player2;
    Player currentPlayer;
    boolean gameInProgress = true;
    Field[] list_of_fields;
    private static int selectedLanguage;
    Language language = new Language();

    public void startGame() {
        System.out.println("Please select a language. Type 0 for English");
        // typedLanguage = typeLanguage.nextLine();
        typedLanguage = "0";
        if (typedLanguage.equals("0")) { //Add more statements for additional languages
            selectedLanguage = Integer.parseInt(typedLanguage);
        } else selectedLanguage = 0;

        //list_of_fields = FieldFactory.makeFields(selectedLanguage);
        welcomeMessage();

        //Valg af antal spillere inde i GUI
        String players = gui.getUserSelection("Vælg antal spillere", "2", "3", "4");
        numberOfPlayers = Integer.parseInt(players);


        //Skaber arrays for navne, spillere og GUI spillere.
        String[] allNames = new String[numberOfPlayers];
        Player[] arrayPlayers = new Player[numberOfPlayers];
        GUI_Player[] guiPlayers = new GUI_Player[numberOfPlayers];

        //adder navne, adder spillere til listen og setup GUI
        SetupGame(numberOfPlayers, allNames, arrayPlayers, guiPlayers);


        //Select number of players (2-4)
        /** det her lort burde virke.......
         *  String spillere = gui.getUserSelection("Vælg antal spillere", "3", "4", "5", "6");
         */
        //For-loop inputting the names into (player# = new Player(input))

        //Do stuff that sets up the GUI and puts all the players pieces at start, set their starting cash, etc etc.

        while (!gameOver) { //Keeps game going until gameWon is called

            //for-loopet der skal styrer tur-systemet
            for (int i = 0; i < arrayPlayers.length; i++) {


                //Her skal spillernes position baseret på terninger
                int diceSum = handleMovement(allNames[i], arrayPlayers[i], guiPlayers[i], die);

                //de her skal håndtere hvad der sker når en spiller lander på et felt
                i = handleLandOnField(allNames, arrayPlayers, guiPlayers, i, diceSum);

                //den her skal opdatere spillernes position for alle spillere:
                updateGUIMoney(arrayPlayers, guiPlayers);

                //tjekker om den nuværende spiller skal i fængsel
                if (arrayPlayers[i].getJailed()) {
                    handleJailOptions(allNames[i], arrayPlayers[i], guiPlayers[i]);
                }
                //Den her skal tjekke om spillet er færdigt, ved at undersøge om en af spillerne er gået fallit.
                if (handleGameDone(arrayPlayers)) {
                    gui.getUserButtonPressed("Vi har en taber, spilleren med højeste pengebeholdning er VINDEREN", "Fortsæt");
                    break;
                }
            }

        }
        //"Spillet er slut, spilleren med det højeste antal point har vundet."
    }

    private void handleJailOptions(String allNames, Player arrayPlayer, GUI_Player guiPlayer) {
        while (arrayPlayer.getJailed()) {
            String jailMsg = gui.getUserButtonPressed(allNames + " har 2 muligheder", "Fængsel kort", "betal");

            if (jailMsg.equals("Fængsel kort")) {
                if (arrayPlayer.getNumberOfEscapeCards() >= 1) {
                    arrayPlayer.minusJailCard(1);
                    gui.getUserButtonPressed(allNames + " har nu brugt 1 fængselskort og har " + arrayPlayer.getNumberOfEscapeCards() + " tilbage. Tryk 'fortsæt' for at komme ud.", "Fortsæt");
                    arrayPlayer.setJailed(false);
                } else {
                    gui.getUserButtonPressed(allNames + " har ingen fri for fængselkort", "Fortsæt");
                    continue;
                }
            } else if (jailMsg.equals("betal")) {
                arrayPlayer.addCoins(-1);
                guiPlayer.setBalance(arrayPlayer.getCoins());
                arrayPlayer.setJailed(false);
            }


        }
    }


    private void SetupGame(int players, String[] allNames, Player[] arrayPlayers, GUI_Player[] guiPlayers) {
        //Valg af navne
        for (int i = 0; i < players; i++) {
            Boolean nameAlreadyExist = true;
            Boolean foundMatch = false;
            String name = null;

            while (nameAlreadyExist) {
                name = gui.getUserString("Spiller " + (i + 1) + "'s navn?");
                name = name.trim();

                //tjekker om spilleren har indtastet et tomt navn
                if (name.equals("")) {
                    gui.getUserButtonPressed("Du SKAL vælge et navn", "Fortsæt");
                } else {
                    if (name.length() > 16) {
                        gui.getUserButtonPressed("Navnet er for langt (max 16 symboler)", "Fortsæt");
                    } else {
                        //tjekker om det valgte navn matcher en af de andres navne
                        for (int k = 0; k < allNames.length; k++) {
                            if (name.equals(allNames[k])) {
                                foundMatch = true;
                            }
                        }

                        if (foundMatch) {
                            gui.getUserButtonPressed("Dette navn er allerede taget, vælg et andet", "Fortsæt");
                            foundMatch = false;
                        } else if (!foundMatch) {
                            nameAlreadyExist = false;
                        }
                    }
                }
            }
            //adder navnet til arrayet
            allNames[i] = name;
        }

        //adder spillerne til Listen
        for (int i = 0; i < allNames.length; i++) {
            Player p = new Player(allNames[i], 0, 0, false,numberOfPlayers/*,false*/);
            arrayPlayers[i] = p;
        }

        //skal lave en metode der skaber gui_brikker/spillerne på boardet
        for (int i = 0; i < arrayPlayers.length; i++) {
            guiPlayers[i] = (new GUI_Player(arrayPlayers[i].getName(), arrayPlayers[i].getCoins(), G_cars[i]));
            gui.addPlayer(guiPlayers[i]);
            fields[0].setCar(guiPlayers[i], true);

        }

    }

    private int handleMovement(String allNames, Player arrayPlayer, GUI_Player guiPlayer, Dice die) {


        int diceSum = die.roll();


        gui.getUserButtonPressed("Spiller " + allNames + "'s tur til at kaste", "Fortsæt");
        gui.setDie(diceSum);


        oldField = arrayPlayer.getPosition();
        fields[oldField].setCar(guiPlayer, false);
        arrayPlayer.setPosition(arrayPlayer.getPosition() + diceSum);


        if (arrayPlayer.getPosition() >= fields.length) {
            arrayPlayer.setPosition(arrayPlayer.getPosition() - fields.length);
            arrayPlayer.addCoins(2);

            guiPlayer.setBalance(arrayPlayer.getCoins());

        }
        newField = arrayPlayer.getPosition();
        fields[newField].setCar(guiPlayer, true);
        return diceSum;
    }

    private int handleLandOnField(String[] allNames, Player[] arrayPlayers, GUI_Player[] guiPlayers, int i, int diceSum) {
        Field currentField;
        Field otherField;
        do {
            currentField = board[arrayPlayers[i].getPosition()];
            if (currentField instanceof ChanceCardController) {
                ChanceCardController chanceField = (ChanceCardController) currentField;
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

        return i;
    }


    private int handleChanceCard(Player[] arrayPlayers, int i, Field currentField, ChanceCardController chanceField, GUI_Player guiPlayer) {
        //opdatere bilernes position i tilfæde af at en af chancekortene rykker en spiller
        oldField = arrayPlayers[i].getPosition();
        i = chanceField.getCard(arrayPlayers[i], gui, i, arrayPlayers.length, arrayPlayers);
        //hvis spilleren bliver sendt til jail, så køre goToJail-metoden.
        currentField = board[arrayPlayers[i].getPosition()];
        if (currentField instanceof FieldJail) { ((FieldJail) currentField).goToJail(arrayPlayers[i]); }
        fields[oldField].setCar(guiPlayer, false);
        newField = arrayPlayers[i].getPosition();
        fields[newField].setCar(guiPlayer, true);
        guiPlayer.setBalance(arrayPlayers[i].getCoins());
        return i;
    }

    private void handleJailField(Player arrayPlayer, GUI_Player guiPlayer, FieldJail jailField) {
        oldField = arrayPlayer.getPosition();
        fields[oldField].setCar(guiPlayer, false);
        jailField.goToJail(arrayPlayer);
        newField = arrayPlayer.getPosition();
        fields[newField].setCar(guiPlayer, true);
    }

    private void handleStreet(String allNames, Player arrayPlayer, GUI_Player guiPlayer, FieldStreet street) {
        //Når feltet ikke er owned
        if (!street.getOwned()) {
            arrayPlayer.subtractMoney(street.getStreetPrice());
            street.setOwner(arrayPlayer);
            street.setOwned(true);
            fields[arrayPlayer.getPosition()].setSubText(allNames);
            guiPlayer.setBalance(arrayPlayer.getCoins());

        }

        //når feltet er owned
        else if (street.getOwned()) {
            if (arrayPlayer != street.getOwner()) {
                // Når man ejer begge at streetfelterne
                if (street.getMaxOwned() == gameBoard.streetOwnershipCounter(street.getOwner(), street.getType()) && !street.getHasChecked()) {
                    street.setRentPrice(street.getStreetPrice() * 2);
                    street.setHasChecked(true);
                }

                //her betales lejen til ejeren
                gui.getUserButtonPressed("Du skal betale leje: " + "M" + street.getRentPrice(), "Fortsæt");
                arrayPlayer.subtractMoney(street.getRentPrice());
                street.getOwner().addCoins(street.getRentPrice());
                guiPlayer.setBalance(arrayPlayer.getCoins());
            }
        }
    }

    private boolean handleGameDone(Player[] arrayPlayers) {
        for (int i = 0; i < arrayPlayers.length; i++) {
            if (arrayPlayers[i].getCoins() < 1) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    private void updateGUIMoney(Player[] arrayPlayers, GUI_Player[] guiPlayers) {

        for (int i = 0; i < arrayPlayers.length; i++) {
            guiPlayers[i].setBalance(arrayPlayers[i].getCoins());
        }

    }


    public void welcomeMessage() {
        System.out.println(language.welcomeMessage[selectedLanguage]);

    }
/*
    public void round() {
        //for-loop each player, call turn()

        public void turn () {
            //roll the die and instantly move that far.
            //check if you passed start, and what you landed on.
            //Do stuff depending on where you landed:
            //1. Property: buy if its not owned, and pay the owner if it is. Do nothing if you own it. Remember double pay if a player owns all of a color group.
            //2. Special fields: Start, Chance, Go to Jail, Just visiting haha. Free parking.
            // MAKE SURE TO CHECK IF YOU CAN AFFORD TO DO EACH AND EVERY ACTION. call endGame() if you can't

            public void endGame () {
                //players count all their money. the one with most wins the game. If there is a tie, count the value of each players'
                //property and the highest wins. If that's also a tie, then fight to the death by fist.
            }

            public static int returnLanguage () {
                return selectedLanguage;
            }

        }
    }*/

}


