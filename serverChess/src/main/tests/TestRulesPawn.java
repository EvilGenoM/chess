import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Pawn;
import mobi.mpk.chess.domain.rules.ClassicRules;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRulesPawn {

    @Test
    public void testMovePawn1(){

        Cell cell1 = new Cell('a',1);
        cell1.setFigure(new Pawn(Color.white));
        Cell cell2 = new Cell('a',2);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        Cell cell = new Cell('a',2);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn2(){

        Cell cell1 = new Cell('a',1);
        cell1.setFigure(new Pawn(Color.white));
        Cell cell2 = new Cell('a',3);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        List<Cell> wayTest = new LinkedList<>();

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn3(){

        Cell cell1 = new Cell('a',2);
        cell1.setFigure(new Pawn(Color.white));
        Cell cell2 = new Cell('a',4);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        Cell cell3 = new Cell('a',3);
        Cell cell4 = new Cell('a',4);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell3);
        wayTest.add(cell4);

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn4(){

        Cell cell1 = new Cell('a',1);
        cell1.setFigure(new Pawn(Color.black));
        Cell cell2 = new Cell('a',2);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        List<Cell> wayTest = new LinkedList<>();

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn5(){

        Cell cell1 = new Cell('a',2);
        cell1.setFigure(new Pawn(Color.black));
        Cell cell2 = new Cell('a',1);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        Cell cell = new Cell('a',1);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell);

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn6(){

        Cell cell1 = new Cell('b',7);
        cell1.setFigure(new Pawn(Color.black));
        Cell cell2 = new Cell('b',5);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        Cell cell3 = new Cell('b',6);
        Cell cell4 = new Cell('b',5);
        List<Cell> wayTest = new LinkedList<>();
        wayTest.add(cell3);
        wayTest.add(cell4);

        assertEquals(way, wayTest);
    }

    @Test
    public void testMovePawn7(){

        Cell cell1 = new Cell('b',8);
        cell1.setFigure(new Pawn(Color.black));
        Cell cell2 = new Cell('b',6);
        cell2.setFigure(null);

        Stroke stroke = new Stroke(cell1, cell2);

        ClassicRules classicRules = new ClassicRules();

        List<Cell> way = classicRules.movePawn(stroke);
        List<Cell> wayTest = new LinkedList<>();

        assertEquals(way, wayTest);
    }


}
