package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.ResultStroke;
import mobi.mpk.domain.rules.RulesStrokesFigure;

import static mobi.mpk.Constant.*;

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


}
