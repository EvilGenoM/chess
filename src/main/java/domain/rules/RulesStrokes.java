package domain.rules;

import domain.Board;
import domain.Cell;
import domain.ResultStroke;

public interface RulesStrokes {

    ResultStroke strokeFigure(Cell from, Cell to, Board board);

}
