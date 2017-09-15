package domain.rules.crfigure;

import domain.Board;
import domain.Cell;
import domain.ResultStroke;

import static constant.Constant.ERROR_CELL;
import static constant.Constant.ERROR_WAY_FIGURE;

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
