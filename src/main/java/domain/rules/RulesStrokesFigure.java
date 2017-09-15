package domain.rules;

import domain.Board;
import domain.Cell;
import domain.ResultStroke;

public interface RulesStrokesFigure {
    ResultStroke strokeFigure(Cell from, Cell to, Board board);
}
