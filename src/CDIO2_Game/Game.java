package CDIO2_Game;

import java.util.Scanner;

public class Game {

    Scanner typeName = new Scanner(System.in);
    Scanner typeLanguage = new Scanner(System.in);
    Scanner typeEnter = new Scanner(System.in);
    String typedText;
    String typedLanguage;

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    int diceTotal = 0;
    Player player1;
    Player player2;
    Player currentPlayer;
    boolean gameInProgress = true;
    Field[] list_of_fields;
    private static int selectedLanguage;
    Language language = new Language();

    public void startGame() {
        System.out.println("Please select a language. Type 0 for English");
        typedLanguage = typeLanguage.nextLine();
        if (typedLanguage.equals("0")) { //Add more statements for additional languages
            selectedLanguage = Integer.parseInt(typedLanguage);
        }
        else selectedLanguage = 0;
        list_of_fields = FieldFactory.makeFields(selectedLanguage);
        welcomeMessage();

        System.out.println(language.textInputName[selectedLanguage] + "1");
        String name1 = typeName.nextLine();
        player1 = new Player(name1);

        System.out.println(language.textInputName[selectedLanguage] +"2");
        String name2 = typeName.nextLine();
        player2 = new Player(name2);

        System.out.println(language.textContinue[selectedLanguage]);


        while (gameInProgress) { //Keeps game going until gameWon is called
                round();
        }
    }

    public void welcomeMessage() {
       System.out.println(language.welcomeMessage[selectedLanguage]);

    }

    public void round() {
        typedText = typeEnter.nextLine();
        if (typedText.equals("")) {
            System.out.println("\n\n----------------------------------------------");
            currentPlayer = player1;
            turn();
        }
        else if (typedText.equals("exit") || typedText.equals("ff") || typedText.equals("tactical retreat")) {
            System.out.println(language.forfeit[selectedLanguage]);
            typedText = typeEnter.nextLine();
            if (typedText.equals("yes") || typedText.equals("yep") || typedText.equals("y") || typedText.equals("im a loser")) {
                System.exit(0);
            }
        }

        typedText = typeEnter.nextLine();
        if (typedText.equals("")) {
            System.out.println("\n\n----------------------------------------------");
            currentPlayer = player2;
            turn();
        }
        else if (typedText.equals("exit") || typedText.equals("ff") || typedText.equals("tactical retreat")) {
            System.out.println(language.forfeit[selectedLanguage]);
            typedText = typeEnter.nextLine();
            if (typedText.equals("yes") || typedText.equals("yep") || typedText.equals("y") || typedText.equals("im a loser")) {
                System.exit(0);
            }
        }
    }

    public void turn() {
        roll();
        System.out.println(currentPlayer.getName() + " " + language.rolled[selectedLanguage] + " " + diceTotal + " " + language.approaches[selectedLanguage] + " " + list_of_fields[diceTotal].getTitle());
        System.out.println(list_of_fields[diceTotal].getDescription());
        currentPlayer.addCoins(list_of_fields[diceTotal].getValue());
        System.out.println(language.youNowHave[selectedLanguage] + " " + currentPlayer.getCoins() + " " + language.coins[selectedLanguage]);

        if (list_of_fields[diceTotal].getExtraTurn()) {
            System.out.print("\n");
            turn();
        }
        checkForWin();

    }
    public void roll() {
        dice1.roll();
        dice2.roll();
        diceTotal = dice1.getEyeValue()+dice2.getEyeValue();
    }
    public void checkForWin() {
        if (currentPlayer.checkWin()) {
            System.out.println("\n\n==========================================");
            System.out.println(language.congratulations[selectedLanguage] + " " + currentPlayer.getName() + " " + language.hasReached[selectedLanguage]);
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }
            else currentPlayer = player1;
            System.out.println(currentPlayer.getName() + " " + language.onlyHad[selectedLanguage] + " " + currentPlayer.getCoins() + " " + language.coinsFrowney[selectedLanguage]);
            System.out.println("==========================================\n");
            System.exit(0);
        }
    }

    public static int returnLanguage() {
        return selectedLanguage;
    }

}

