import gui_fields.*;
import gui_fields.GUI_Field;
import java.awt.*;

public class GUI_Fields {
    public static GUI_Field[] makeGUIFields() {
        GUI_Field[] fields = new GUI_Field[24];
        int i = 0;
        fields[i++] = new GUI_Start("Start", "Modtag M2", "Modtag M2 fra Banken, hver gang passerer eller lander på START", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("BURGER-\nBAREN", "", "", "1M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("PIZZA-\nHUSET", "", "", "1M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "CHANCE", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("SLIK-\nBUTIKKEN", "", "", "1M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("ISKIOSKEN", "", "", "1M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Jail("default", "", "PÅ BESØG", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("MUSEET", "", "", "2M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("BIBLIOTEKT", "", "", "2M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "CHANCE", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("SKARTER-\nPARKEN", "", "", "2M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("SWIMMING-\nPOOLEN", "", "", "2M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "GRATIS", "PARKERING", "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("SPILLE-\nHALLEN", "", "", "3M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("KINOEN", "", "", "3M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "CHANGE", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("LEGETØJS-\nBUTIKKEN", "", "", "3M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("DYREHAND-\nLEN", "", "", "3M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Jail("default", "", "FÆNGSLET", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("BOWLING-\nHALLEN", "", "", "4M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("ZOO", "", "", "4M", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "CHANCE", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("VAND-\nLANDET", "", "", "5M", Color.WHITE, Color.BLACK);
        fields[i] = new GUI_Street("STRAND-\nPROMENADEN", "", "", "5M", Color.WHITE, Color.BLACK);
        return fields;
    }
}
