
public class GameBoard {

    private static final Field[] gameBoardList = new Field[24];


    //et array som indeholder alle felter og deres attributter
    public static Field[] makeGameFields(int i) {
        Language l = new Language();

        gameBoardList[0] = new FieldStart((l.starttitel[i]));
        gameBoardList[1] = new FieldStreet("M1",l.burgerbarentitel[i],false,'a', 1,1, null,2);
        gameBoardList[2] = new FieldStreet("M1", l.pizzeriaettitel[i],false,'a',1,1, null,2);
        gameBoardList[3] = new FieldChance(l.chancetitel[i]);
        gameBoardList[4] = new FieldStreet("M1",(l.slikbutikkentitel[i]),false,'b',1,1, null,2);
        gameBoardList[5] = new FieldStreet("M1",(l.iskioskentitel[i]),false,'b',1,1, null,2);
        gameBoardList[6] = new FieldJail((l.gaaIFaengseltitel[i]));
        gameBoardList[7] = new FieldStreet("M2",(l.museettitel[i]),false,'c',2,2,null,2);
        gameBoardList[8] = new FieldStreet("M2",(l.bibliotekettitel[i]),false,'c',2,2,null,2);
        gameBoardList[9] = new FieldChance(l.chancetitel[i]);
        gameBoardList[10] = new FieldStreet("M2",(l.skaterparkentitel[i]),false,'d',2,2,null,2);
        gameBoardList[11] = new FieldStreet("M2",(l.svoemmebassinettitel[i]),false,'d',2,2,null,2);
        gameBoardList[12] = new FieldParking(l.parkeringtitel[i]);
        gameBoardList[13] = new FieldStreet("M3",(l.spillehallentitel[i]),false,'e',3,3,null,2);
        gameBoardList[14] = new FieldStreet("M3",(l.biografentitel[i]),false,'e',3,3,null,2);
        gameBoardList[15] = new FieldChance(l.chancetitel[i]);
        gameBoardList[16] = new FieldStreet("M3",(l.legetoejsbutikkentitel[i]),false,'f',3,3,null,2);
        gameBoardList[17] = new FieldStreet("M3",(l.dyreHandlentitel[i]),false,'f',3,3,null,2);
        gameBoardList[18] = new FieldGoToJail(l.faengseltitel[i]);
        gameBoardList[19] = new FieldStreet("M4",(l.bowlinghallentitel[i]),false,'g',4,4,null,2);
        gameBoardList[20] = new FieldStreet("M4",(l.zootitel[i]),false,'g',4,4,null,2);
        gameBoardList[21] = new FieldChance(l.chancetitel[i]);
        gameBoardList[22] = new FieldStreet("M5",(l.vandlandtitel[i]),false,'h',5,5,null,2);
        gameBoardList[23] = new FieldStreet("M5",(l.strandpromonadentitel[i]),false,'h',5,5,null,2);

        return gameBoardList;
        }

    }
