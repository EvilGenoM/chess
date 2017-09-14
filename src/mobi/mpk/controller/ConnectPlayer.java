package mobi.mpk.controller;

import mobi.mpk.domain.GameController;
import mobi.mpk.net.Server;
import mobi.mpk.net.User;

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

        if(gameController == null) {

            String[] comand = request.getText().split(" ");
            System.out.println(comand[0]);

            switch (comand[0]) {
                case "join":
                    player1Controller = control;
                    return connectPlayer(request);
                default:
                    if (player2Controller != null && player2Controller == control) {
                        return confirmConnection(request);
                    }
                    break;
            }

        } else {

            if(control.equals(getPlayer1Controller())){
                return sendRequestGame(request, player1Controller, player2Controller);
            } else {
                return sendRequestGame(request, player2Controller, player1Controller);
            }

        }

        return null;

    }

    private Reply sendRequestGame(Request request,
                                 Controller controllerPlayerStroke,
                                 Controller controllerPlayerWait){

        Reply replyPlayerWait = new Reply();
        Reply replyPlyaerStroke = gameController.handleStroke(request,
                                                                controllerPlayerStroke.getUser(),
                                                                replyPlayerWait);

        if(replyPlayerWait != null){
            controllerPlayerWait.sendReply(replyPlayerWait);
        }

        return replyPlyaerStroke;

    }

    private Reply connectPlayer(Request request){

        Reply reply = new Reply();
        String playerName = parseReplyText(request);
        User player = null;

        for(User gamer : Server.getUserList()){
            if(gamer.getName().equals(playerName)){
                player = gamer;
                break;
            }
        }

        if(player == null){
            reply.setLog("Игрок не найден");
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
            reply.setText("Ошибка нахождения контроллера");
            return reply;
        }

        reply.setText("Ожидайте ответа");

        return reply;

    }

    private Reply confirmConnection(Request request){

        Reply reply = new Reply();

        if(request.getText().equals("Y")){

            gameController = new GameController(this);
            player1Controller.setWait(false);
            reply.setText("Игра началась");
            player1Controller.sendReply(reply);

        } else{

            unconnect();
            reply.setText("Соединение разорвано!");
            player1Controller.sendReply(reply);

        }

        return reply;
    }

    private void unconnect(){

        player1Controller.setWait(false);

        player2Controller.setConnect(new ConnectPlayer());
        player2Controller = null;

        player1Controller = null;

    }

    private String parseReplyText(Request request){

        String[] connectPlayer = request.getText().split(" ");
        String playerName = "";

        for(int i = 1; i < connectPlayer.length; i++){
            playerName += connectPlayer[i]+"";
        }

        return playerName.trim();
    }


}
