
public class Account {
    private static int DEFAULT_COIN_AMOUNT;
    private static final int MIN_COIN_AMOUNT = 0;
    private int coins;

    public Account(int numPlayers) {

        DEFAULT_COIN_AMOUNT = getDefaultCoinAmount(numPlayers);
        coins = DEFAULT_COIN_AMOUNT;
    }

    public boolean addCoins(int amount) {
        coins += amount;
        return coins >= MIN_COIN_AMOUNT;
    }

    public void reset() {
        coins = DEFAULT_COIN_AMOUNT;
    }

    public int getCoins() {
        return coins;
    }

    private int getDefaultCoinAmount(int numPlayers){
        if (numPlayers == 2)
            return DEFAULT_COIN_AMOUNT = 20;
        else if (numPlayers == 3)
            return DEFAULT_COIN_AMOUNT = 18;
        else if (numPlayers == 4)
            return DEFAULT_COIN_AMOUNT = 16;
        else throw new RuntimeException("Fejl x: Forkert antal spillere, antal spillere kan være: 2, 3, og 4.");
    }

    public String toString() {
        return String.valueOf(coins);
    }
}
