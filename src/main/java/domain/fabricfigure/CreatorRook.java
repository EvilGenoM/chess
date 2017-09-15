package domain.fabricfigure;

import domain.Color;
import domain.figure.Figure;
import domain.figure.Rook;

public class CreatorRook extends Creator{


    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
