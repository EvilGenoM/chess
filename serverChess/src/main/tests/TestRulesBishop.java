import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.ClassicRules;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRulesBishop {

    @Test
    public void testMoveBishopUpRight(){


        String strokeStr = "d4 f6";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveBishop(stroke);
        Cell cell1 = new Cell('e',5);
        Cell cell2 = new Cell('f',6);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell1);
        wayTest.add(cell2);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveBishopUpLeft(){


        String strokeStr = "d4 b6";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveBishop(stroke);
        Cell cell1 = new Cell('c',5);
        Cell cell2 = new Cell('b',6);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell1);
        wayTest.add(cell2);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveBishopDownRight(){


        String strokeStr = "d4 f2";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveBishop(stroke);
        Cell cell1 = new Cell('e',3);
        Cell cell2 = new Cell('f',2);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell1);
        wayTest.add(cell2);

        assertEquals(way, wayTest);

    }

    @Test
    public void testMoveBishopDownLeft(){


        String strokeStr = "d4 b2";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.moveBishop(stroke);
        Cell cell1 = new Cell('c',3);
        Cell cell2 = new Cell('b',2);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell1);
        wayTest.add(cell2);

        assertEquals(way, wayTest);

    }

}
