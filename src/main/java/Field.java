abstract class Field {
    public abstract boolean getOwned();

    public abstract int getStreetPrice();

    public abstract void setOwned(boolean b);

    public abstract void setOwner(Player owner);

    public abstract int getRentPrice();

    public abstract Player getOwner();

    public abstract char getType();

    public abstract void setRentPrice(int i);

    public abstract void setRentPriceMultiplier(int b);

    public abstract int getRentPriceMultiplier();

    public abstract String getPropertyName();
}
