import mobi.mpk.chess.message.ManagerMessages;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.TypeMessage;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MessageCommandTest {

    @Test
    public void testMessageManager(){

        JSONObject json = new JSONObject();

        json.put("name", "Jack");
        json.put("text", "Test");
        json.put("date", Calendar.getInstance());
        json.put("date", TypeMessage.command);

        ManagerMessages manager = new ManagerMessages(json);
        Message message = manager.getMessage();

        assertEquals(message.getName(), "Jack");
        assertEquals(message.getText(), "Test");
    }

    @Test
    public void testMessageNullJSON(){

        ManagerMessages manager = new ManagerMessages(null);
        Message message = manager.getMessage();

        assertEquals(message.getName(), "Server");
        assertEquals(message.getText(), "Error");

    }

    @Test
    public void testMessageNullMerge(){

        JSONObject json = new JSONObject();
        json.put("name", "Jack");
        json.put("date", new Date());

        ManagerMessages manager = new ManagerMessages(json);
        Message message = manager.getMessage();

        System.out.println(message.getText());

        assertEquals(message.getName(), "Server");
        assertEquals(message.getText(), "Error");

    }


}
