package CDIO2_Game;

public class GUI_Game {

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    Player player1;
    Player player2;
    Player currentPlayer;
    boolean gameInProgress = true;
    GUI_Controller gui_controller = new GUI_Controller();
    Field[] fields = FieldFactory.makeFields(0);

    public void startGame() {
        gui_controller.makeGUI();
        player1 = new Player(gui_controller.player1Input());
        player2 = new Player(gui_controller.player2Input());
        currentPlayer = player2;
        gui_controller.addPlayers(player1, player2);
        while (gameInProgress){
            if (currentPlayer == player1)
                currentPlayer = player2;
            else {
                currentPlayer = player1;
            }

            gameRound();

        }
       gui_controller.showMessage("CONGRATULATIONS! " + currentPlayer.getName() + " has reached 3000 coins and won the game ");
    }

    private void gameRound() {
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        gui_controller.rollDice(currentPlayer, roll1, roll2);
        currentPlayer.addCoins(fields[roll1+roll2].getValue());
        gui_controller.updateBalance(player1, player2);
        if (currentPlayer.checkWin()) {
            gameInProgress = false;
            return;
        }
        if (roll1 + roll2 == 10) {
            if (currentPlayer == player1)
                currentPlayer = player2;
            else {
                currentPlayer = player1;
            }
        }
    }
}
