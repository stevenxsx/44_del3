 public class FieldStreet extends Field {
     String displayPrice;
        String propertyName;
        Boolean owned;   //Er denne her nødvendig? Tænker hvis ingen owner, owner = null - Kat
        Player owner;
        char type;
        int rentPrice;

        int streetPrice;



        public FieldStreet(String displayPrice, String propertyName, Boolean owned, char type, int streetPrice, int rentPrice, Player owner){
           // Making the fields base line
            this.displayPrice = displayPrice;
            this.propertyName = propertyName;
            this.owned = owned;
            this.owner = owner;
            this.type=type;
            this.streetPrice=streetPrice;
            this.rentPrice=rentPrice;
        }

     public int getStreetPrice(){return streetPrice;}

     public Boolean getOwned(){return owned;}

     public void setOwned(boolean setEjet){ owned =setEjet; }

     public void setOwner(Player owner){ this.owner = owner; }

     public Player getOwner(){return owner;}

     public int getRentPrice() { return rentPrice; }

     public void setRentPrice(int rentPrice) { this.rentPrice = rentPrice; }
   // @Override
   // public void landOnField() {
//
   //  }
 }
