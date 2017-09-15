package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.ResultStroke;

import static mobi.mpk.Constant.ERROR_CELL;

public class ClassicRulesStrokesKing extends ClassicRulesStrokesFigure {

    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        ResultStroke resultStroke = new ResultStroke();

        if(from.getX()-to.getX() == 1){

            if(from.getY()-to.getY() == 1){
                return moveFigure(from, to); //down l
            } else if(from.getY()-to.getY() == -1){
                return moveFigure(from, to); //up l
            } else if(from.getY()-to.getY() == 0){
                return moveFigure(from, to); //left
            }

        } else if(from.getX()-to.getX() == 1) {

            if(from.getY()-to.getY() == 1){
                return moveFigure(from, to); //down r
            } else if(from.getY()-to.getY() == -1){
                return moveFigure(from, to); //up r
            } else if(from.getY()-to.getY() == 0){
                return moveFigure(from, to); //right
            }

        } else if(from.getX()-to.getX() == 0){

            if(from.getY()-to.getY() == 1){
                return moveFigure(from, to); //down
            } else if(from.getY()-to.getY() == -1){
                return moveFigure(from, to); //up
            }

        }

        resultStroke.setText(ERROR_CELL);

        return resultStroke;



    }



}
