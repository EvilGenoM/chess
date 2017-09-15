package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.ResultStroke;

public interface RulesStrokes {

    ResultStroke strokeFigure(Cell from, Cell to, Board board);

}
