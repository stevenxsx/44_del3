
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


import java.awt.*;
import java.util.regex.Pattern;



public class GUI_Controller {
    private GUI gui;
    private GUI_Player[] player;
    private GUI_Car[] car;
    private GUI_Field[] field;

public void GUI(){
    this.gui = gui;
    this.field = gui.getFields();
}

}
