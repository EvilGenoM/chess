package mobi.mpk.chess.controller;

import mobi.mpk.chess.Message;
import mobi.mpk.chess.User;

public class ControllerGame implements Controller {

    private Game game;
    private User user1;
    private User user2;

    public ControllerGame(User user1, User user2){

        Player player1 = new Player(user1);
        Player player2 = new Player(user2);

        this.game = new Game(player1, player2);

    }

    @Override
    public Message handleMessage(Message message) {
        return null;
    }

}
