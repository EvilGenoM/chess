package mobi.mpk.chess.domain.rules.strokerules.figures;

import mobi.mpk.chess.domain.Cell;

import java.util.LinkedList;
import java.util.List;

public abstract class ClassicStrokeRulesFigure {

    public abstract List<Cell> move(Cell from, Cell to);

    protected List<Cell> moveDiagonal(Cell from, Cell to) {

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(Math.abs(from.getX()-to.getX()) == Math.abs(from.getY()-to.getY())){

            if(from.getX()-to.getX()<0 && from.getY()-to.getY()<0){ //up right

                wayFigure = createWayDiagonalFigure(from, to);

            } else if(from.getX()-to.getX()>0 && from.getY()-to.getY()<0){ //up left

                wayFigure = createWayDiagonalFigure(from, to);

            } else if(from.getX()-to.getX()<0 && from.getY()-to.getY()>0){ // down right

                wayFigure = createWayDiagonalFigure(from, to);

            } else if(from.getX()-to.getX()>0 && from.getY()-to.getY()>0){ // down left

                wayFigure = createWayDiagonalFigure(from, to);

            }

        }

        return wayFigure;
    }

    protected List<Cell> moveLine(Cell from, Cell to) {

        List<Cell> wayFigure = new LinkedList<Cell>();

        if(from.getX()-to.getX()>0 && from.getY() == to.getY()){ // left

            wayFigure = createWayHorizontFigure(from, to);
            return wayFigure;

        } else if(from.getX()-to.getX()<0 && from.getY() == to.getY()){ // right

            wayFigure = createWayHorizontFigure(from, to);
            return wayFigure;

        } else if(from.getY()-to.getY()>0 && from.getX() == to.getX()){ // down

            wayFigure = createWayVerticalFigure(from, to);
            return wayFigure;

        } else if(from.getY()-to.getY()<0 && from.getX() == to.getX()){ // up

            wayFigure = createWayVerticalFigure(from, to);
            return wayFigure;

        }

        return wayFigure;
    }

    protected List<Cell> createWayDiagonalFigure(Cell from, Cell to){

        List<Cell> wayFigure = new LinkedList<>();

        char fromX = from.getX();
        int fromY = from.getY();

        char toX = to.getX();
        int toY = to.getY();

        int changeX = (toX-fromX)/Math.abs(toX-fromX);
        int changeY = (toY-fromY)/Math.abs(toY-fromY);

        while(fromX != toX){

            fromX += changeX;
            fromY += changeY;

            Cell cell = new Cell(fromX, fromY);
            wayFigure.add(cell);

        }

        return wayFigure;

    }

    protected List<Cell> createWayHorizontFigure(Cell from, Cell to){

        List<Cell> wayFigure = new LinkedList<>();

        char fromX = from.getX();
        int fromY = from.getY();

        char toX = to.getX();
        int toY = to.getY();

        int changeX = (toX-fromX)/Math.abs(toX-fromX);

        while(fromX != toX){

            fromX += changeX;

            Cell cell = new Cell(fromX, fromY);
            wayFigure.add(cell);

        }

        return wayFigure;

    }

    protected List<Cell> createWayVerticalFigure(Cell from, Cell to){

        List<Cell> wayFigure = new LinkedList<>();

        char fromX = from.getX();
        int fromY = from.getY();

        char toX = to.getX();
        int toY = to.getY();

        int changeY = (toY-fromY)/Math.abs(toY-fromY);

        while(fromY != toY){

            fromY += changeY;

            Cell cell = new Cell(fromX, fromY);
            wayFigure.add(cell);

        }

        return wayFigure;

    }

}
