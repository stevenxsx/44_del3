//package Game;    out-commented until Game is created and can be added

public class Dice {
    private final int MAX = 6;
    private int eyeValue;

    public int roll(){

        eyeValue = (int)(Math.random() * MAX) + 1;

        return eyeValue;
    }
    //public int getEyeValue() {
    //    return eyeValue;
    //}
}