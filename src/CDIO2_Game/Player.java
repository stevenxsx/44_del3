package CDIO2_Game;


public class Player {
    private String name;
    private final Account account;

    public Player(String name) {
        this.name = name;
        this.account = new Account(3000, 1000, 0);
    }

    public boolean checkWin() {
        //form for vinder besked til spiller x
        return account.isFull();
    }


    public void addCoins(int amount) {

        account.addCoins(amount);
    }

    public void resetAccount() {

        account.reset();
    }

    public String getName() {

        return name;
    }

    public int getCoins() {

        return account.getCoins();
    }

    /*
    private int points;
   // private final int maxPoints = 3000;
    private int lastRoll;
    private int currentRoll;

    public int getPoints() {
        return points;
    }

    public void changePoints(int points) {
        this.points += points;
        if (this.points >= maxPoints) {
            this.points = maxPoints;
        }
    }
    public void setRoll(int roll) {
        this.lastRoll = this.currentRoll;
        this.currentRoll = roll;
    }
    public int getLastRoll() { return this.lastRoll;}
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

     */
}
