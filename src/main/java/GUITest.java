import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Field;
import gui_main.GUI;

public class GUITest {
    public static void main(String[] args) {
        GUI_Field[] fields = GUI_Fields.makeGUIFields();
        GUI gui = new GUI(fields);


    }
}
