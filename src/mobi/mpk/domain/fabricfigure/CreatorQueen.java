package mobi.mpk.domain.fabricfigure;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.Figure;
import mobi.mpk.domain.figure.Queen;

public class CreatorQueen extends Creator{
    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }
}
