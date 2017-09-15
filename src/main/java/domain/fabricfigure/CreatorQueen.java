package domain.fabricfigure;

import domain.Color;
import domain.figure.Figure;
import domain.figure.Queen;

public class CreatorQueen extends Creator{
    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }
}
