public class Account {
    private final int Defult_Coin_Amount;
    private final int Min_Coin_Amount;
    private int coins
}

    public Account(int defualtcoinamount, int mincoinamount){
        this.Defult_Coin_Amount = defualtcoinamount;
        this.Min_Coin_Amount = mincoinamount;
        coins = Defult_Coin_Amount;
    }

    public int getCoins(){
        return coins;
    }

    /*public void addCoins(int amount) {

        coins += amount;
        if (coins < MIN_COIN_AMOUNT) {
            coins = MIN_COIN_AMOUNT;
        } else if (coins > MAX_COIN_AMOUNT) {
            coins = MAX_COIN_AMOUNT;
     */ //Maybe adding this not sure yet until a discussion when a player loses
