package mobi.mpk.domain.rules.csfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.figure.Figure;
import mobi.mpk.domain.rules.RulesStrokesFigure;

public class ClassicRulesStrokesFigure implements RulesStrokesFigure {

    @Override
    public boolean strokeFigure(Cell from, Cell to, Board board){

        Figure figure;

        if(from.getFigure() != null){
            figure = from.getFigure();
        } else {
            return false;
        }

        switch (figure.getClass().getSimpleName()){
            case "King":
                System.out.println("1");
                return strokesKing(from, to, board);
            case "Queen":
                System.out.println("2");
                return strokeQueen(from, to, board);
            case "Bishop":
                System.out.println("3");
                return strokeBishop(from, to, board);
            case "kNight":
                System.out.println("4");
                return strokesKNight(from, to);
            case "Rook":
                System.out.println("5");
                return strokesRook(from, to, board);
            case "Pawn":
                System.out.println("6");
                return strokesPawn(from, to, board);
            default:
                return false;

        }

    }


}
