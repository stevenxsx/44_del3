import gui_fields.*;
import gui_fields.GUI_Field;
import java.awt.*;

public class GUI_Fields {
   static GUI_Field[] fields = new GUI_Field[24]; // moved this line out of makeGui_fields
     static Language l = new Language();

    public static GUI_Field[] makeGUIFields(int j) {

        int i = 0;
        fields[i++] = new GUI_Start(l.start[j], "Modtag M2", l.fieldDescriptionStart[j], Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.burgerbaren[j], "M1", "", "1M", new Color(153, 76,0), Color.BLACK);
        fields[i++] = new GUI_Street(l.pizzeriaet[j], "M1", "", "1M", new Color(153, 76,0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", l.chance[j], l.fieldDescriptionChance[j], Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.slikkebutikken[j], "M1", "", "1M", new Color(0, 204,204), Color.BLACK);
        fields[i++] = new GUI_Street(l.iskiosken[j], "M1", "", "1M", new Color(0, 204,204), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "", l.paaBesoeg[j], "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.museet[j], "M2", "", "2M", new Color(204, 153,235), Color.BLACK);
        fields[i++] = new GUI_Street(l.biblioteket[j], "M2", "", "2M", new Color(204, 153,235), Color.BLACK);
        fields[i++] = new GUI_Chance("?", l.chance[j], l.fieldDescriptionChance[j], Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.skaterparken[j], "M2", "", "2M",  new Color(255, 255,153), Color.BLACK);
        fields[i++] = new GUI_Street(l.svoemmebassenget[j], "M2", "", "2M", new Color(255, 255,153), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "GRATIS", "PARKERING", "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street(l.spillehallen[j], "M3", "", "3M", new Color(153, 0,0), Color.BLACK);
        fields[i++] = new GUI_Street(l.biografen[j], "M3", "", "3M",new Color(153, 0,0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", l.chance[j], l.fieldDescriptionChance[j], Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.legetoejsbutikken[j], "M3", "", "3M", new Color(255, 255,51), Color.BLACK);
        fields[i++] = new GUI_Street(l.dyreHandlen[j], "M3", "", "3M", new Color(255, 255,51), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "", "FÆNGSLET", "", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.bowlinghallen[j], "M4", "", "4M", new Color(76, 153,0), Color.BLACK);
        fields[i++] = new GUI_Street(l.zoo[j], "M4", "", "4M", new Color(76, 153,0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", l.chance[j], l.fieldDescriptionChance[j], Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street(l.vandland[j], "M5", "", "5M", new Color(0, 76,153), Color.BLACK);
        fields[i] = new GUI_Street(l.strandpromonaden[j], "M5", "", "5M", new Color(0, 76,153), Color.BLACK);
        return fields;
    }
}
