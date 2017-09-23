import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controllable;
import mobi.mpk.chess.controller.GameController;
import mobi.mpk.chess.controller.ManagerConrollers;
import mobi.mpk.chess.registry.RegistryGames;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestManagerControllers {

    @Test
    public void testReturnLobbyController(){

        ManagerConrollers manager = new ManagerConrollers();
        Controllable controller = manager.getController(null);

        String nameController = controller.getClass().getSimpleName();

        assertEquals(nameController, "LobbyController");

    }

    @Test
    public void testReturnGameController(){

        ManagerConrollers manager = new ManagerConrollers();
        User user = new User("Manager");
        GameController gameController = new GameController(user, null);

        RegistryGames.getInstance().addControllerGame(user, gameController);

        Controllable controller = manager.getController(user);

        assertEquals(controller, gameController);

    }


}
