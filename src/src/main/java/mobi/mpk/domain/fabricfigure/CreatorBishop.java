package mobi.mpk.domain.fabricfigure;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.Bishop;
import mobi.mpk.domain.figure.Figure;

public class CreatorBishop extends Creator{

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
