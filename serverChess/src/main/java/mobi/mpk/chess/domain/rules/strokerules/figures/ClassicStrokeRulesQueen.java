package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.List;

public class ClassicStrokeRulesQueen extends ClassicStrokeRulesFigure {

    @Override
    public List<Cell> move(Cell from, Cell to) {

        List<Cell> wayFigure = moveLine(from, to);

        if(wayFigure.isEmpty()){
            wayFigure = moveDiagonal(from, to);
        }

        return wayFigure;
    }

}
