package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.Figure;

public class ClassicRulesStrokes implements RulesStrokes{

    @Override
    public boolean strokeFigure(Cell from, Cell to, Board board) {

        Figure figure;

        if(from.getFigure() != null){
            figure = from.getFigure();
        } else {
            return false;
        }

        switch (figure.getClass().getSimpleName()){
            case "King":
                return strokesKing(from, to, board);
            case "Queen":
                return strokeQueen(from, to, board);
            case "Bishop":
                return strokeBishop(from, to, board);
            case "kNight":
                return strokesKNight(from, to, board);
            case "Rook":
                return strokesRook(from, to, board);
            case "Pawn":
                return strokesPawn(from, to, board);
            default:
                return false;
        }

    }


    private boolean strokesKing(Cell from, Cell to, Board board){
        return false;
    }

    private boolean strokeQueen(Cell from, Cell to, Board board){
        return false;
    }

    private boolean strokeBishop(Cell from, Cell to, Board board){

        if(from.getY()-to.getY() == from.getX()-to.getX()){

            return true;
        } else {
            return false;
        }

    }

    private boolean strokesKNight(Cell from, Cell to, Board board){

        if(from.getX()-to.getX() == 1){

            if(from.getY()-to.getY() == 2){
                return moveFigure(from, to);
            } else if(from.getY()-to.getY() == -2){
                return moveFigure(from, to);
            }

        }else if(from.getX()-to.getX() == -1){

            if(from.getY()-to.getY() == 2){
                return moveFigure(from, to);
            } else if(from.getY()-to.getY() == -2){
                return moveFigure(from, to);
            }

        }else if(from.getY()-to.getY() == 1){

            if(from.getX()-to.getX() == 2){
                return moveFigure(from, to);
            } else if(from.getX()-to.getX() == -2){
                return moveFigure(from, to);
            }

        }else if(from.getY()-to.getY() == -1){

            if(from.getX()-to.getX() == 2){
                return moveFigure(from, to);
            } else if(from.getX()-to.getX() == -2){
                return moveFigure(from, to);
            }

        }

        return false;

    }

    private boolean strokesRook(Cell from, Cell to, Board board){
        return false;
    }

    private boolean strokesPawn(Cell from, Cell to, Board board){
        return false;
    }

    private boolean moveFigure(Cell from, Cell to){

        if(to.getFigure() != null){

            Color colorFigureFrom = from.getFigure().getColor();
            Color colorFigureTo = to.getFigure().getColor();

            if(colorFigureFrom != colorFigureTo){

                to.setFigure(from.getFigure());
                from.setFigure(null);

                return true;

            } else {
                return false;
            }

        } else {

            to.setFigure(from.getFigure());
            from.setFigure(null);
            return true;
        }

    }

    private boolean strokeDiagonal(Cell from, Cell to, Board board){

        if(from.getY()-to.getY() == from.getX()-to.getX()){

            return true;
        } else {
            return false;
        }

    }


}
