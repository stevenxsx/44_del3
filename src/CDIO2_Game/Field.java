package CDIO2_Game;

public class Field {
    private int fieldNumber;
    private String title;
    private String description;
    private int value;
    private boolean extraTurn;

    public Field(int fieldNumber, String title, String description, int value, boolean extraTurn) {
        this.fieldNumber = fieldNumber;
        this.title = title;
        this.description = description;
        this.value = value;
        this.extraTurn = extraTurn;
    }

    public String getTitle() {
        return title;
    }
    public int getFieldNumber() {
        return fieldNumber;
    }
    public String getDescription() {
        return description;
    }
    public int getValue() {
        return value;
    }
    public Boolean getExtraTurn() {
        return extraTurn;
    }

    public String toString(){ return (fieldNumber + " " + title + ": " + value + " double: " + extraTurn);

    }
}
