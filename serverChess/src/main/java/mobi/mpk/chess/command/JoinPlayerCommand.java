package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controller;
import mobi.mpk.chess.controller.ControllerGame;
import mobi.mpk.chess.registry.RegistryAllUsers;
import mobi.mpk.chess.registry.RegistryGames;

public class JoinPlayerCommand implements Command {

    private User user1;
    private User user2;

    public JoinPlayerCommand(String user1Name, String user2Name){

        User user = RegistryAllUsers.getInstance().getUser(user1Name);
        this.user1 = user;

        user = RegistryAllUsers.getInstance().getUser(user2Name);
        this.user2 = user;

    }

    @Override
    public String execute() {

        if(this.user1 == null || this.user2 == null){
            return "Error";
        } else {
            Controller controller = new ControllerGame(user1, user2);
            RegistryGames.getInstance().addControllerGame(user1, controller);
            RegistryGames.getInstance().addControllerGame(user2, controller);
            return "Connect";
        }

    }

}