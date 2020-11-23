import main.java.Player;

public class PlayerList {
private String name;
private int id;

    public void player2 (String name,  int id){
        this.name = name;
        this.id = id;
    }

    public PlayerList(int number){
        players = new Player[number];
        for (int i = 0; i < number; i++) {
            players[i] = new Player("john", i);
        }
    }
}
