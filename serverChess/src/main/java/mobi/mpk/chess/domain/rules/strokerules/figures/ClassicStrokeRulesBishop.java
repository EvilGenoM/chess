package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.LinkedList;
import java.util.List;

public class ClassicStrokeRulesBishop extends ClassicStrokeRulesFigure {

    @Override
    public List<Cell> move(Cell from, Cell to) {

        List<Cell> wayFigure = moveDiagonal(from, to);

        return wayFigure;
    }

}
