import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RegistryTests {

    @Test
    public void testCreateRegistry(){

        Registry registry = RegistryUsersExpectGame.getInstance();

        String nameRegistry = registry.getClass().getSimpleName();

        boolean isNameRegistry = nameRegistry.equals("RegistryUsersExpectGame");

        assert(isNameRegistry);

    }

    @Test
    public void testGetUser(){

        Registry registry = RegistryUsersExpectGame.getInstance();

        User user = registry.getUser("testGetUser");

        assertEquals(user, null);

    }



}
