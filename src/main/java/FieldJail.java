public class FieldJail extends Field {
    Player player;
    private int timer;

    public FieldJail(){}

    //sender spilleren til fængslet, og lavet et klad der kan bruges i Game klassen.
    public void goToJail(Player player){
        this.player=player;
        player.setPlayerPosition(10);
        this.timer=0;
        player.setJailed(true);
    }

}