import gui_fields.GUI_Car;

public class PlayerList {
    private final Player[] playerList;
    String[] stringNames;

    public PlayerList(int number, String[] names) {
        stringNames = new String[names.length];
        System.arraycopy(names, 0, stringNames, 0, names.length);
        playerList = new Player[number];
        for (int i = 0;i < number;i++)
            playerList[i]=new Player(names[i]);
    }

    public void addPlayer(int antal){
        for (int i=0; i<antal;i++){
            playerList[i].setName(stringNames[i % stringNames.length]);
            playerList[i].setColor(i);
        }
    }

    public Player[] getPlayers(){ return playerList; }

    public Player getPlayer(int index){
        return playerList[index];
    }

    public GUI_Car getCar(int index) {
        return playerList[index].getCar();
    }

    public boolean isWinner(){
        for (int i = 0; i< playerList.length; i++){
            if (playerList[i].isWinner())
                return true;
        }



        return false;
    }

    public int nextPlayer(int index){
        index = ++index % playerList.length;
        return index;
    }

    public String toString() {
        StringBuilder returnStatement = new StringBuilder();
        for(int i=0;i<playerList.length;i++) {
            returnStatement.append("Player").append(i).append(" = ").append(playerList[i].getName()).append(".\n");
        }
        return returnStatement.toString();
    }
}
