import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStroke {

    @Test
    public void testCreateStroke(){

        String strokeStr = "d4 e4";
        Stroke stroke = new Stroke(strokeStr);
        Cell cellFrom = stroke.getFrom();
        Cell cellFromT = new Cell('d',4);

        Cell cellTo = stroke.getTo();
        Cell cellToT = new Cell('e',4);

        assertEquals(cellFrom, cellFromT);
        assertEquals(cellTo, cellToT);

    }

}
