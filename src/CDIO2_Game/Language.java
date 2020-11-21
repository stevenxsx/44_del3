package CDIO2_Game;

public class Language {

    //Add indexes to the arrays with translated text.
    //Index 0 = English, Index 1 = Danish, Index 2 = German, etc.
    public String language = "Index 0 = English, Index 1 = Danish, Index 2 = German,";

    //Strings for welcomeMessage()
    public String[] welcomeMessage = {"Welcome to the Game\n" +
            "The players each roll a set of dice, where the outcome depends on the luck of the dice.\n" +
            "You can gain and lose coins, as well as potentially receive an extra turn.\n" +
            "You win the game if you collect 3000 coins.\n" };

    //Strings for makeFields()
    public String[] fieldDescriptionTower = {"Congratulations! You reached the top of the tower and found a bag filled with money! You get 250 coins"};
    public String[] fieldDescriptionCrater = {"Oh no! You fell into a crater and need to buy your way out with 100 coins"};
    public String[] fieldDescriptionPalaceGates = {"BE PROUD! You kept the palace safe overnight and have been rewarded 100 coins for your bravery"};
    public String[] fieldDescriptionColdDesert = {"NOT AGAIN…! You forgot your jacket and will have to buy one for 20 coins to survive your trip in the cold desert"};
    public String[] fieldDescriptionWalledCity = {"YAY! You managed to climb over the walls and enter the walled city and a bystander gave you 180 coins for your amazing climbing skills"};
    public String[] fieldDescriptionMonastery = {"Guess what?? You found a monastery where you can take shelter for the night free of charge. Money has no value here"};
    public String[] fieldDescriptionBlackCave = {"HELP! You found yourself lost in a cold, black cave. You pay a caveman 70 coins to guide you out."};
    public String[] fieldDescriptionHutsMountain = {"LUCKY YOU! You found an abandoned hut in the mountains filled with food, water, and 60 coins"};
    public String[] fieldDescriptionWerewall = {"AAAAUUUU! You tried chasing a werewolf  but accidentally ran into a wall and dropped 80 coins, but don't worry, you get to roll again"};
    public String[] fieldDescriptionThePit = {"Oh dang! You just dropped 50 coins in the pit and can't get them back!"};
    public String[] fieldDescriptionGoldMine = {"PARTYTIME! You dug out a gold nugget and sold it for 650 coins"};

    //Strings for startGame()
    public String[] textInputName = {"Input a name for Player"};
    public String[] textContinue = {"Press enter to start and continue the game"};

    //Strings for turn()
    public String[] rolled = {"rolled"};
    public String[] approaches = {"and approaches the"};
    public String[] youNowHave = {"You now have"};
    public String[] coins = {"coins!"};

    //Strings for round()
    public String[] forfeit = {"Are you sure you want to forfeit the game? (Type \"y\" to confirm"};


    //Strings for checkForWin()
    public String[] congratulations = {"CONGRATULATIONS!"};
    public String[] hasReached = {"has reached 3000 coins and won the game"};
    public String[] onlyHad = {"only had"};
    public String[] coinsFrowney = {"coins :("};



}
