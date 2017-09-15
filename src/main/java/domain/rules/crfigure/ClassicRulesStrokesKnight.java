package domain.rules.crfigure;

import domain.Board;
import domain.Cell;
import domain.ResultStroke;

import static constant.Constant.ERROR_CELL;
import static constant.Constant.ERROR_WAY_FIGURE;

public class ClassicRulesStrokesKnight extends ClassicRulesStrokesFigure{


    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        ResultStroke resultStroke = new ResultStroke();

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

        resultStroke.setText(ERROR_CELL);

        return resultStroke;

    }



}
