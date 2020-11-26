import gui_fields.GUI_Player;
import gui_main.GUI;
public class ChanceCards extends ChanceCardController {

    int cardNumber;
    Player player;
    GUI gui;
    int turn;
    Player[] playerArray;
    int total = 0;
    int arrayLength;

    public ChanceCards(int cardNumber, Player player, GUI gui, int i, Player[] playerArray, int arrayLength) {
        this.cardNumber = cardNumber;
        this.player = player;
        this.gui = gui;
        this.turn = i;
        this.arrayLength = arrayLength;
        this.playerArray = playerArray;

        // Ved ikke helt om der er en grund til at bruge gui her? Du skal jo ikke opdatere GUI'en, da den jo bare opdateres under game når chancekortet er blevet udført - Kat

    }

    /**
     * gui.getUserButtonPressed("Du har trukket et chancekort, ", "Fortsæt");
     */
    //Herfra skal jeg "bare" lave koden for hvad hvert Chancekort skal gøre, ud fra en switch
    //så nu man lander på ChanceCardControllerne, så vælger den et tilfældigt af de 20 eksistrende
    //chancekort som der er.

    public void cardPile() {
        switch (cardNumber) {
            case 1:
                //frem til start

                player.setPosition(0);
                player.addCoins(2);
                gui.getUserButtonPressed("Du har trukket et chancekort, velkommen tilbage til starten.", "Fortsæt");
                        /*
                Jeg har hverken Player eller Account klassen til rådighed, så jeg gætter på hvad
                kaldemetoden ender med; Skal nok rettes senere.
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 2:
                //ryk op til fem felter frem
                String fremtil = gui.getUserSelection("Du har trukket et chancekort, ryk op til 5 felter frem.", "1", "2", "3", "4", "5");
                int Fremtil = Integer.parseInt(fremtil);
                player.setPosition(player.getPosition() + Fremtil);
                if (player.getPosition() > 23) {
                    player.setPosition(player.getPosition() - 23);
                    player.addCoins(2);
                }
                gui.getUserButtonPressed("Sådan du rykkede frem lad os spille videre", "Fortsæt");
                    /*(--------------)
                    Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                    Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 3:
                //Du har spist for meget slik, betal 2M
                player.subtractMoney(2);
                gui.getUserButtonPressed("Du har trukket et chancekort, du har spist for meget slik, betal 2M", "Fortsæt");

                        /*

                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;
            case 4:
                //Ryk frem til Strandpromaden
                player.setPosition(23);
                gui.getUserButtonPressed("Du har trukket et chancekort, ryk frem til Strandpromaden", "Fortsæt");

                /*
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;


            case 5:
                //Det er din fødselsdag, alle spiller giver dig 1M. n/ TILLYKKE MED FØDSELSDAGEN

                for (int i = 0;
                     i < playerArray.length;
                     i++) {
                    playerArray[i].subtractMoney(1);
                }
                player.addCoins(playerArray.length*1);
                gui.getUserButtonPressed("Du har trukket et chancekort, det er din fødselsdag, alle spiller giver dig 1M", "Fortsæt");
                    /*
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;

            case 6:
                //Du har lavet alle dine lektier, MODTAG 2M fra banken.

                player.addCoins(2);
                gui.getUserButtonPressed("Du har trukket et chancekort, du har lavet alle dine lektior til imorgen, MODTAG 2M fra banken", "Fortsæt");
                /*
                (--------------)
                Her skal der nok indsættes en gui-funktion der fortæller spilleren hvad der sker.
                Har ikke en Gui-klasse, så gætter igen...
                */
                break;
            case 7:
                //slip fri fra fængsel

                player.setNumberOfEscapeCards(player.getNumberOfEscapeCards() + 1);
                gui.getUserButtonPressed("Du har fået et Fri-fra-jail-kort, som du kan gemme og bruge hvis du havner i fængsel.", "Fortsæt");
                gui.getUserButtonPressed("Du har nu " + player.getNumberOfEscapeCards() + "antal fri-fra-jail-kort", "Fortsæt");
                break;





        }
    }
        public int getTurn () {
            return turn;
        }
    }
    /*Standartcommit
Changes     Har lavet ChanceCard nr. ??, Men de andre nødvendige klasser
mangler, så kaldemetoderne er sikkert noget sludder.
     */
