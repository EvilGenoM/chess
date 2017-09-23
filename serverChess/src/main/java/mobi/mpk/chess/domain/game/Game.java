package mobi.mpk.chess.domain.game;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.ResultStroke;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rules.Rules;

import java.util.List;

public abstract class Game {

    private Player player1;
    private Player player2;
    private Rules rules;
    private Board board;

    public Game(Player player1, Player player2, Rules rules){

        this.player1 = player1;
        this.player2 = player2;

        this.player1.setColorFigures(Color.white);
        this.player2.setColorFigures(Color.black);

        this.rules = rules;
        this.board = new Board();

    }

    public abstract void initBoard();

    public abstract ResultStroke doStroke(Player player, String stroke);

    public abstract List<Figure> getListFiguresOnBoard();

    protected Player getPlayer1(){
        return this.player1;
    }

    protected Player getPlayer2(){
        return this.player2;
    }

    protected Board getBoard(){
        return this.board;
    }

    protected Rules getRules(){
        return this.rules;
    }

}
