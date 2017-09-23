import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.King;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBoard {

    @Test
    public void testGetCell(){

        Board board = new Board();
        Cell[][] cells = board.getMassiveCell();
        cells[0][5].setFigure(new King(Color.white));

        Cell cell = new Cell(0, 5);
        Cell cell2 =board.getCell(cell);

        String nameFigure = cell2.getFigure().getClass().getSimpleName();

        assertEquals(nameFigure, "King");

    }

}
