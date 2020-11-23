
import java.util.Scanner;

public class Game {

    Scanner typeName = new Scanner(System.in);
    Scanner typeLanguage = new Scanner(System.in);
    Scanner typeEnter = new Scanner(System.in);
    String typedText;
    String typedLanguage;

    Dice dice1 = new Dice();
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
        } else selectedLanguage = 0;

        list_of_fields = FieldFactory.makeFields(selectedLanguage);
        welcomeMessage();

        //Select number of players (2-4)
        //For-loop inputting the names into (player# = new Player(input))

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



