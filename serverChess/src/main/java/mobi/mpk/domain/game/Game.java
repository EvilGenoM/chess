package mobi.mpk.domain.game;

import mobi.mpk.domain.*;
import mobi.mpk.domain.rules.Rules;
import mobi.mpk.net.User;

import java.util.Date;

public abstract class Game {

    private Date beginTime;

    private Player playerWhite;
    private Player playerBlack;

    private Board board;

    private Rules rules;

    public Game(Player player1, Player player2, Rules rules){

        this.rules = rules;

        Player[] players = this.rules.identifyWhitePlayer(player1, player2);

        this.playerWhite = players[0];

        this.playerBlack = players[1];

        this.beginTime = new Date();

        this.board = new Board();


    }

    public abstract ResultStroke handleStroke(Stroke stroke, User user);

    public abstract Color getColorPlayer(Player player);

    protected abstract void initBoard();

    protected Board getBoard(){
        return board;
    }

    protected Rules getRules() { return rules; }

    protected Player getPlayerBlack() {
        return playerBlack;
    }

    protected Player getPlayerWhite() {
        return playerWhite;
    }

}
