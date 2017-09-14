package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;

public interface RulesStrokesFigure {
    boolean strokeFigure(Cell from, Cell to, Board board);
}
