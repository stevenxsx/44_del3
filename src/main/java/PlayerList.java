
/*
public class PlayerList {
    private Player[] playerList;

    public PlayerList(int number ) {
        playerList = new Player[number];
        for (int i = 0;i < number;i++)
            playerList[i]=new Playerd();
    }

    public void addPlayer(int antal){
        String[] names = {"Steven","Gordon","Mike","Oline","Katrine ","Simon"};
        for (int i=0; i<antal;i++){
            playerList[i].setName(names[i % names.length]);
            playerList[i].setColor(i);
        }
    }

    public Player[] getPlayers(){ return playerList; }

    public Player getPlayer(int index){
        return playerList[index];
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
}
*/