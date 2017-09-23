import mobi.mpk.chess.User;
import mobi.mpk.chess.command.Command;
import mobi.mpk.chess.command.ExpectGameCommand;
import mobi.mpk.chess.command.ShowUsersAppCommand;
import mobi.mpk.chess.registry.RegistryAllUsers;
import mobi.mpk.chess.registry.RegistryUsersExpectGame;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CommandTests {

    @Test
    public void testExpectGameCommand(){

        User user = new User();
        user.addName("Jack2");

        RegistryAllUsers.getInstance().addUser(user);

        Command command = new ExpectGameCommand("Jack2");
        command.execute();

        assertEquals(user, RegistryUsersExpectGame.getInstance().getUser("Jack2"));

    }

    @Test
    public void testExpectGameCommandNull(){

        User user = new User();
        user.addName("Sam");

        RegistryAllUsers.getInstance().addUser(user);

        Command command = new ExpectGameCommand("Kerk");
        String resultCommand = command.execute();

        assertEquals(resultCommand, "Error");

    }


    @Test
    public void testShowUsersAppCommand(){

        User user1 = new User();
        user1.addName("A1");

        User user2 = new User();
        user2.addName("A2");

        RegistryAllUsers registry = RegistryAllUsers.getInstance();
        registry.clear();
        registry.addUser(user1);
        registry.addUser(user2);

        Command command = new ShowUsersAppCommand();
        String result = command.execute();

        String resultTrue = "List all users:\nA1\nA2";
        System.out.println(result);

        assertEquals(result, resultTrue);

    }



}
