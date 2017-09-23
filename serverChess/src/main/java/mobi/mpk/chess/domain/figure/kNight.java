package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.Rules;

import java.util.LinkedList;
import java.util.List;

public class kNight extends Figure {

    public kNight(Color color) {
        super(color);
    }

    @Override
    public List<Cell> move(Stroke stroke, Rules rules) {

        List<Cell> wayFigure = rules.movekNight(stroke);

        return wayFigure;
    }

}
