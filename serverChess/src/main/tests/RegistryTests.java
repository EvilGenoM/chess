import mobi.mpk.chess.registry.*;
import org.junit.Test;




public class RegistryTests {

    @Test
    public void testCreateRegistry(){

        Registry registry = RegistryUsersExpectGame.getInstance();

        String nameRegistry = registry.getClass().getSimpleName();

        boolean isNameRegistry = nameRegistry.equals("RegistryUsersExpectGame");

        assert(isNameRegistry);

    }



}
