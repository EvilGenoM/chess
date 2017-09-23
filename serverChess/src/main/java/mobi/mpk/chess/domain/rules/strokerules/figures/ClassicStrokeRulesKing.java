package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.LinkedList;
import java.util.List;

public class ClassicStrokeRulesKing extends ClassicStrokeRulesFigure{

    @Override
    public List<Cell> move(Cell from, Cell to) {

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(from.getX()-to.getX() == 1){

            if(from.getY()-to.getY() == 1){
                wayFigure.add(to);
                return wayFigure; //down l
            } else if(from.getY()-to.getY() == -1){
                wayFigure.add(to);
                return wayFigure; //up l
            } else if(from.getY()-to.getY() == 0){
                wayFigure.add(to);
                return wayFigure; //left
            }

        } else if(from.getX()-to.getX() == -1) {

            if(from.getY()-to.getY() == 1){
                wayFigure.add(to);
                return wayFigure; //down r
            } else if(from.getY()-to.getY() == -1){
                wayFigure.add(to);
                return wayFigure; //up r
            } else if(from.getY()-to.getY() == 0){
                wayFigure.add(to);
                return wayFigure; //right
            }

        } else if(from.getX()-to.getX() == 0){

            if(from.getY()-to.getY() == 1){
                wayFigure.add(to);
                return wayFigure; //down
            } else if(from.getY()-to.getY() == -1){
                wayFigure.add(to);
                return wayFigure; //up
            }

        }

        return wayFigure;
    }

}
