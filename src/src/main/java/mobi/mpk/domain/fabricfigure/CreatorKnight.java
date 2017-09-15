package mobi.mpk.domain.fabricfigure;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.Figure;
import mobi.mpk.domain.figure.kNight;

public class CreatorKnight extends Creator{
    @Override
    public Figure factoryMethod(Color color) {
        return new kNight(color);
    }
}
