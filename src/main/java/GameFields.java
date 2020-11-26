
public class GameFields {

    private static Field[] gameBoardList = new Field[24];


    //et array som indeholder alle felter og deres attributter
    public static Field[] makeGameFields() {

        gameBoardList[0] = new FieldStart();
        gameBoardList[1] = new FieldStreet("M1","Burgerbaren",false,'a', 1,1, null,2);
        gameBoardList[2] = new FieldStreet("M1", "Pizzariaet",false,'a',1,1, null,2);
        gameBoardList[3] = new ChanceCard();
        gameBoardList[4] = new FieldStreet("M1","Slikbutikken",false,'b',1,1, null,2);
        gameBoardList[5] = new FieldStreet("M1","Iskiosken",false,'b',1,1, null,2);
        gameBoardList[6] = new visitJail("På besøg");
        gameBoardList[7] = new FieldStreet("M2","Museet",false,'c',2,2,null,2);
        gameBoardList[8] = new FieldStreet("M2","Bibliotek",false,'c',2,2,null,2);
        gameBoardList[9] = new ChanceCard();
        gameBoardList[10] = new FieldStreet("M2","Skaterparken",false,'d',2,2,null,2);
        gameBoardList[11] = new FieldStreet("M2","svømmepoolen",false,'d',2,2,null,2);
        gameBoardList[12] = new FieldParking("Gratis parkering");
        gameBoardList[13] = new FieldStreet("M3","Spillehallen",false,'e',3,3,null,2);
        gameBoardList[14] = new FieldStreet("M3","Biograffen",false,'e',3,3,null,2);
        gameBoardList[15] = new ChanceCard();
        gameBoardList[16] = new FieldStreet("M3","Legetøjsbutikken",false,'f',3,3,null,2);
        gameBoardList[17] = new FieldStreet("M3","Dyrehandlen",false,'f',3,3,null,2);
        gameBoardList[18] = new FieldJail();
        gameBoardList[19] = new FieldStreet("M4","Bowlinghallen",false,'g',4,4,null,2);
        gameBoardList[20] = new FieldStreet("M4","Zoo",false,'g',4,4,null,2);
        gameBoardList[21] = new ChanceCard();
        gameBoardList[22] = new FieldStreet("M5","Vandlandet",false,'h',5,5,null,2);
        gameBoardList[23] = new FieldStreet("M5","Strandpromaden",false,'h',5,5,null,2);

        return gameBoardList;
        }

    //tæller hvor mange felter man owner af samme type(Farve)
    public int streetOwnershipCounter(Player owner, char type) {
        int counter = 0;
        for (int i = 0; i < gameBoardList.length; i++) {
            if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11 || i == 13 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20 || i == 22 || i == 23 ) {
                if (owner == ((FieldStreet) gameBoardList[i]).getOwner() && type == ((FieldStreet) gameBoardList[i]).getType()) {

                    counter++;
                }
            }
        }
        return  counter;
    }
    //public Field getGameBoardList(int number){return  gameBoardList[number];}

    }
