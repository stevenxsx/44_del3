public class ChanceCards extends ChanceCardController {

    int cardNumber;
    Player player;
    //GUI gui;
    int turn;
    Player[] playerArray;
    int total=0;
    int arrayLength;

    public ChanceCards(int cardNumber, Player player, /*GUI gui,*/ int i, Player[] playerArray, int arrayLength) {
        this.cardNumber=cardNumber;
        this.player=player;
        //this.gui=gui;
        this.turn=i;
        this.arrayLength=arrayLength;
        this.playerArray=playerArray;

    }
    //Herfra skal jeg "bare" lave koden for hvad hvert Chancekort skal gøre, ud fra en switch
    //så nu man lander på ChanceCardControllerne, så vælger den et tilfældigt af de 20 eksistrende
    //chancekort som der er.

    public void cardPile () {
        switch (cardNumber) {
            case 1:
                //Ryk frem til start
                /*
                player.setPosition(1);
                player.addCash(PlayerAccount: 2)
                Jeg har hverken Player eller Account klassen til rådighed, så jeg gætter på hvad
                kaldemetoden ender med; Skal nok rettes senere.
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 2:
                //ryk fem felter frem
                /*
                player.setPosition(player.getPosition()+5);
                if (player.getPosition()>24){
                    player.setPosition(player.getPosition()-24);
                    (--------------)
                    Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                    Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 3:
                //Du har spist for meget slik, betal 2M
 /*
                player.SubtractCash(PlayerAccount: 2)
                Jeg har hverken Player eller Account klassen til rådighed, så jeg gætter på hvad
                kaldemetoden ender med; Skal nok rettes senere.
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */

            case 4:
                //Ryk frem til Strandpromaden
                /*
                player.setPosition(24);
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 5:
                //Det er din fødselsdag, alle spiller giver dig 1M. n/ TILLYKKE MED FØDSELSDAGEN
                /*
                    for (int i = 0; i < playerArray.length; i++) {
                        playerArray[i].subtractMoney(1);
                    }
                    player.addCash(playerArray.length*1);
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;

            case 6:
                //Du har lavet alle dine lektier, MODTAG 2M fra banken.
 /*
                player.addCash(PlayerAccount: 2)
                Jeg har hverken Player eller Account klassen til rådighed, så jeg gætter på hvad
                kaldemetoden ender med; Skal nok rettes senere.
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */

                }
        }

        }
    }
    /*Standartcommit
    Har lavet ChanceCard nr. 2, Men de andre nødvendige klasser
mangler, så kaldemetoderne er sikkert noget sludder.
     */
