package domain.fabricfigure;

import domain.Color;
import domain.figure.*;

public abstract class Creator {

    public abstract Figure factoryMethod(Color color);

}
