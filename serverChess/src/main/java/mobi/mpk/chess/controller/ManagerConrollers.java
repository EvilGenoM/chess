package mobi.mpk.chess.controller;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.RegistryGames;

public class ManagerConrollers{

    private Controllable controller;

    public ManagerConrollers(Controllable controller){
        this.controller = controller;
    }

    public ManagerConrollers(){
        this(new LobbyController());
    }

    public Controllable getController(User user) {

        if(user == null){
            return this.controller;
        }

        Controllable controller = RegistryGames.getInstance().getControllerGame(user);
        if(controller == null) {

            return this.controller;

        } else{

            return controller;

        }

    }


}
