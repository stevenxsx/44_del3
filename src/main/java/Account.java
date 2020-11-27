
public class Account {
    private static int DEFAULT_COIN_AMOUNT = 200;
    private static final int MIN_COIN_AMOUNT = 0;
    private int coins;

    public Account(int numPlayers) {

        DEFAULT_COIN_AMOUNT = getDefaultCoinAmount(numPlayers);
        coins = DEFAULT_COIN_AMOUNT;
    }


    public void addCoins(int amount) {
        coins += amount;
    }

    public void setCoins(int amount) {
        coins = amount;
    }

    public int getCoins() {
        return coins;
    }

    public void reset() {
        coins = DEFAULT_COIN_AMOUNT;
    }

    private int getDefaultCoinAmount(int numPlayers){
        return (DEFAULT_COIN_AMOUNT-((numPlayers-2)*2));
    }

    public String toString() {
        return String.valueOf(coins);
    }
}
