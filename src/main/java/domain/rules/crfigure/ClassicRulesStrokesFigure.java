package domain.rules.crfigure;

import domain.Board;
import domain.Cell;
import domain.Color;
import domain.ResultStroke;
import domain.rules.RulesStrokesFigure;

import static constant.Constant.*;

public abstract class ClassicRulesStrokesFigure implements RulesStrokesFigure {

    public abstract ResultStroke strokeFigure(Cell from, Cell to, Board board);


    protected ResultStroke moveFigure(Cell from, Cell to){

        ResultStroke resultStroke = new ResultStroke();

        if(to.getFigure() != null){

            Color colorFigureFrom = from.getFigure().getColor();
            Color colorFigureTo = to.getFigure().getColor();

            if(colorFigureFrom != colorFigureTo){

                resultStroke.setText(SUCCESS_ATTACK+" "+to.getFigure().getClass().getSimpleName());
                resultStroke.setSuccess(true);

                to.setFigure(from.getFigure());
                from.setFigure(null);

                return resultStroke;

            } else {

                resultStroke.setText(ERROR_CELL_FIGURE);
                resultStroke.setSuccess(false);

                return resultStroke;
            }

        } else {

            to.setFigure(from.getFigure());
            from.setFigure(null);

            resultStroke.setText(SUCCESS_STROKE);
            resultStroke.setSuccess(true);

            return resultStroke;
        }

    }


    protected int[] findCellOnBoard(Cell cell, Cell[][] cells){

        int[] coordCell = new int[2];

        for(int x = 0; x<8; x++){

            for(int y = 0; y<8; y++){

                if(cells[x][y].equals(cell)){

                    coordCell[0] = x;
                    coordCell[1] = y;

                }

            }

        }

        return coordCell;

    }


}
