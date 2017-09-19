package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;

import java.util.List;

public interface Registry {

    void addUser(User user);

    void removeUser(User user);

    User getUser(User user);

    User getUser(String userName);

    boolean existName(String name);

    List<User> getListUsers();

}
