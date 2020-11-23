import java.util.Random;

public class ChanceCardController extends Field {

    //her vil jeg prøve at lave det så at classen henter kortene fra bunken (ChanceCard)
    /*int i;



    public ChanceCardController(){

    }

    //trækker et kort fra bunken af chancekort
    public int getCard (Player player, int i/*Her skal den hente" GUI gui" og spilleren der rammer  *//*) {
        this.i =i;
        Random cardPile = new Random();
        int card = cardPile.nextInt(20) + 1;
// Nu er det sat op så man kan en af de 20 tilfældige chance-kort når jeg har lavet dem 
        ChanceCards chanceCard = new ChanceCards(card, player, gui, i);
        chanceCard.cardPile();
        i= chanceCard.getTurn();
        return i;
    }*/
}

/* Jeg er lidt forvirret over hvorfor der både er en Chancecards og en ChanceCardsController, idet man normalt ikke laver en controller som der
    bliver extended og bruger den extendede ting. Effektivt gør det at ChanceCards er en kontroller af sig selv.
    Jeg er også lettere forevirret over selve formålet for controlleren? Jeg foreslår at samle ChanceCards og ChanceCardController ;)
    - Kat
 */