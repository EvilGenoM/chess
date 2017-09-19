package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.Registry;
import mobi.mpk.chess.registry.RegistryAllUsers;

public class ShowUsersAppCommand implements Command{

    @Override
    public String execute() {

        Registry registry = RegistryAllUsers.getInstance();
        String resultCommand = "List all users:";

        for(User user: registry.getListUsers()){
            resultCommand += "\n" + user.getName();
        }

        return resultCommand;

    }

}
