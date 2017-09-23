package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controllable;
import mobi.mpk.chess.controller.GameController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistryGames {

    private static volatile RegistryGames instance;
    private ConcurrentMap<User, Controllable> games;

    private RegistryGames(){

        games = new ConcurrentHashMap<User, Controllable>();

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

    public void addControllerGame(User user, GameController controllerGame){

        games.putIfAbsent(user, controllerGame);

    }

    public Controllable getControllerGame(User user){

        return games.get(user);

    }

}
