import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GUITest {
    public static void main(String[] args) {
        GUI_Field[] fields = GUI_Fields.makeGUIFields(0);
        GUI gui = new GUI(fields, Color.WHITE);


    }
}
