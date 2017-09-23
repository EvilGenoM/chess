package mobi.mpk.chess.domain.rules;

import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.figure.Figure;

import java.util.List;

public interface Rules {

    List<Cell> moveKing(Stroke stroke);

    List<Cell> moveQueen(Stroke stroke);

    List<Cell> moveBishop(Stroke stroke);

    List<Cell> movekNight(Stroke stroke);

    List<Cell> moveRook(Stroke stroke);

    List<Cell> movePawn(Stroke stroke);

    boolean canPutFigure(Cell from, Cell to);

    Player wonPlayer();

    List<Figure> orderFigure(Color color);

}
