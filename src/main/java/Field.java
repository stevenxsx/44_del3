abstract class Field {
    public abstract boolean getOwned();

    public abstract int getStreetPrice();

    public abstract void setOwned(boolean b);

    public abstract void setOwner(Player owner);

    public abstract int getRentPrice();

    public abstract Player getOwner();
}
