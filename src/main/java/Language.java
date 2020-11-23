public class Language {


    //Add indexes to the arrays with translated text.
    //Index 0 = Danish, Index 1 = English, Index 2 = German, etc.
    public String language = "Index 0= Danish, Index 1 = English, Index 2 = German,";

    //Strings for welcomeMessage()
    public String[] welcomeMessage = {"Velkommen til Monopoly Junior\n"+
    "Saml dine venner og tag på eventyr på Monopoly Juniors spilleplade"};

    // Strings for startGame()
    public String[] enterName = {"Angiv dit navn"};
    public String[] enterAge = {"Angiv din alder"};
    public String[] choosePlayerFigur = {"Vælg din spillerfigur"};
    public String[] contineGame = {"Tryk enter og lad spillet starte"};

    // Strings for landOnField()
    public String[] youLandenOn = {"Du landede på"};
    public String[] isOwnedBy = {"Dette felt er ejet af"};
    public String[] getFieldDescriptionEjetFelt = {"Du skal betale husleje til den spiller der ejer feltet\n"+ "Du skal betale det beløb der står på feltet"};
    public String[] isFree = {"Dette felt er ledigt"};
    public String[] getFieldDescriptionLedigtFelt = {"Dette felt er ledigt, og du skal nu købe det!\n"+
                                                     "Betal banken det det beløb, der står på feltet, og placér et af dine solgt-skilte på det farvede bånd"};
    public String[] getFieldDescriptionDobbeltEjetFelt = {"ejer denne ejendom og ejer også ejendommen med samme farve\n"+
                                                          "Du skal nu betale husleje som er det dobbelte beløb, af hvad der står på feltet"};
    // Strings for makeFields()
    public String[] fieldDescriptionChance = {"Tag det øverste chancekort, læs det højt, og følg instruktionerne.\n"+
    "Læg dit brugte kort tilbage nederst i bunken."};
    public String[] fieldDescriptionStart ={"Du har passeret eller er landet på feltet START. Du modtager M2 fra banken"};
    public String[] fieldDescriptionPaaBesoeg = {"Bare rolig. Lander du her er du bare på besoeg"};
    public String[] fieldDescriptionGaaiFaengsel = {"Gå lige i fængsel!\n"+ "Du passerer ikke START. Du modtager ikke M2.\n"+
    "I starten af din næste tur skal du betale M1 eller bruge 'Du løslades uden omkostninger'-kortet."};
    public String[] fieldDescriptionGratisParkering = {"Du behøver ikke gøre noget, bare snup dig en pause"};

    // Strings for chanceCards ()
    public String[] chanceCard1 = {"Giv dette kort til BILEN, og tag et chancekort mere.\n"+
                                   "BIL: På din næste tur skal du drøne frem til et hvilket som helst ledigt felt og købe det. \n"+
                                   "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller"};
    public String[] chanceCard2 = {"Ryk frem til START. Modtag M2"};
    public String[] chanceCard3 = {"Ryk op til 5 felter frem"};
    public String[] chanceCard4 = {"GRATIS FELT!\n"+"Ryk frem til et orange felt. Hvis det er ledigt får du det GRATIS!\n"+
                                   "Ellers skal du BETALE leje til ejeren "};
    public String[] chanceCard5 = {"Ryk 1 felt frem, eller tag et chancekort mere."};
    public String[] chanceCard6 = {"Giv dette kort til SKIBET, og tag et chancekort.\n"+
                                   "SKIB: På din næste tur skal du sejle frem til et hvilket som helst ledigt felt og købe det.\n"+
                                   "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!"};
    public String[] chanceCard7 = {"Du har spist for meget slik. BETAL M2 til banken"};
    public String[] chanceCard8 = {"GRATIS FELT!\n"+ "Ryk frem til et orange eller grønt felt.\n"+
                                   "Hvis det er ledigt får du det GRATIS! Ellers skal du betale leje til ejeren."};
    public String[] chanceCard9 = {"GRATIS FELT!\n"+ "Ryk frem til et lyseblåt felt. Hvis det er ledigt får du det GRATIS \n"+
                                   "Ellers skal du BETALE leje til ejeren"};
    public String[] chanceCard10 = {"Du løslades uden omkostninger\n"+ "Behold dette kort, indtil du får brug for det"};
    public String[] chanceCard11 = {"Ryk frem til Strandpromonaden"};
    public String[] chanceCard12 = {"Giv dette kort til KATTEN, og tag et chancekort mere. \n"+
                                    "KAT: På din næste tur skal du liste dig hen på et hvilket som helst ledigt felt og købe det.\n"+
                                    "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!"};
    public String[] chanceCard13 = {"Giv dette kort til HUNDEN, og tag et chancekort mere.\n"+
                                    "HUND: På din næste tur skal du hoppe hen på et hvilket som helst ledigt felt og købe det.\n"+
                                    "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!"};
    public String[] chanceCard14 = {"Det er din fødselsdag!Alle giver dig M1!\n"+
                                    "Tillykke med fødselsdagen!"};
    public String[] chanceCard15 ={"GRATIS FELT!\n"+ "Ryk frem til et pink eller mørkeblåt felt. Hvis det er ledigt får du det gratis\n"+
                                    "Ellers skal du BETALE leje til ejeren"};
    public String[] chanceCard16 = {"Du har lavet alle dine lektier! Modtag M2 fra banken."};
    public String[] chanceCard17 = {"GRATIS FELT!\n"+ "Ryk frem til et rødt felt. Hvis det er ledigt får du det GRATIS!\n"+
                                    "Ellers skal du BETALE leje til ejeren"};
    public String[] chanceCard18 = {"GRATIS FELT!\n"+ "Ryk frem til Skaterparken for at lave det perfekte grind\n!"+
                                    "Hvis ingen ejer det får du det GRATIS. Ellers skal du betale leje til ejeren."};
    public String[] chanceCard19 = {"GRATIS FELT!\n"+ "Ryk frem til et lyseblåt eller rødt felt. Hvis det er ledigt får du det GRATIS!\n"+
                                    "Ellers skal du BETALE leje til ejeren"};
    public String[] chanceCard20 = {"GRATIS FELT!\n"+ "Ryk frem til et brunt eller gult felt. Hvis det er ledigt får du det GRATIS!\n"+
                                    "Ellers skal du betale leje til ejeren"};

    // Strings for makeFigur
    public String[] figurDescriptionHunden = {"Nuttet, legesyg og loyal - hunden er fuld af energi og altid sulten.\n"+
                                              "Tag en tur rundt i Monopoly-byen med hunden. Den lille beslutsomme vuffer vil gøre alt for at vinde"};
    public String[] figurDescriptionSkibet = {"Alle mand om bord!\n"+
                                              "Skibet er berejst og ved præcis, hvor det skal sejle hen for at holde sig forrest i spillet.\n"+
                                              "Spil som skibet, der har fuld fart fremad, og sejl sejren sikkert hjem."};
    public String[] figurDescriptionBilen = {"Klar... parat... KØR!\n"+
                                             "Den hurtige og frygtløse bil skrider altid rundt i svingene og drøner videre til næste felt.\n"+
                                             "Denne risikovillige racer vil gøre alt for at holde dig i front"};
    public String[] figurDescriptionKatten = {"Et spindende valg.\n"+
                                              "Denne kløgtige kat lander altid på poterne. Katten er hurtig og adræt, og den kender hver en gade i byen.\n"+
                                              "Spil som den drillesyge kat, så kan du snart liste dig forrest"};


    // Strings for turn()
    public String[] rolled = {"Du slå en "}

    //Strings for checkForWin()
    public String[] youWon = {"Tillykke! Du havde flest penge tilbage da din modspiller gik fallit.\n"+
    "Du har vundet spillet"};
    public String[] goBankRupt = {"Åh nej....!! Du har ikke nok penge til at købe ejendommen eller betale husleje til din modspiller\n"+
    "Du går fallit og har tabt spillet"};



    
    




}
