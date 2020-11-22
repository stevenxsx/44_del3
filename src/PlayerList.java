import main.java.Player;

public class PlayerList {
    private Player[] players;

    public PlayerList(int number){
        players = new Player[number];
        for (int i = 0; i < number; i++) {
            players[i] = new Player("john", i);
        }
    }
}
