package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.ResultStroke;
import mobi.mpk.domain.figure.Figure;
import mobi.mpk.domain.rules.crfigure.*;

import static mobi.mpk.Constant.*;

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

        switch (figure.getClass().getSimpleName()){
            case "King":
                rulesSF = new ClassicRulesStrokesKing();
                return rulesSF.strokeFigure(from, to, board);
            case "Queen":
                rulesSF = new ClassicRulesStrokesQueen();
                return rulesSF.strokeFigure(from, to, board);
            case "Bishop":
                rulesSF = new ClassicRulesStrokesBishop();
                return rulesSF.strokeFigure(from, to, board);
            case "kNight":
                rulesSF = new ClassicRulesStrokesKnight();
                return rulesSF.strokeFigure(from, to, board);
            case "Rook":
                rulesSF = new ClassicRulesStrokesRook();
                return rulesSF.strokeFigure(from, to, board);
            case "Pawn":
                rulesSF = new ClassicRulesStrokesPawn();
                return rulesSF.strokeFigure(from, to, board);
            default:
                resultStroke.setText(ERROR_MOVE);
                return resultStroke;
        }

    }


}
