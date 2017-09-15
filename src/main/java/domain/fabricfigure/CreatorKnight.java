package domain.fabricfigure;

import domain.Color;
import domain.figure.Figure;
import domain.figure.kNight;

public class CreatorKnight extends Creator{
    @Override
    public Figure factoryMethod(Color color) {
        return new kNight(color);
    }
}
