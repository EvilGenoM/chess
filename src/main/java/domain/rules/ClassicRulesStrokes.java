package domain.rules;

import domain.Board;
import domain.Cell;
import domain.ResultStroke;
import domain.figure.Figure;
import domain.rules.crfigure.*;

import static constant.Constant.*;

public class ClassicRulesStrokes implements RulesStrokes{

    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        Figure figure;
        RulesStrokesFigure rulesSF;
        ResultStroke resultStroke = new ResultStroke();

        if(from.getFigure() != null){
            figure = from.getFigure();
        } else {

            resultStroke.setText(ERROR_CELL_YOUFIGURE);
            return resultStroke;

        }

        String s = figure.getClass().getSimpleName();
        if (s.equals("King")) {
            rulesSF = new ClassicRulesStrokesKing();
            return rulesSF.strokeFigure(from, to, board);
        } else if (s.equals("Queen")) {
            rulesSF = new ClassicRulesStrokesQueen();
            return rulesSF.strokeFigure(from, to, board);
        } else if (s.equals("Bishop")) {
            rulesSF = new ClassicRulesStrokesBishop();
            return rulesSF.strokeFigure(from, to, board);
        } else if (s.equals("kNight")) {
            rulesSF = new ClassicRulesStrokesKnight();
            return rulesSF.strokeFigure(from, to, board);
        } else if (s.equals("Rook")) {
            rulesSF = new ClassicRulesStrokesRook();
            return rulesSF.strokeFigure(from, to, board);
        } else if (s.equals("Pawn")) {
            rulesSF = new ClassicRulesStrokesPawn();
            return rulesSF.strokeFigure(from, to, board);
        } else {
            resultStroke.setText(ERROR_MOVE);
            return resultStroke;
        }

    }


}
