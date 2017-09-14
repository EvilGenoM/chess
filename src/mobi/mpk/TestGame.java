package mobi.mpk;

import junit.framework.TestCase;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.Player;
import mobi.mpk.domain.Stroke;
import mobi.mpk.domain.figure.Pawn;
import mobi.mpk.domain.figure.kNight;
import mobi.mpk.domain.game.ClassicChessGame;
import mobi.mpk.domain.game.Game;
import mobi.mpk.domain.rules.ClassicRulesStrokes;
import mobi.mpk.domain.rules.RulesStrokes;
import mobi.mpk.net.User;
import org.junit.*;

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
    public void strokeFigure(){

        Cell[] to = new Cell[8];
        to[0] = new Cell('d',2, null);
        to[1] = new Cell('f',2, null);
        to[2] = new Cell('c',3, null);
        to[3] = new Cell('c',5, null);
        to[4] = new Cell('g',3, null);
        to[5] = new Cell('c',5, null);
        to[6] = new Cell('d',6, null);
        to[7] = new Cell('f',6, new kNight(Color.black));

        for(int i = 0; i<8; i++){

            Cell from = new Cell('e',4, new kNight(Color.white));
            boolean isStroke = rulesStrokes.strokeFigure(from, to[i], null);
            assertTrue(isStroke);

        }


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



}
