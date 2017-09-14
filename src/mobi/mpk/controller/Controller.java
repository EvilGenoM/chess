package mobi.mpk.controller;

import mobi.mpk.net.User;

import java.util.Stack;

import static mobi.mpk.net.Server.getControllerList;
import static mobi.mpk.net.Server.getUserList;

public class Controller {


    private Command command;
    private Connect connect;
    private Stack<Reply> replies;
    private User user;
    private boolean isWait;

    public Controller(){

        this.command = new Command();
        this.connect = new ConnectPlayer();
        replies = new Stack<Reply>();
        getControllerList().add(this);

    }

    public void setWait(boolean wait) {
        isWait = wait;
    }

    public User getUser() {
        return user;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public Reply getReply(){
        if(!replies.empty()) {
            return replies.pop();
        }
        return null;
    }


    public void handleRequest(Request request){

        Reply handleReply = new Reply();

        if(request.isStart()){

            User user = command.createName(request, handleReply);
            this.user = user;
            getUserList().add(user);
            handleReply.setText("Ваше имя " + user.getName());
            replies.push(handleReply);

        } else {

            boolean isCommand = command.execute(request, handleReply);

            if(!isWait && !isCommand) {
                handleReply = connect.execute(request, this);
            }

            replies.push(handleReply);

        }

    }

    public void sendReply(Reply reply){
        replies.push(reply);
    }


}
