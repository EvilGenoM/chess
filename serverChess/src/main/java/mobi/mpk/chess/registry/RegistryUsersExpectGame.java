package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistryUsersExpectGame implements Registry{

    private static volatile Registry instance;
    private ConcurrentMap<String, User> usersExpect;

    private RegistryUsersExpectGame(){

        usersExpect = new ConcurrentHashMap<String, User>();

    }

    public static Registry getInstance() {
        Registry localInstance = instance;
        if (localInstance == null) {
            synchronized (RegistryUsersExpectGame.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RegistryUsersExpectGame();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void addUser(User user) {

        usersExpect.putIfAbsent(user.getName(), user);

    }

    @Override
    public void removeUser(User user) {

        usersExpect.remove(user.getName());

    }

    @Override
    public User getUser(User user) {

        String userName = user.getName();
        return usersExpect.get(userName);

    }

    @Override
    public User getUser(String userName) {
        return usersExpect.get(userName);
    }

    @Override
    public boolean existName(String name) {
        return usersExpect.containsKey(name);
    }

    @Override
    public List<User> getListUsers(){

        List<User> listUsers = new ArrayList<User>();

        for (User user : usersExpect.values()) {
            listUsers.add(user);
        }

        return listUsers;
    }

}
