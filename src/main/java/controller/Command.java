package controller;

import cli.Reply;
import cli.Request;
import net.User;

import static constant.Constant.*;
import static net.Server.getUserList;


public class Command {

    public boolean execute(Request request, Reply reply){

        if (request.getText().equals(COMMAND_HELP)) {
            reply.setLog(LOG_COMMAND + " " + COMMAND_HELP + "\n");
            reply.setText(REPLY_HELP);
            return true;
        } else if (request.getText().equals(COMMAND_PLAYERS)) {
            reply.setLog(LOG_COMMAND + " " + COMMAND_PLAYERS + "\n");
            reply.setText(userList());
            return true;
        } else if (request.getText().equals(COMMAND_CLOSE)) {
            reply.setLog(LOG_COMMAND + " " + COMMAND_CLOSE + "\n");
            reply.setClose(true);
            return true;
        } else {
            reply.setLog(ERROR_COMMAND);

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
