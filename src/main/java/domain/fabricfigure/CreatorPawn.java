package domain.fabricfigure;

import domain.Color;
import domain.figure.Figure;
import domain.figure.Pawn;

public class CreatorPawn extends Creator{

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
