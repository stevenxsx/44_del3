import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;
/*
public class Main {

    public static void main(String[] args) {
        GUI_Field[] fields = GUI_Fields.makeGUIFields();
        GUI gui = new GUI(fields, Color.DARK_GRAY);
    }
}*/
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}