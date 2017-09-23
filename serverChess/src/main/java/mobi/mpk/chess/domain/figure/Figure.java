package mobi.mpk.chess.domain.figure;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.Rules;

import java.util.List;

public abstract class Figure {

    private Color color;

    public Figure(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract List<Cell> move(Stroke stroke, Rules rules);

}
