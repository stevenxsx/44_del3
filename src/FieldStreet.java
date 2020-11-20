 public class FieldStreet extends Field {
        int price;
        String propertyName;
        Boolean owned;
       // Player owner;
        char type;
        int rentPrice;

        int streetPrice;



        public FieldStreet(int price, String propertyName, Boolean owned, /*Player owner,*/ char type, int streetPrice, int rentPrice){
           // Making the fields base line
            this.price = price;
            this.propertyName = propertyName;
            this.owned = owned;
            //this.owner = owner;
            this.type=type;
            this.streetPrice=streetPrice;
            this.rentPrice=rentPrice;
        }
}
