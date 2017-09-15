package domain.fabricfigure;

import domain.Color;
import domain.figure.Figure;
import domain.figure.King;

public class CreatorKing extends Creator{

    @Override
    public Figure factoryMethod(Color color) {
        return new King(color);
    }

}
