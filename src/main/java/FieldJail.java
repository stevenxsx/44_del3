public class FieldJail extends Field {
    Player player;
   

    public FieldJail(){}

    //sender spilleren til fængslet, og lavet et klad der kan bruges i Game klassen.
    public void goToJail(Player player){
        this.player=player;
        player.setPlayerPosition(10);
        player.setJailed(true);
        /**
         * Her skal spilleren enten bruge sit get-out.of.jail kort, eller også
         * så skal spillernen betale 1M og intet andet.
         */

    }

}