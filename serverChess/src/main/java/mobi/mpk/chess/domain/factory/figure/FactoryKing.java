package mobi.mpk.chess.domain.factory.figure;


import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.King;

public class FactoryKing extends FactoryFigure{

    @Override
    public Figure factoryMethod(Color color) {
        return new King(color);
    }

}
