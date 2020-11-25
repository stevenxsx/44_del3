
public class Player {
    private String name;
    private Account account;
    private int Age;
    private int color;
    private boolean isWinner;
    private int numberOfEscapeCards;
    private int position;
    private int coins;

    public Player(String name, int position, int coins, int numberOfEscapeCards/*, int account*/) {
        this.name=name;
        this.position=position;
        this.coins = coins;
        this.numberOfEscapeCards = numberOfEscapeCards;

    }

    //Henter Strengen "navn"
    public String getName() {
        return name;
    }

    //Henter int'et "coins"
    public int getcoins() {
        return coins;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int setPosition){position= setPosition; }

    public Account getAccount() {
        return account;
    }

    //public boolean addCoins(int amount) {
    //    return account.addCoins(amount);
    //}

    public void resetAccount() {
        account.reset();
    }

    /*  public String getName() {
        return name;
    }  */

    public int getCoins() {
        return coins;
    }

    //Plusser
    public void addCoins(int totalPoint) {
        coins = coins + totalPoint;
    }

    //Minusser
    public void subtractMoney(int totalPoint) {
        coins = coins - totalPoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isWinner() { return isWinner; }


        // SIMON

    //Vi skal have en position og en boolean for om man er i fængsel ;)
    public int setNumberOfEscapeCards(int number) {
        numberOfEscapeCards = number;
        return numberOfEscapeCards;
    }
    public int getNumberOfEscapeCards(){return numberOfEscapeCards;}

    public void minusJailCard (int number) {
        numberOfEscapeCards = numberOfEscapeCards - number;}

    private boolean isJailed;

    public boolean isJailed() {
        return isJailed;
    }

    public void setJailed(boolean jailed) {
        isJailed = jailed;
    }

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
    public void movePlayerPosition(int amount){
        if (playerPosition + amount > 23) { // Making sure players can go in circles.
            amount = playerPosition + amount - 23;
            setPlayerPosition(0);
        }
        setPlayerPosition(playerPosition + amount);
    }

    public int getPlayerPosition() {

        return playerPosition;
    }

}