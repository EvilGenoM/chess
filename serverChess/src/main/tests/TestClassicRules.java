import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Pawn;
import mobi.mpk.chess.domain.rules.ClassicRules;
import mobi.mpk.chess.domain.rules.Rules;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClassicRules {

    @Test
    public void testCanPutFigure1(){

        Rules rules = new ClassicRules();
        Cell from = new Cell('a', 1);
        from.setFigure(new Pawn(Color.black));
        Cell to = new Cell('a', 2);

        boolean real = rules.canPutFigure(from, to);

        assertEquals(real, true);

    }

    @Test
    public void testCanPutFigure2(){

        Rules rules = new ClassicRules();
        Cell from = new Cell('a', 1);
        from.setFigure(new Pawn(Color.black));
        Cell to = new Cell('a', 2);
        to.setFigure(new Pawn(Color.white));

        boolean real = rules.canPutFigure(from, to);

        assertEquals(real, true);

    }

    @Test
    public void testCanPutFigure3(){

        Rules rules = new ClassicRules();
        Cell from = new Cell('a', 1);
        from.setFigure(new Pawn(Color.black));
        Cell to = new Cell('a', 2);
        to.setFigure(new Pawn(Color.black));

        boolean real = rules.canPutFigure(from, to);

        assertEquals(real, false);

    }

}
