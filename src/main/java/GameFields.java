
public class GameFields {

    private static final Field[] gameBoardList = new Field[24];


    //et array som indeholder alle felter og deres attributter
    public static Field[] makeGameFields(int i) {
        Language l = new Language();

        gameBoardList[0] = new FieldStart("Start");
        gameBoardList[1] = new FieldStreet("M1",l.burgerbarentitel[i],false,'a', 1,1, null,2);
        gameBoardList[2] = new FieldStreet("M1", l.pizzeriaettitel[i],false,'a',1,1, null,2);
        gameBoardList[3] = new FieldChance("Chance");
        gameBoardList[4] = new FieldStreet("M1","Slikbutikken",false,'b',1,1, null,2);
        gameBoardList[5] = new FieldStreet("M1","Iskiosken",false,'b',1,1, null,2);
        gameBoardList[6] = new FieldJail("Fængsel");
        gameBoardList[7] = new FieldStreet("M2","Museet",false,'c',2,2,null,2);
        gameBoardList[8] = new FieldStreet("M2","Biblioteket",false,'c',2,2,null,2);
        gameBoardList[9] = new FieldChance("Chance");
        gameBoardList[10] = new FieldStreet("M2","Skaterparken",false,'d',2,2,null,2);
        gameBoardList[11] = new FieldStreet("M2","Svømmebassinet",false,'d',2,2,null,2);
        gameBoardList[12] = new FieldParking("Fri Parkering");
        gameBoardList[13] = new FieldStreet("M3","Spillehallen",false,'e',3,3,null,2);
        gameBoardList[14] = new FieldStreet("M3","Biografen",false,'e',3,3,null,2);
        gameBoardList[15] = new FieldChance("Chance");
        gameBoardList[16] = new FieldStreet("M3","Legetøjsbutikken",false,'f',3,3,null,2);
        gameBoardList[17] = new FieldStreet("M3","Dyrehandleren",false,'f',3,3,null,2);
        gameBoardList[18] = new FieldGoToJail("Gå I Fængsel");
        gameBoardList[19] = new FieldStreet("M4","Bowlinghallen",false,'g',4,4,null,2);
        gameBoardList[20] = new FieldStreet("M4","Zoologisk Have",false,'g',4,4,null,2);
        gameBoardList[21] = new FieldChance("Chance");
        gameBoardList[22] = new FieldStreet("M5","Vandlandet",false,'h',5,5,null,2);
        gameBoardList[23] = new FieldStreet("M5","Strandpromenaden",false,'h',5,5,null,2);

        return gameBoardList;
        }

    }
