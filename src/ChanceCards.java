public class ChanceCards extends ChanceCardController {

    int cardNumber;
    Player player;
    //GUI gui;
    int turn;

    int total=0;


    public ChanceCards(int cardNumber, Player player, /*GUI gui,*/ int i) {
        this.cardNumber=cardNumber;
        this.player=player;
        //this.gui=gui;
        this.turn=i;

    }
    //Herfra skal jeg "bare" lave koden for hvad hvert Chancekort skal gøre, ud fra en switch
    //så nu man lander på ChanceCardControllerne, så vælger den et tilfældigt af de 20 eksistrende
    //chancekort som der er.

    public void cardPile () {
        switch (cardNumber) {
            case 1:
                /*Ryk frem til start
                player.setPosition(1);
                player.addCash(PlayerAccount: 2)
                Jeg har hverken Player eller Account klassen til rådighed, så jeg gætter på hvad
                kaldemetoden ender med; Skal nok rettes senere.
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;
        }

        }
    }