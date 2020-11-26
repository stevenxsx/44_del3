import gui_fields.GUI_Car;
import gui_fields.GUI_Field;

import java.awt.*;

public class GUI_Cars {
    public static GUI_Car[] makeCars() {
        GUI_Car[] cars = new GUI_Car[4];
        cars[0] = new GUI_Car(Color.RED, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
        cars[1] = new GUI_Car(Color.YELLOW, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
        cars[2] = new GUI_Car(Color.GREEN, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
        cars[3] = new GUI_Car(Color.BLUE, Color.cyan, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
        return cars;
    }
}
