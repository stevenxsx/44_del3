public class GameBoard {

    private Field[] gameBoardList = new Field[25];

    //et array som indeholder alle felter og deres attributter
    public Field[] GameBoard() {
        gameBoardList[2] = new FieldStreet("M1","Burgerbaren",false,'a', 1,1 );
        gameBoardList[3] = new FieldStreet("M1", "Pizzariaet",false,'a',1,1);
        gameBoardList[4] = new ChanceCardField();
        gameBoardList[5] = new FieldStreet("M1","Slikbutikken",false,'b',1,1);
        gameBoardList[6] = new FieldStreet("M1","Iskiosken",false,'b',1,1);
        gameBoardList[8] = new FieldStreet("M2","Museet",false,'c',2,1);
        gameBoardList[9] = new FieldStreet("M2","Bibliotek",false,'c',2,1);
        gameBoardList[10] = new ChanceCardField();
        gameBoardList[11] = new FieldStreet("M2","Skaterparken",false,'d',2,1);
        gameBoardList[12] = new FieldStreet("M2","svømmepoolen",false,'d',2,1);
        gameBoardList[14] = new FieldStreet("M3","Spillehallen",false,'e',3,2);
        gameBoardList[15] = new FieldStreet("M3","Biograffen",false,'e',3,2);
        gameBoardList[16] = new ChanceCardField();
        gameBoardList[17] = new FieldStreet("M3","Legetøjsbutikken",false,'f',3,2);
        gameBoardList[18] = new FieldStreet("M3","Dyrehandlen",false,'f',3,2);
        gameBoardList[20] = new FieldStreet("M4","Bowlinghallen",false,'g',4,2);
        gameBoardList[21] = new FieldStreet("M4","Zoo",false,'g',4,2);
        gameBoardList[22] = new ChanceCardField();
        gameBoardList[23] = new FieldStreet("M5","Vandlandet",false,'h',5,3);
        gameBoardList[24] = new FieldStreet("M5","Strandpromaden",false,'h',5,3);
        gameBoardList[1] = new FieldStart();
        gameBoardList[19] = new FieldJail();
        gameBoardList[7] = new visitJail("På besøg");
        gameBoardList[13] = new FieldParking("Gratis parkering");

        return gameBoardList;
        }




    }
