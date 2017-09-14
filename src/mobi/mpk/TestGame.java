package mobi.mpk;

import junit.framework.TestCase;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.Pawn;
import mobi.mpk.domain.figure.kNight;
import mobi.mpk.domain.rules.ClassicRulesStrokes;
import mobi.mpk.domain.rules.RulesStrokes;
import org.junit.*;

import static org.junit.Assert.*;

public class TestRulesStrokes {

    private RulesStrokes rulesStrokes;

    @Before
    public void init(){
        rulesStrokes = new ClassicRulesStrokes();
    }

    @After
    public void tearDown(){
        rulesStrokes = null;
    }

    @org.junit.Test
    public void strokeKNight(){

        Cell[] to = new Cell[8];
        to[0] = new Cell('d',2, null);
        to[1] = new Cell('f',2, null);
        to[2] = new Cell('c',3, null);
        to[3] = new Cell('c',5, null);
        to[4] = new Cell('g',3, null);
        to[5] = new Cell('c',5, null);
        to[6] = new Cell('d',6, null);
        to[7] = new Cell('f',6, new kNight(Color.white));

        for(int i = 0; i<8; i++){

            Cell from = new Cell('e',4, new kNight(Color.white));
            boolean isStroke = rulesStrokes.strokeFigure(from, to[i], null);
            assertTrue(isStroke);

        }


    }



}
