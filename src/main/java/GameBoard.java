
public class GameBoard {

    private Field[] gameBoardList = new Field[24];


    //et array som indeholder alle felter og deres attributter
    public Field[] GameBoard() {
        gameBoardList[0] = new FieldStart();
        gameBoardList[1] = new FieldStreet("M1","Burgerbaren",false,'a', 1,1 );
        gameBoardList[2] = new FieldStreet("M1", "Pizzariaet",false,'a',1,1);
        gameBoardList[3] = new ChanceCard();
        gameBoardList[4] = new FieldStreet("M1","Slikbutikken",false,'b',1,1);
        gameBoardList[5] = new FieldStreet("M1","Iskiosken",false,'b',1,1);
        gameBoardList[6] = new visitJail("På besøg");
        gameBoardList[7] = new FieldStreet("M2","Museet",false,'c',2,1);
        gameBoardList[8] = new FieldStreet("M2","Bibliotek",false,'c',2,1);
        gameBoardList[9] = new ChanceCard();
        gameBoardList[10] = new FieldStreet("M2","Skaterparken",false,'d',2,1);
        gameBoardList[11] = new FieldStreet("M2","svømmepoolen",false,'d',2,1);
        gameBoardList[12] = new FieldParking("Gratis parkering");
        gameBoardList[13] = new FieldStreet("M3","Spillehallen",false,'e',3,2);
        gameBoardList[14] = new FieldStreet("M3","Biograffen",false,'e',3,2);
        gameBoardList[15] = new ChanceCard();
        gameBoardList[16] = new FieldStreet("M3","Legetøjsbutikken",false,'f',3,2);
        gameBoardList[17] = new FieldStreet("M3","Dyrehandlen",false,'f',3,2);
        gameBoardList[18] = new FieldJail();
        gameBoardList[19] = new FieldStreet("M4","Bowlinghallen",false,'g',4,2);
        gameBoardList[20] = new FieldStreet("M4","Zoo",false,'g',4,2);
        gameBoardList[21] = new ChanceCard();
        gameBoardList[22] = new FieldStreet("M5","Vandlandet",false,'h',5,3);
        gameBoardList[23] = new FieldStreet("M5","Strandpromaden",false,'h',5,3);
        return gameBoardList;
        }

    public Field getGameBoardList(int number){return  gameBoardList[number];}

    }
