package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.ResultStroke;

import static mobi.mpk.Constant.*;

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
