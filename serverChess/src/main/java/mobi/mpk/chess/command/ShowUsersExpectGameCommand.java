package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.Registry;
import mobi.mpk.chess.registry.RegistryUsersExpectGame;

public class ShowUsersExpectGameCommand implements Command{

    @Override
    public String execute() {
        Registry registry = RegistryUsersExpectGame.getInstance();
        String resultCommand = "List users want playing:";

        for(User user: registry.getListUsers()){
            resultCommand += "\n" + user.getName();
        }

        return resultCommand;
    }

}
