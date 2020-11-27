import gui_fields.GUI_Car;
import gui_fields.GUI_Field;

import java.awt.*;

public class GUI_Cars {
    public static GUI_Car[] makeCars(int numCars) {
        GUI_Car[] cars = new GUI_Car[numCars];
        for (int i = 0; i < numCars; i++) {

            Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
            GUI_Car.Pattern[] patterns = new GUI_Car.Pattern[]{GUI_Car.Pattern.CHECKERED, GUI_Car.Pattern.DIAGONAL_DUAL_COLOR, GUI_Car.Pattern.DOTTED, GUI_Car.Pattern.ZEBRA};

            cars[i] = new GUI_Car(colors[(i + 1) % colors.length], colors[(i + 1) % colors.length], GUI_Car.Type.CAR, patterns[1]);
        }
        return cars;

    }

}
