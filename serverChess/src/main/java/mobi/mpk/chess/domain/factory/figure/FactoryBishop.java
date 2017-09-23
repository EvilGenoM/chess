package mobi.mpk.chess.domain.factory.figure;


import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Bishop;
import mobi.mpk.chess.domain.figure.Figure;

public class FactoryBishop extends FactoryFigure{

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
