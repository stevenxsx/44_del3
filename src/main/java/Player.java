public class Player {
    public final String name;
    private final Account account;

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
}