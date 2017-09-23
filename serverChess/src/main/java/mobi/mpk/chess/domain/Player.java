package mobi.mpk.chess.domain;

import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rules.Rules;

import java.util.List;

public class Player {

    private User user;
    private Color colorFigures;

    public Player(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public ResultStroke move(Stroke stroke, Board board, Rules rules){

        Cell from = board.getCell(stroke.getFrom());
        Cell to = board.getCell(stroke.getTo());

        stroke = new Stroke(from, to);

        if(from.getFigure() == null){
            return errorStroke("There is no figure in the cell");
        }

        Figure figure = from.getFigure();

        if(figure.getColor() != colorFigures){
            return errorStroke("The figure does not belong to you");
        }

        List<Cell> wayFigure = figure.move(stroke, rules);

        if(wayFigure.isEmpty()){
            return errorStroke("The figure can not go to this cell");
        }

        boolean isFreeWayFigure = checkWayFigure(wayFigure, to, board);
        if(!isFreeWayFigure){
            return errorStroke("There are obstacles on the way of the figure");
        }

        boolean isCanPutFigure = rules.canPutFigure(from, to);
        if(!isCanPutFigure){
            return errorStroke("This cell already has your figure");
        }

        to.setFigure(figure);
        from.setFigure(null);

        return successStroke("Progress is successful");
    }

    private ResultStroke errorStroke(String text){

        ResultStroke resultStroke = new ResultStroke(text, false);

        return resultStroke;
    }

    private boolean checkWayFigure(List<Cell> wayFigure, Cell to, Board board){

        for(Cell cell: wayFigure){
            Cell cellBoard = board.getCell(cell);
            Figure figureCheck = cellBoard.getFigure();
            if(figureCheck != null && !cell.equals(to)){
                return false;
            }
        }

        return true;
    }

    private ResultStroke successStroke(String text){

        ResultStroke resultStroke = new ResultStroke(text, true);

        return resultStroke;
    }

    public Color getColorFigures() {
        return colorFigures;
    }

    public void setColorFigures(Color colorFigures) {
        this.colorFigures = colorFigures;
    }

}
