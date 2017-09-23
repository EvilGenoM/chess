import com.sun.org.apache.regexp.internal.RE;
import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Pawn;
import mobi.mpk.chess.domain.rules.ClassicRules;
import mobi.mpk.chess.domain.rules.Rules;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {

    @Test
    public void testMoveSuccess(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.white);
        cell.setFigure(figure);

        String strokeStr = "a1 a2";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        cell = new Cell('a', 2);

        cell = board.getCell(cell);
        Figure figureEnd = cell.getFigure();

        assertEquals(figure, figureEnd);

    }

    @Test
    public void testMoveNotColor(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.black);
        cell.setFigure(figure);

        String strokeStr = "a1 a2";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "The figure does not belong to you");

    }

    @Test
    public void testMoveNotFigure(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        Figure figure = null;
        cell.setFigure(figure);

        String strokeStr = "a1 a2";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "There is no figure in the cell");

    }

    @Test
    public void testMoveNotWay(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.white);
        cell.setFigure(figure);

        String strokeStr = "a1 a5";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "The figure can not go to this cell");

    }

    @Test
    public void testMoveObstacles(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 2);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.white);
        cell.setFigure(figure);

        cell = new Cell('a', 3);
        cell = board.getCell(cell);
        Figure figure2 = new Pawn(Color.white);
        cell.setFigure(figure2);

        String strokeStr = "a2 a4";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "There are obstacles on the way of the figure");

    }

    @Test
    public void testMoveCellYou(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 2);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.white);
        cell.setFigure(figure);

        cell = new Cell('a', 4);
        cell = board.getCell(cell);
        Figure figure2 = new Pawn(Color.white);
        cell.setFigure(figure2);

        String strokeStr = "a2 a4";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "This cell already has your figure");

    }

    @Test
    public void testMoveCellYou2(){

        User user = new User("Player");
        Player player = new Player(user);
        player.setColorFigures(Color.white);

        Board board = new Board();
        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        Figure figure = new Pawn(Color.white);
        cell.setFigure(figure);

        cell = new Cell('a', 2);
        cell = board.getCell(cell);
        Figure figure2 = new Pawn(Color.white);
        cell.setFigure(figure2);

        String strokeStr = "a1 a2";
        Stroke stroke = new Stroke(strokeStr);

        Rules rules = new ClassicRules();

        ResultStroke resultStroke = player.move(stroke, board, rules);
        String result = resultStroke.getText();

        assertEquals(result, "This cell already has your figure");

    }

}
