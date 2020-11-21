import CDIO2_Game.FieldFactory;
import CDIO2_Game.Game;
import CDIO2_Game.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


import java.awt.*;

public class GUI_Controller {
    int languageIndex = Game.returnLanguage();
    private GUI gui;
    GUI_Player guiPlayer1;
    GUI_Player guiPlayer2;
    GUI_Player guiPlayer3;
    GUI_Player guiPlayer4;
    GameBoard boardFields = new GameBoard();
    void makeGUI() {
        GUI_Field[] fields = FieldStreet.;

        gui = new GUI(fields, Color.gray);
    }
    public void addPlayers(Player p1, Player p2) {

        guiPlayer1 = new GUI_Player(
                p1.getName(),
                p1.getCoins(),
                new GUI_Car(Color.BLACK, Color.GRAY, GUI_Car.Type.RACECAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT));
        gui.addPlayer(guiPlayer1);

        guiPlayer2 = new GUI_Player(
                p2.getName(),
                p2.getCoins(),
                new GUI_Car(Color.WHITE, Color.RED, GUI_Car.Type.UFO, GUI_Car.Pattern.CHECKERED));
        gui.addPlayer(guiPlayer2);
    }

    public void rollDice(Player currentPlayer, int d1, int d2) {
        gui.getUserButtonPressed(currentPlayer.getName() + " press to roll the dice", "roll the dice!");
        gui.setDice(d1, d2);

        for (GUI_Field field: gui.getFields()){
            field.setCar(giveGuiPlayer(currentPlayer), false);
        }

        gui.getFields()[d1-1 + d2-1].setCar(giveGuiPlayer(currentPlayer), true);
        gui.displayChanceCard(gui.getFields()[d1-1 + d2-1].getDescription());
    }

    public void showMessage(String message){
        gui.showMessage(message);
    }

    public String player1Input() {
        return gui.getUserString("Player 1 please enter your name: ");
    }
    public String player2Input() {
        return gui.getUserString("Player 2 please enter your name: ");
    }

    public void updateBalance(Player p1, Player p2) {
        guiPlayer1.setBalance(p1.getCoins());
        guiPlayer2.setBalance(p2.getCoins());
    }

    private GUI_Player giveGuiPlayer(Player player){
        if (player.getName().equalsIgnoreCase(guiPlayer1.getName()))
            return guiPlayer1;
        else
            return guiPlayer2;
    }
}
