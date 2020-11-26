public class FieldJail extends Field {
    Player player;
   

    public FieldJail(){}

    //sender spilleren til fængslet, og lavet et klad der kan bruges i Game klassen.
    public void goToJail(Player player){
        this.player=player;
        player.setPlayerPosition(6);
        player.setJailed(true);
        /**
         * Her skal spilleren enten bruge sit get-out.of.jail kort, eller også
         * så skal spillernen betale 1M og intet andet.
         */

    }

    @Override
    public boolean getOwned() {
        return false;
    }

    @Override
    public int getStreetPrice() {
        return 0;
    }

    @Override
    public void setOwned(boolean b) {

    }

    @Override
    public void setOwner(Player owner) {

    }

    @Override
    public int getRentPrice() {
        return 0;
    }

    @Override
    public Player getOwner() {
        return null;
    }
}