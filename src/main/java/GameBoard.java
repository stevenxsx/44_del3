
public class GameBoard {

    private Field[] gameBoardList = new Field[24];


    //et array som indeholder alle felter og deres attributter
    public GameBoard() {
        gameBoardList[0] = new FieldStart();
        gameBoardList[1] = new FieldStreet("M1","Burgerbaren",false,'a', 1,1, null);
        gameBoardList[2] = new FieldStreet("M1", "Pizzariaet",false,'a',1,1, null);
        gameBoardList[3] = new ChanceCardController();
        gameBoardList[4] = new FieldStreet("M1","Slikbutikken",false,'b',1,1, null);
        gameBoardList[5] = new FieldStreet("M1","Iskiosken",false,'b',1,1, null);
        gameBoardList[6] = new visitJail("På besøg");
        gameBoardList[7] = new FieldStreet("M2","Museet",false,'c',2,2,null);
        gameBoardList[8] = new FieldStreet("M2","Bibliotek",false,'c',2,2,null);
        gameBoardList[9] = new ChanceCardController();
        gameBoardList[10] = new FieldStreet("M2","Skaterparken",false,'d',2,2,null);
        gameBoardList[11] = new FieldStreet("M2","svømmepoolen",false,'d',2,2,null);
        gameBoardList[12] = new FieldParking("Gratis parkering");
        gameBoardList[13] = new FieldStreet("M3","Spillehallen",false,'e',3,3,null);
        gameBoardList[14] = new FieldStreet("M3","Biograffen",false,'e',3,3,null);
        gameBoardList[15] = new ChanceCardController();
        gameBoardList[16] = new FieldStreet("M3","Legetøjsbutikken",false,'f',3,3,null);
        gameBoardList[17] = new FieldStreet("M3","Dyrehandlen",false,'f',3,3,null);
        gameBoardList[18] = new FieldJail();
        gameBoardList[19] = new FieldStreet("M4","Bowlinghallen",false,'g',4,4,null);
        gameBoardList[20] = new FieldStreet("M4","Zoo",false,'g',4,4,null);
        gameBoardList[21] = new ChanceCardController();
        gameBoardList[22] = new FieldStreet("M5","Vandlandet",false,'h',5,5,null);
        gameBoardList[23] = new FieldStreet("M5","Strandpromaden",false,'h',5,5,null);
        }
    public Field[] getArray() {
        return gameBoardList;
    }

    public Field getGameBoardList(int number){return  gameBoardList[number];}

    }
