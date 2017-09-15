package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.ResultStroke;

import static mobi.mpk.Constant.ERROR_CELL;

public class ClassicRulesStrokesPawn extends ClassicRulesStrokesFigure{

    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        if(from.getFigure().getColor() == Color.white){
            return strokeWhitePawn(from, to, board);
        } else {
            return strokeBlackPawn(from, to, board);
        }

    }

    private ResultStroke strokeWhitePawn(Cell from, Cell to, Board board){

        ResultStroke resultStroke = new ResultStroke();

        Cell[][] cells = board.getMassiveCell();

        int[] coordCell = findCellOnBoard(from, cells);

        if(to.getY()-from.getY() == 1){ // 1 cell

            if(to.getFigure() == null){
                return moveFigure(from, to);
            }

        } else if(to.getY()-from.getY() == 2){ // 2 cell

            Cell beforeCell = cells[coordCell[0]][to.getY()-1];

            if(to.getFigure() == null && beforeCell.getFigure() == null){

                return moveFigure(from, to);

            }

        } else if(to.getY()-from.getY() == to.getX()-from.getX()){ //attack
            if(to.getX()-from.getX() == 1  && to.getY()-from.getY() == 1){ //right

                if(to.getFigure() != null){
                    return moveFigure(from, to);
                }

            } else if(to.getX()-from.getX() == -1 && to.getY()-from.getY() == 1){ //left

                if(to.getFigure() != null){
                    return moveFigure(from, to);
                }

            }
        }

        resultStroke.setText(ERROR_CELL);

        return resultStroke;


    }


    private ResultStroke strokeBlackPawn(Cell from, Cell to, Board board){

        ResultStroke resultStroke = new ResultStroke();

        Cell[][] cells = board.getMassiveCell();

        int[] coordCell = findCellOnBoard(from, cells);

        if(to.getY()-from.getY() == -1){ // 1 cell

            if(to.getFigure() == null){
                return moveFigure(from, to);
            }

        } else if(to.getY()-from.getY() == -2){ // 2 cell

            Cell beforeCell = cells[coordCell[0]][to.getY()+1];

            if(to.getFigure() == null && beforeCell.getFigure() == null){

                return moveFigure(from, to);

            }

        } else if(to.getY()-from.getY() == to.getX()-from.getX()){ //attack
            if(to.getX()-from.getX() == 1  && to.getY()-from.getY() == -1){ //right

                if(to.getFigure() != null){
                    return moveFigure(from, to);
                }

            } else if(to.getX()-from.getX() == -1 && to.getY()-from.getY() == -1){ //left

                if(to.getFigure() != null){
                    return moveFigure(from, to);
                }

            }
        }

        resultStroke.setText(ERROR_CELL);

        return resultStroke;


    }


}
