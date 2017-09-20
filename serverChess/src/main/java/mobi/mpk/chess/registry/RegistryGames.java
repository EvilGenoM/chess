package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controller;
import mobi.mpk.chess.controller.ControllerGame;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistryGames {

    private static volatile RegistryGames instance;
    private ConcurrentMap<User, Controller> games;

    private RegistryGames(){

        games = new ConcurrentHashMap<User, Controller>();

    }

    public static RegistryGames getInstance() {
        RegistryGames localInstance = instance;
        if (localInstance == null) {
            synchronized (RegistryGames.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RegistryGames();
                }
            }
        }
        return localInstance;
    }

    public void addControllerGame(User user, ControllerGame controllerGame){

        games.putIfAbsent(user, controllerGame);

    }

    public Controller getControllerGame(User user){

        return games.get(user);

    }

}
