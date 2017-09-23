package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.LinkedList;
import java.util.List;

public class ClassicStrokeRuleskNight extends ClassicStrokeRulesFigure {

    @Override
    public List<Cell> move(Cell from, Cell to) {

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(from.getX()-to.getX() == 1){

            if(from.getY()-to.getY() == 2){
                wayFigure.add(to);
                return wayFigure;
            } else if(from.getY()-to.getY() == -2){
                wayFigure.add(to);
                return wayFigure;
            }

        }else if(from.getX()-to.getX() == -1){

            if(from.getY()-to.getY() == 2){
                wayFigure.add(to);
                return wayFigure;
            } else if(from.getY()-to.getY() == -2){
                wayFigure.add(to);
                return wayFigure;
            }

        }else if(from.getY()-to.getY() == 1){

            if(from.getX()-to.getX() == 2){
                wayFigure.add(to);
                return wayFigure;
            } else if(from.getX()-to.getX() == -2){
                wayFigure.add(to);
                return wayFigure;
            }

        }else if(from.getY()-to.getY() == -1){

            if(from.getX()-to.getX() == 2){
                wayFigure.add(to);
                return wayFigure;
            } else if(from.getX()-to.getX() == -2){
                wayFigure.add(to);
                return wayFigure;
            }

        }

        return wayFigure;
    }

}
