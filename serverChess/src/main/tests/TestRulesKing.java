import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.ClassicRules;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRulesKing {

    @Test
    public void testMoveKingUp(){

        String strokeStr = "d4 d5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        Cell cell = new Cell('d',5);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveKingDown(){

        String strokeStr = "d4 d3";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        Cell cell = new Cell('d',3);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveKingLeft(){

        String strokeStr = "d4 c4";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        Cell cell = new Cell('c',4);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveKingRight(){

        String strokeStr = "d4 e4";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        Cell cell = new Cell('e',4);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveKingRightUp(){

        String strokeStr = "d4 e5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        Cell cell = new Cell('e',5);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveKingNotStroke(){

        String strokeStr = "a1 a5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveKing(stroke);
        List<Cell> wayTest = new LinkedList<>();

        assertEquals(way, wayTest);

    }

}
