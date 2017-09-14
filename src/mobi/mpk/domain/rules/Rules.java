package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.Player;
import mobi.mpk.domain.figure.*;

import java.util.List;

public interface Rules {


    boolean move(Cell from, Cell to, Board board);

    List<Figure> orderFiguresOnBorad(Color color);

    Player[] identifyWhitePlayer(Player player1, Player player2);

}
