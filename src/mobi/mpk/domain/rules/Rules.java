package mobi.mpk.domain.rules;

import mobi.mpk.domain.*;
import mobi.mpk.domain.figure.*;

import java.util.List;

public interface Rules {


    ResultStroke move(Cell from, Cell to, Board board);

    List<Figure> orderFiguresOnBorad(Color color);

    Player[] identifyWhitePlayer(Player player1, Player player2);

}
