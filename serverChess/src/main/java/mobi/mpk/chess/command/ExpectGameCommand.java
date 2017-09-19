package mobi.mpk.chess.command;

import mobi.mpk.chess.registry.RegistryAllUsers;
import mobi.mpk.chess.registry.RegistryUsersExpectGame;
import mobi.mpk.chess.User;

public class ExpectGameCommand implements Command{

    private User user;

    public ExpectGameCommand(String userName){

        User user = RegistryAllUsers.getInstance().getUser(userName);
        this.user = user;

    }

    @Override
    public String execute() {

        if(user == null){
            return "Error";
        } else {
            RegistryUsersExpectGame.getInstance().addUser(this.user);
        }

        return "Wait for the connection";

    }

}