package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistryAllUsers implements Registry{

    private static volatile RegistryAllUsers instance;
    private ConcurrentMap<String, User> users;

    private RegistryAllUsers(){

        users = new ConcurrentHashMap<String, User>();

    }

    public static RegistryAllUsers getInstance() {
        RegistryAllUsers localInstance = instance;
        if (localInstance == null) {
            synchronized (RegistryAllUsers.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RegistryAllUsers();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void addUser(User user) {

        if(user.getName() != null) {
            users.putIfAbsent(user.getName(), user);
        }

    }

    @Override
    public void removeUser(User user) {

        users.remove(user.getName());

    }

    @Override
    public User getUser(User user) {

        String userName = user.getName();
        return users.get(userName);

    }

    @Override
    public User getUser(String userName) {

        return users.get(userName);

    }

    @Override
    public boolean existName(String name) {
        return users.containsKey(name);
    }

    @Override
    public List<User> getListUsers(){

        List<User> listUsers = new ArrayList<User>();

        for (User user : users.values()) {
            listUsers.add(user);
        }

        return listUsers;
    }


}
