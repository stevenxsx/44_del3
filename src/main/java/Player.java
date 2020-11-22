package main.java;
import main.java.Account;

public class Player {
    public final String name;
    private final Account account;
    private int Age;

    public Player(String name, int numPlayers) {
        this.name = name;
        this.account = new Account(numPlayers);
    }

    public boolean addCoins(int amount) {
        return account.addCoins(amount);
    }

    public void resetAccount() {
        account.reset();
    }

    /*  public String getName() {
        return name;
    }  */

    public int getCoins() {
        return account.getCoins();
    }

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

    private boolean isJailed;

    public boolean isJailed() {
        return isJailed;
    }

    public void setJailed(boolean jailed) {
        isJailed = jailed;
    }
}