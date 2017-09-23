package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.LinkedList;
import java.util.List;

public class ClassicStrokeRulesRook extends ClassicStrokeRulesFigure {

    @Override
    public List<Cell> move(Cell from, Cell to) {

        List<Cell> wayFigure = moveLine(from, to);

        return wayFigure;
    }

}
