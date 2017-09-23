package mobi.mpk.chess.domain.factory.figure;


import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Figure;

public abstract class FactoryFigure {

    public abstract Figure factoryMethod(Color color);

}
