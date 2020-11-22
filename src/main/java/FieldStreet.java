 public class FieldStreet extends Field {
     String displayPrice;
        String propertyName;
        Boolean owned;   //Er denne her nødvendig? Tænker hvis ingen owner, owner = null - Kat
       // Player owner;
        char type;
        int rentPrice;

        int streetPrice;



        public FieldStreet(String displayPrice, String propertyName, Boolean owned, /*Player owner,*/ char type, int streetPrice, int rentPrice){
           // Making the fields base line
            this.displayPrice = displayPrice;
            this.propertyName = propertyName;
            this.owned = owned;
            //this.owner = owner;
            this.type=type;
            this.streetPrice=streetPrice;
            this.rentPrice=rentPrice;
        }

   // @Override
   // public void landOnField() {
//
   //  }
 }
