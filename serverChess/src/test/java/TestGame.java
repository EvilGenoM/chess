package mobi.mpk;

import junit.framework.TestCase;
import mobi.mpk.domain.*;
import mobi.mpk.domain.figure.Pawn;
import mobi.mpk.domain.figure.kNight;
import mobi.mpk.domain.game.ClassicChessGame;
import mobi.mpk.domain.game.Game;
import mobi.mpk.domain.rules.ClassicRulesStrokes;
import mobi.mpk.domain.rules.RulesStrokes;
import mobi.mpk.net.User;
import org.junit.*;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class TestGame {

    private RulesStrokes rulesStrokes;
    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void init(){
        rulesStrokes = new ClassicRulesStrokes();
        game = new ClassicChessGame(player1, player2);
    }

    @After
    public void tearDown(){
        rulesStrokes = null;
    }



    @org.junit.Test
    public void equalsPlayer(){
        User user = new User();
        user.setName("sd");

        Player player1 = new Player(user);
        Player player2 = new Player(user);

        assertTrue(player1.equals(player2));
    }

    @Test
    public void madeStroke(){
        Stroke stroke = new Stroke("b1 c3");
        Cell to = new Cell('c',3);
        Cell from = new Cell('b',1);

        System.out.println(stroke.getFrom().getX()+""+stroke.getFrom().getY());
        System.out.println(from.getX()+""+from.getY());

        boolean cells = stroke.getFrom().equals(from);
        boolean cells2 = stroke.getTo().equals(to);

        assertTrue(cells);
        assertTrue(cells2);

    }

    @Test
    public void madeBoard(){
        Board board = new Board();
        Cell[][] cells = board.getMassiveCell();

        System.out.println(""+cells[0][0].getX()+cells[0][0].getY());

        boolean isCell = cells[0][0].equals(new Cell('a', 1));

        assertTrue(isCell);


    }




}
