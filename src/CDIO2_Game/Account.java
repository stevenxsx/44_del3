package CDIO2_Game;




public class Account {

    private final int MAX_COIN_AMOUNT;
    private final int DEFAULT_COIN_AMOUNT;
    private final int MIN_COIN_AMOUNT;
    private int coins;
    /* public Account(){
        this(3000, 0, 0);
    }
    I will suggest adding this in the future - Kat
    */
    public Account(int maxCoinAmount, int defaultCoinAmount, int minCoinAmount) {
        this.MAX_COIN_AMOUNT = maxCoinAmount;
        this.DEFAULT_COIN_AMOUNT = defaultCoinAmount;
        this.MIN_COIN_AMOUNT = minCoinAmount;
        coins = DEFAULT_COIN_AMOUNT;
    }
    public void addCoins(int amount) {

        coins += amount;
        if (coins < MIN_COIN_AMOUNT) {
            coins = MIN_COIN_AMOUNT;
        } else if (coins > MAX_COIN_AMOUNT) {
            coins = MAX_COIN_AMOUNT;
        }
    }


    public void reset() {

        coins = DEFAULT_COIN_AMOUNT;
    }

    public boolean isFull() {
        return coins >= MAX_COIN_AMOUNT;
    }

    public int getCoins() {

        return coins;
    }

    public String toString() {
        return String.valueOf(coins);
    }
}
