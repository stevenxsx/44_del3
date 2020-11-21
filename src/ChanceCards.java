public class ChanceCards extends ChanceCardController {

    int cardNumber;
    Player player;
    //GUI gui;
    int turn;

    int total = 0;


    public ChanceCards(int cardNumber, Player player, /*GUI gui,*/ int i) {
        this.cardNumber = cardNumber;
        this.player = player;
        //this.gui=gui;
        this.turn = i;

        // Ved ikke helt om der er en grund til at bruge gui her? Du skal jo ikke opdatere GUI'en, da den jo bare opdateres under game når chancekortet er blevet udført - Kat

    }

    //Herfra skal jeg "bare" lave koden for hvad hvert Chancekort skal gøre, ud fra en switch
    //så nu man lander på ChanceCardControllerne, så vælger den et tilfældigt af de 20 eksistrende
    //chancekort som der er.
    public void cardPile() {
        switch (cardNumber) {

        }
    }
}
