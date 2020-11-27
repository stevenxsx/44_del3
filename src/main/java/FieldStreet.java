 public class FieldStreet extends Field {
     String displayPrice;
        String propertyName;
        boolean owned;
        Player owner;
        char type;
        int rentPrice;
        int rentPriceMultiplier = 1;
        int streetPrice;
        boolean Checked = false;
        int maxOwned;

        public FieldStreet(String displayPrice, String propertyName, boolean owned, char type, int streetPrice, int rentPrice, Player owner, int maxOwned){
           // Making the fields base line
            this.displayPrice = displayPrice;
            this.propertyName = propertyName;
            this.owned = owned;
            this.owner = owner;
            this.type=type;
            this.streetPrice=streetPrice;
            this.rentPrice=rentPrice;
            this.maxOwned = maxOwned;
        }


     public int getStreetPrice(){return streetPrice;}

     public boolean getOwned(){return owned;}

     public void setOwned(boolean b){ owned = b; }

     public void setOwner(Player owner){ this.owner = owner; }

     public Player getOwner(){return owner;}

     public int getRentPrice() { return rentPrice; }

     public void setRentPrice(int rentPrice) {
         System.out.println(propertyName + "'s rentPrice has been set to " + rentPrice); this.rentPrice = rentPrice * rentPriceMultiplier; }

     public void setRentPriceMultiplier(int b) { this.rentPriceMultiplier = b; }

     public int getRentPriceMultiplier() { return this.rentPriceMultiplier; }

     public String getPropertyName() {
         return this.propertyName;
     }

     public char getType() { return type; }

 }
