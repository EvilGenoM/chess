package mobi.mpk.domain.rules.crfigure;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.ResultStroke;

import static mobi.mpk.Constant.ERROR_CELL;
import static mobi.mpk.Constant.ERROR_WAY_FIGURE;

public class ClassicRulesStrokesBishop extends ClassicRulesStrokesFigure {

    @Override
    public ResultStroke strokeFigure(Cell from, Cell to, Board board) {

        ResultStroke resultStroke = new ResultStroke();

        Cell[][] cells = board.getMassiveCell();

        int[] coordFrom = findCellOnBoard(from, cells);
        int[] coordTo = findCellOnBoard(to, cells);


        if(from.getX()-to.getX() == from.getY()-to.getY()){


            if(from.getX()-to.getX()<0 && from.getY()-to.getY()<0){ //up right

                int x = coordFrom[0]+1;

                for(int y = coordFrom[1]+1; y<coordTo[1]; y++){
                    if(cells[x][y].getFigure() != null){
                        resultStroke.setText(ERROR_WAY_FIGURE);
                        return resultStroke;
                    }
                    x++;
                }

                return moveFigure(from, to);

            } else if(from.getX()-to.getX()>0 && from.getY()-to.getY()<0){ //up left

                int x = coordFrom[0]-1;

                for(int y = coordFrom[1]+1; y<coordTo[1]; y++){
                    if(cells[x][y].getFigure() != null){
                        resultStroke.setText(ERROR_WAY_FIGURE);
                        return resultStroke;
                    }
                    x--;
                }

                return moveFigure(from, to);

            } else if(from.getX()-to.getX()<0 && from.getY()-to.getY()>0){ // down right

                int x = coordFrom[0]+1;

                for(int y = coordFrom[1]-1; y<coordTo[1]; y--){
                    if(cells[x][y].getFigure() != null){
                        resultStroke.setText(ERROR_WAY_FIGURE);
                        return resultStroke;
                    }
                    x++;
                }

                return moveFigure(from, to);


            } else if(from.getX()-to.getX()>0 && from.getY()-to.getY()>0){ // down left

                int x = coordFrom[0]-1;

                for(int y = coordFrom[1]-1; y<coordTo[1]; y--){
                    if(cells[x][y].getFigure() != null){
                        resultStroke.setText(ERROR_WAY_FIGURE);
                        return resultStroke;
                    }
                    x--;
                }

                return moveFigure(from, to);

            }


        } else {

            resultStroke.setText(ERROR_CELL);

        }

        return resultStroke;

    }

}
