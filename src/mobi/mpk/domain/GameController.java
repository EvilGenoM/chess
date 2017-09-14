package mobi.mpk.domain;

import mobi.mpk.controller.*;
import mobi.mpk.domain.game.*;
import mobi.mpk.net.User;

import static mobi.mpk.Constant.*;
import static mobi.mpk.net.Server.getPlayersList;

public class GameController {

    private Controller player1Controller;
    private Controller player2Controller;
    private Game game;

    public GameController(Controller player1Controller, Controller player2Controller){

        this.player1Controller = player1Controller;
        this.player2Controller = player2Controller;

        Player[] players = getPlayers();

        game = new ClassicChessGame(players[0], players[1]);

        Reply reply1 = new Reply();
        Reply reply2 = new Reply();

        if(game.getColorPlayer(players[0]) == Color.white){

            reply1.setText(GAME_YOUWHITE);
            this.player1Controller.sendReply(reply1);

            reply2.setText(GAME_YOUBLACK);
            this.player2Controller.sendReply(reply2);

        } else {

            reply1.setText(GAME_YOUWHITE);
            this.player2Controller.sendReply(reply1);

            reply2.setText(GAME_YOUBLACK);
            this.player1Controller.sendReply(reply2);

        }

    }

    public Reply sendRequest(Request request, User user){

        Reply reply = new Reply();

        if(request.getText() != null){

            Stroke stroke = new Stroke(request.getText());
            String answer = game.handleStroke(stroke, user);
            reply.setText(answer);

        }

        return reply;

    }


    private Player[] getPlayers(){

        Player[] players = new Player[2];

        for(Player player : getPlayersList()){

            boolean isPlayerInList = isPlayerInList(player, player1Controller);
            if(isPlayerInList){
                players[0] = player;
            }

            isPlayerInList = isPlayerInList(player, player2Controller);
            if(isPlayerInList){
                players[1] = player;
            }

        }

        if(players[0] != null && players[1] != null){
            return players;
        } else {
            createPlayers(players);
        }

        return players;
    }

    private boolean isPlayerInList(Player player, Controller controller){

        if(controller.getUser().equals(player.getUser())){
            return true;
        } else {
            return false;
        }

    }

    private void createPlayers(Player[] players){

        for(int i = 0; i<2; i++){

            if(players[i] == null){

                if(i == 0){
                    players[i] = new Player(player1Controller.getUser());
                } else{
                    players[i] = new Player(player2Controller.getUser());
                }

                getPlayersList().add(players[i]);

            }

        }

    }



}
