public class ChanceCard extends Field {


    public ChanceCard(){ }

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
