import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GUI_Controller {
    private int playerCount;
    private PlayerList playerList;

    GUI gui = new GUI();



    public GUI_Controller(int number) {
        playerCount = number;
    }

    public void createPlayers() {
        for (int i = 0;i < playerCount;i++) {
            GUI_Player player1 = new GUI_Player("Apple", (20 - ((playerCount - 2) * 2)));
            gui.addPlayer(player1);

            GUI_Player player2 = new GUI_Player("Bravo", (20 - ((playerCount - 2) * 2)));
            gui.addPlayer(player2);

            GUI_Player player3 = new GUI_Player("Charlie", (20 - ((playerCount - 2) * 2)));
            gui.addPlayer(player3);

            GUI_Player player4 = new GUI_Player("Duff", (20 - ((playerCount - 2) * 2)));
            gui.addPlayer(player4);
        }

    }

    public void makeGUI(){
        GUI_Field[] fields = GUI_FieldFactory.makeFields();

        gui =new GUI(fields, Color.PINK);
    }
    /*public void antalSpillere(PlayerList[] t){ //den skal have fat i en methode med array i.
        player = new GUI_Player[t.length()];
        car = new GUI_Car[t.length];
        for (int i = 0; i < t.length; i++) {
            car[i] = new GUI_Car(Color.RED, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            player[i] = new GUI_Player(t[i],t[i].getCoins(), car[i]);
            gui.addPlayer(player[i]);
        }

    }*/
}