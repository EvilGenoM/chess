package mobi.mpk.controller;

import mobi.mpk.cli.Reply;
import mobi.mpk.cli.Request;
import mobi.mpk.domain.GameController;
import mobi.mpk.net.Server;
import mobi.mpk.net.User;

import static mobi.mpk.Constant.*;
import static mobi.mpk.net.Server.getControllerList;

public class ConnectPlayer implements Connect {

    private Controller player1Controller;
    private Controller player2Controller;
    private GameController gameController;

    @Override
    public Controller getPlayer1Controller() {
        return player1Controller;
    }

    @Override
    public Controller getPlayer2Controller() {
        return player2Controller;
    }

    @Override
    public Reply execute(Request request, Controller control){


        String[] comand = request.getText().split(" ");
        System.out.println(comand[0]);

        switch (comand[0]) {
            case COMMAND_JOIN:
                player1Controller = control;
                return connectPlayer(request);
            default:
                if (player2Controller != null && player2Controller == control) {
                    confirmConnection(request);
                }
                break;
        }


        return null;

    }


    private Reply connectPlayer(Request request){

        Reply reply = new Reply();
        String playerName = findName(request);
        User player = null;

        for(User gamer : Server.getUserList()){
            if(gamer.getName().equals(playerName)){
                player = gamer;
                break;
            }
        }

        if(player == null){
            reply.setLog(ERROR_CONNECT_PLAYER);
            return reply;
        }

        for (Controller controller : getControllerList()){
            if(controller.getUser().equals(player)){
                player2Controller = controller;
                player2Controller.setConnect(this);
                Reply sendReply = new Reply();
                sendReply.setText("Вам предлагает поиграть игрок "+
                                        player1Controller.getUser().getName()+" [Y/N]");
                player2Controller.sendReply(sendReply);
                player1Controller.setWait(true);
                break;
            }
        }

        if(player2Controller == null){
            reply.setText(ERROR_CONNECT);
            return reply;
        }

        reply.setText(CONNECT_WAIT);

        return reply;

    }

    private void confirmConnection(Request request){

        Reply reply = new Reply();

        if(request.getText().equals("Y")){

            player1Controller.setWait(false);

            reply.setText(GAME_BEGIN);

            player1Controller.sendReply(reply);
            player2Controller.sendReply(reply);

            gameController = new GameController(player1Controller, player2Controller);

            player1Controller.setGameController(gameController);
            player2Controller.setGameController(gameController);

        } else{

            unconnect();

            reply.setText(ERROR_COMMAND);

            player1Controller.sendReply(reply);
            player2Controller.sendReply(reply);

        }

    }

    public void unconnect(){

        player1Controller.setGameController(null);
        player2Controller.setGameController(null);

        player1Controller.setWait(false);

        player2Controller.setConnect(new ConnectPlayer());
        player2Controller = null;

        player1Controller = null;


    }

    private String findName(Request request){

        String[] connectPlayer = request.getText().split(" ");
        String playerName = "";

        for(int i = 1; i < connectPlayer.length; i++){
            playerName += connectPlayer[i]+"";
        }

        return playerName.trim();
    }


}
