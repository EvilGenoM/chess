package domain.fabricfigure;

import domain.Color;
import domain.figure.Bishop;
import domain.figure.Figure;

public class CreatorBishop extends Creator{

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
