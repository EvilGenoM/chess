import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.ClassicRules;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRuleskNight {

    @Test
    public void testStroke1(){

        String strokeStr = "d4 b5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movekNight(stroke);
        Cell cell = new Cell('b',5);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testStroke2(){

        String strokeStr = "d4 b3";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movekNight(stroke);
        Cell cell = new Cell('b',3);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testStroke3(){

        String strokeStr = "d4 f5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movekNight(stroke);
        Cell cell = new Cell('f',5);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testStroke4(){

        String strokeStr = "d4 f3";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movekNight(stroke);
        Cell cell = new Cell('f',3);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testStrokeNot(){

        String strokeStr = "d4 d5";

        Stroke stroke = new Stroke(strokeStr);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movekNight(stroke);
        List<Cell> wayTest = new LinkedList<>();

        assertEquals(way, wayTest);
    }




}
