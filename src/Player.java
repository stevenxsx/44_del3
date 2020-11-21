public class Player {
    private String Name;
    private int Age;
    private final Account Account;
    private String Piece;
    //ikke færdig lavet taget som standart indhold i player + import hvis behov

    public player(String Name){
        this.Name = Name;
        this.Account = new Account()
        /* Antal spillere bliver en variabel som hjælper med at beslutte antalet af penge
        hver spiller får ud fra det hele antal spillere der er.
         */

    }
}

    public void addCoins(int amount) {

        Account.addCoins(amount);
        }


    public String getName() {

        return Name;
}

    public int getCoins() {

        return Account.getCoins();