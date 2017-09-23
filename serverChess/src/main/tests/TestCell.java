import mobi.mpk.chess.domain.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCell {

    @Test
    public void testGetIntX(){

        Cell cell = new Cell('c', 3);
        int x = cell.getIntX();

        assertEquals(x, 3);

    }

}
