package mobi.mpk.controller;

import mobi.mpk.Constant;
import mobi.mpk.net.Server;
import mobi.mpk.net.User;

import static mobi.mpk.net.Server.getControllerList;

public class Connect {

    Controller player1Controller;
    Controller player2Contoller;


    public Reply execute(Request request, Controller control){


        String[] comand = request.getText().split(" ");
        System.out.println(comand[0]);
        switch (comand[0]){
            case "join":
                player1Controller = control;
                return connectPlayer(request);
            case "Y":
                if(player2Contoller != null && player2Contoller == control){
                    System.out.println("Okay");
                }
                break;
            default:
                break;
        }

        return null;

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
                player2Contoller = controller;
                player2Contoller.setConnect(this);
                Reply sendReply = new Reply();
                sendReply.setText("Вам предлагает поиграть игрок "+
                                        player1Controller.getUser().getName()+" [Y/N]");
                player2Contoller.sendReply(sendReply);
                player1Controller.setWait(true);
                break;
            }
        }

        if(player2Contoller == null){
            reply.setText("Ошибка нахождения контроллера");
            return reply;
        }

        reply.setText("Ожидайте ответа");

        return reply;

    }

    private Reply 

    private String parseReplyText(Request request){

        String[] connectPlayer = request.getText().split(" ");
        String playerName = "";

        for(int i = 1; i < connectPlayer.length; i++){
            playerName += connectPlayer[i]+"";
        }

        return playerName.trim();
    }


}
