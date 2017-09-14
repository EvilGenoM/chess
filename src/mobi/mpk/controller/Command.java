package mobi.mpk.controller;

import mobi.mpk.Constant;
import mobi.mpk.net.Server;
import mobi.mpk.net.User;

import static mobi.mpk.net.Server.getUserList;


public class Command {

    public boolean execute(Request request, Reply reply){

        switch (request.getText()){
            case "help":
                reply.setLog(Constant.LOG_COMMAND+" help\n");
                reply.setText(Constant.REPLY_HELP);
                return true;
            case "players":
                reply.setLog(Constant.LOG_COMMAND+" players\n");
                reply.setText(userList());
                return true;
            case "close":
                reply.setLog(Constant.LOG_COMMAND+" close\n");
                reply.setClose(true);
                return true;
            default:
                reply.setLog(Constant.ERROR_COMMAND);
                break;
        }

        return false;

    }

    public User createName(Request request, Reply reply){

        User user = new User();
        user.setName(request.getText());

        return user;

    }

    private String userList(){
        String users = "";
        for(User user: getUserList()){
            users += user.getName()+"\n";
        }
        return users;
    }


}
