import gui_fields.GUI_Car;

public class Player extends Account {
    private String name;
    private Account account;
    private int Age;
    private int color;
    private boolean isWinner;
    private GUI_Car car = new GUI_Car();
    private int getOutOfJailFreeCards = 0;
    private boolean passedGoThisTurn = false;
    private int playerPosition = 0;
    private boolean isJailed = false;

    public Player(String name, int numPlayers) {
        super(numPlayers);
        this.name = name;

    }

 /*   public Account getAccount() {
        return account;
    }

    public void resetAccount() {
        account.reset();
    }

    public int getCoins() {
        return account.getCoins();
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    public GUI_Car getCar() {
        return car;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isWinner() { return isWinner; }

    public void setPlayerPosition(int position){
        if (position < 0) {
            playerPosition = 0;
        } else if (position > 23) {
            playerPosition = 0;
        }
        else
            playerPosition = position;
    }

    /**
     * method used to move player positions, as well as making sure it continues to move after one round.
     * @param amount number of fields to move
     */
    public void movePlayer(int amount){
        int prevPosition = playerPosition;
        playerPosition = ((playerPosition + amount) % 23);
        if (prevPosition > playerPosition) {
            passedGoThisTurn = true;
        }
    }

    public boolean hasPassedGoThisTurn() {
        return passedGoThisTurn;
    }

    public void endTurn() {
        passedGoThisTurn = false;
    }

    public int getPlayerPosition() { return playerPosition; }

    public boolean isJailed() {
        return isJailed;
    }

    public void setJailed(boolean jailed) { isJailed = jailed; }

    public boolean hasJailCard() {
        return getOutOfJailFreeCards > 0;
    }

    public void changeJailCard(int cards) {
        getOutOfJailFreeCards = getOutOfJailFreeCards + cards;
    }
}