package CDIO2_Game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import CDIO2_Game.Field;
import java.awt.*;

public final class FieldFactory {

    public static GUI_Field[] makeGUIFields(int languageIndex) {
        gui_fields.GUI_Field[] fields = new GUI_Field[11];
        int i = 0;
        Language language = new Language();
        fields[i++] = new GUI_Street("Tower", "+250", language.fieldDescriptionTower[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Crater", "-100", language.fieldDescriptionCrater[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Palace Gates", "+100", language.fieldDescriptionPalaceGates[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Cold Desert", "-20", language.fieldDescriptionColdDesert[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Walled City", "+180", language.fieldDescriptionWalledCity[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Monastery", "0", language.fieldDescriptionMonastery[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Black Cave", "-70", language.fieldDescriptionBlackCave[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("Huts in the Mountain", "+60", language.fieldDescriptionHutsMountain[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("The Were-wall", "-80/Extra Turn", language.fieldDescriptionWerewall[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i++] = new GUI_Street("The Pit", "-50", language.fieldDescriptionThePit[languageIndex], "", Color.WHITE, Color.BLUE);
        fields[i] = new GUI_Street("Goldmine", "+650", language.fieldDescriptionGoldMine[languageIndex], "", Color.WHITE, Color.BLUE);

        return fields;
    }

    public static  Field[] makeFields(int languageIndex) {
        Field[] fields = new Field[13];
        int i = 2;
        Language language2 = new Language();
        fields[i++] = new Field(2, "Tower", language2.fieldDescriptionTower[languageIndex], 250, false);
        fields[i++] = new Field(3, "Crater",language2.fieldDescriptionCrater[languageIndex], -100, false);
        fields[i++] = new Field(4, "Palace Gates", language2.fieldDescriptionPalaceGates[languageIndex], 100, false);
        fields[i++] = new Field(5, "Cold Desert", language2.fieldDescriptionColdDesert[languageIndex], -20, false);
        fields[i++] = new Field(6, "Walled City", language2.fieldDescriptionWalledCity[languageIndex], 180, false);
        fields[i++] = new Field(7, "Monastery", language2.fieldDescriptionMonastery[languageIndex], 0, false);
        fields[i++] = new Field(8, "Black Cave", language2.fieldDescriptionBlackCave[languageIndex], -70, false);
        fields[i++] = new Field(9, "Huts in the Mountain", language2.fieldDescriptionHutsMountain[languageIndex], 60, false);
        fields[i++] = new Field(10, "The Were-wall", language2.fieldDescriptionWerewall[languageIndex], -80, true);
        fields[i++] = new Field(11, "The pit", language2.fieldDescriptionThePit[languageIndex], -50, false);
        fields[i] = new Field(12, "Goldmine", language2.fieldDescriptionGoldMine[languageIndex], 650, false);


        return fields;
    }

}