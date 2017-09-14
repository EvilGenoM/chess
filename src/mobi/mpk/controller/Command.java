package mobi.mpk.controller;

import mobi.mpk.Constant;
import mobi.mpk.net.Server;
import mobi.mpk.net.User;

import static mobi.mpk.net.Server.getUserList;
import static mobi.mpk.Constant.*;


public class Command {

    public boolean execute(Request request, Reply reply){

        switch (request.getText()){
            case COMMAND_HELP:
                reply.setLog(LOG_COMMAND+" "+COMMAND_HELP+"\n");
                reply.setText(REPLY_HELP);
                return true;
            case COMMAND_PLAYERS:
                reply.setLog(LOG_COMMAND+" "+COMMAND_PLAYERS+"\n");
                reply.setText(userList());
                return true;
            case COMMAND_CLOSE:
                reply.setLog(LOG_COMMAND+" "+COMMAND_CLOSE+"\n");
                reply.setClose(true);
                return true;
            default:
                reply.setLog(ERROR_COMMAND);
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
