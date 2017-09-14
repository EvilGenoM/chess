package mobi.mpk.domain;

import mobi.mpk.controller.*;
import mobi.mpk.domain.game.*;
import mobi.mpk.net.User;

import static mobi.mpk.net.Server.getPlayersList;

public class GameController {

    private Connect connect;
    private Game game;

    public GameController(Connect connect){

        this.connect = connect;

        Player[] players = getPlayers();


        game = new ClassicChessGame(players[0], players[1]);

    }

    public Reply handleStroke(Request request, User user, Reply replyEnemy){

        Reply reply = new Reply();

        if(request.getText() != null){

            Stroke stroke = new Stroke(request.getText());
            String answer = game.handleStroke(stroke, user);
            reply.setText(answer);

            if(answer.equals("Ход успешно сделан")){
                replyEnemy.setText(""+user.getName()+": " + request.getText());
            }

        }

        return reply;
    }


    private Player[] getPlayers(){

        Player[] players = new Player[2];

        for(Player player : getPlayersList()){

            boolean isPlayerInList = isPlayerInList(player, connect.getPlayer1Controller());
            if(isPlayerInList){
                players[0] = player;
            }

            isPlayerInList = isPlayerInList(player, connect.getPlayer2Controller());
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
                    players[i] = new Player(connect.getPlayer1Controller().getUser());
                } else{
                    players[i] = new Player(connect.getPlayer2Controller().getUser());
                }

                getPlayersList().add(players[i]);

            }

        }

    }



}
