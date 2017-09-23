package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;

import java.util.LinkedList;
import java.util.List;

public class ClassicStrokeRulesPawn extends ClassicStrokeRulesFigure {

    @Override
    public List<Cell> move(Cell from, Cell to) {

        if(from.getFigure().getColor() == Color.white){
            return strokeWhitePawn(from, to);
        } else {
            return strokeBlackPawn(from, to);
        }

    }

    private List<Cell> strokeWhitePawn(Cell from, Cell to){

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(to.getY()-from.getY() == 1){ // 1 cell

            wayFigure.add(to);
            return wayFigure;

        } else if(to.getY()-from.getY() == 2 && from.getY() == 2){ // 2 cell

            int y = (from.getY()+1);
            Cell cell = new Cell(from.getX(), y);
            wayFigure.add(cell);
            wayFigure.add(to);
            return wayFigure;

        } else if(Math.abs(to.getY()-from.getY()) == Math.abs(to.getX()-from.getX())){ //attack
            if(to.getX()-from.getX() == 1  && to.getY()-from.getY() == 1){ //right

                if(to.getFigure() != null){
                    wayFigure.add(to);
                    return wayFigure;
                }

            } else if(to.getX()-from.getX() == -1 && to.getY()-from.getY() == 1){ //left

                if(to.getFigure() != null){
                    wayFigure.add(to);
                    return wayFigure;
                }

            }
        }

        return wayFigure;
    }


    private List<Cell> strokeBlackPawn(Cell from, Cell to){

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(to.getY()-from.getY() == -1){ // 1 cell

            wayFigure.add(to);
            return wayFigure;

        } else if(to.getY()-from.getY() == -2 && from.getY() == 7){ // 2 cell

            int y = (from.getY()-1);
            Cell cell = new Cell(from.getX(), y);
            wayFigure.add(cell);
            wayFigure.add(to);
            return wayFigure;

        } else if(Math.abs(to.getY()-from.getY()) == Math.abs(to.getX()-from.getX())){ //attack
            if(to.getX()-from.getX() == 1  && to.getY()-from.getY() == -1){ //right

                if(to.getFigure() != null){
                    wayFigure.add(to);
                    return wayFigure;
                }

            } else if(to.getX()-from.getX() == -1 && to.getY()-from.getY() == -1){ //left

                if(to.getFigure() != null){
                    wayFigure.add(to);
                    return wayFigure;
                }

            }
        }

        return wayFigure;
    }


}
