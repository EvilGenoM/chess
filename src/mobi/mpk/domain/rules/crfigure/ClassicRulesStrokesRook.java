package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.ResultStroke;

import static mobi.mpk.Constant.ERROR_CELL;
import static mobi.mpk.Constant.ERROR_WAY_FIGURE;

public class ClassicRulesStrokesRook extends ClassicRulesStrokesFigure {


    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        ResultStroke resultStroke = new ResultStroke();

        Cell[][] cells = board.getMassiveCell();

        int[] coordFrom = findCellOnBoard(from, cells);
        int[] coordTo = findCellOnBoard(to, cells);

        if(from.getX()-to.getX()>0){ // left

            for(int x = coordFrom[0]-1; x>coordTo[0]; x--){
                if(cells[x][coordFrom[1]].getFigure() != null){
                    resultStroke.setText(ERROR_WAY_FIGURE);
                    return resultStroke;
                }
            }

            return moveFigure(from, to);

        } else if(from.getX()-to.getX()<0){ // right

            for(int x = coordFrom[0]+1; x<coordTo[0]; x++){
                if(cells[x][coordFrom[1]].getFigure() != null){
                    resultStroke.setText(ERROR_WAY_FIGURE);
                    return resultStroke;
                }
            }

            return moveFigure(from, to);

        } else if(from.getY()-to.getY()>0){ // down

            for(int y = coordFrom[1]-1; y>coordTo[1]; y--){
                if(cells[coordFrom[0]][y].getFigure() != null){
                    resultStroke.setText(ERROR_WAY_FIGURE);
                    return resultStroke;
                }
            }

            return moveFigure(from, to);

        }else if(from.getY()-to.getY()<0){ // up

            for(int y = coordFrom[1]+1; y<coordTo[1]; y++){
                if(cells[coordFrom[0]][y].getFigure() != null){
                    resultStroke.setText(ERROR_WAY_FIGURE);
                    return resultStroke;
                }
            }

            return moveFigure(from, to);

        }

        resultStroke.setText(ERROR_CELL);

        return resultStroke;

    }


}
