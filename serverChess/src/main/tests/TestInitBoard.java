import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.game.ClassicGame;
import mobi.mpk.chess.domain.game.Game;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestInitBoard {

    @Test
    public void testInitBoard(){

        User user1 = new User("Gamer1");
        User user2 = new User("Ganer2");

        Player player1 = new Player(user1);
        Player player2 = new Player(user2);

        Game game = new ClassicGame(player1, player2);
        List<Figure> figures = game.getListFiguresOnBoard();
        List<String>figuresName = new LinkedList<String>();

        for(Figure figure : figures) {
            if (figure != null) {
                figuresName.add(figure.getClass().getSimpleName());
            } else {
                figuresName.add(null);
            }
        }

        List<String>nameTest = new LinkedList<String>();
        //1
        nameTest.add("Rook");
        nameTest.add("kNight");
        nameTest.add("Bishop");
        nameTest.add("Queen");
        nameTest.add("King");
        nameTest.add("Bishop");
        nameTest.add("kNight");
        nameTest.add("Rook");
        //2
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        //3
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        //4
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        //5
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        //6
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        nameTest.add(null);
        //7
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        nameTest.add("Pawn");
        //8
        nameTest.add("Rook");
        nameTest.add("kNight");
        nameTest.add("Bishop");
        nameTest.add("Queen");
        nameTest.add("King");
        nameTest.add("Bishop");
        nameTest.add("kNight");
        nameTest.add("Rook");

        assertEquals(figuresName, nameTest);


    }

}
