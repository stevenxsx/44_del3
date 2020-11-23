
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


import java.awt.*;
import java.util.regex.Pattern;

/**
 * public class GUI_Controller {
 *
 *     private GUI_Field[] fields= new GUI_Controller[23];
 *
 *     public GUI_Controller(){
 *         hvert felt
 *         fields[0] = new GUI_Start();
 *          fields[1] = new GUI_Street();
 *             fields[2] = new GUI_Street();
 *               fields[3] = new GUI_Chance();
 *     }
 *     public GUI_Controller[] gameFields(){return fields;}
 *     }
 */


public class GUI_Controller {
    private GUI gui;
    private GUI_Player[] player;
    private GUI_Car[] car;
    private GUI_Field[] field;

public void GUI(){
    this.gui = gui;
    this.field = gui.getFields();
}

    public void makeGUI(){// method to make GUI Board.
        GameBoard test = new GameBoard();

        for (int i = 0; i < test.GameBoard().length; i++) {
            Field field = test.getGameBoardList(i);
        }
        gui = new GUI(field, Color.CYAN);

    }
   /* public void antalPlayers(PlayerList[] t){ //den skal have fat i en methode med array i.
        player = new GUI_Player[t.length];
        car = new GUI_Car[t.length];
        for (int i = 0; i < t.length; i++) {
            car[i] = new GUI_Car(Color.RED, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            player[i] = new GUI_Player(t[i],t[i].(), car[i]);
            gui.addPlayer(player[i]);
        }

    }*/

    //public void rollDice();
}
