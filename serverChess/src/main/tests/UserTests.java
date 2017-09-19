import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.RegistryAllUsers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTests {

    @Test
    public void testCreateUser(){

        User user = new User();

        assert(user.addName("Jack"));


    }

    @Test
    public void testCreateUserButNameExist(){
        User user = new User();
        user.addName("John");
        RegistryAllUsers.getInstance().addUser(user);
        user = new User();
        assertEquals(user.addName("John"), false);
    }

    @Test
    public void testCreateUserConstructorWithName(){
        User user = new User("Kek");
        assertEquals(user.getName(), "Kek");
    }

    @Test
    public void testCreateUserAnonymus(){

        User user1 = new User();
        RegistryAllUsers.getInstance().addUser(user1);

        User user2 = new User();

        assertEquals(user1.getName(), "Anonymus");
        assertEquals(user2.getName(), "Anonymus1");

    }

}
