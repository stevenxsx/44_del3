public class FieldParking extends Field {

    String propertyName;

    FieldParking(String name) { propertyName = name; }

    @Override
    public boolean getOwned() {
        return true;
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

    @Override
    public char getType() {
        return 0;
    }

    @Override
    public void setRentPrice(int i) {

    }

    @Override
    public void setRentPriceMultiplier(int b) {

    }

    @Override
    public int getRentPriceMultiplier() {
        return 0;
    }

    @Override
    public String getPropertyName() {
        return propertyName;
    }
}