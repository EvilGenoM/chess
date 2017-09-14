package mobi.mpk.domain.fabricfigure;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.*;

public abstract class Creator {

    public abstract Figure factoryMethod(Color color);

}
