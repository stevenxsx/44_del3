import gui_fields.GUI_Car;

public class Player {
    private String name;
    private Account account;
    private int Age;
    private int color;
    private boolean isWinner;
    private GUI_Car car = new GUI_Car();
    private int getOutOfJailFreeCards = 0;

    public Player(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void addCoins(int amount) { account.addCoins(amount); }

    public void resetAccount() {
        account.reset();
    }

    /*  public String getName() {
        return name;
    }  */

    public int getCoins() {
        return account.getCoins();
    }

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


        // SIMON

    //Vi skal have en position og en boolean for om man er i fængsel ;)
    private int playerPosition;

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
        /*if (playerPosition + amount > 23) { // Making sure players can go in circles.
            amount = playerPosition + amount - 23;
            setPlayerPosition(0);
        }
        setPlayerPosition(playerPosition + amount);*/
        //det ovenover kan skrives sådan her.
        playerPosition = ((playerPosition + amount) % 23);
    }

    public int getPlayerPosition() { return playerPosition; }

    private boolean isJailed = false;

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