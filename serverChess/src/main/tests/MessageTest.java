import mobi.mpk.chess.Message;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void testMessage(){

        JSONObject json = new JSONObject();

        json.put("name", "Jack");
        json.put("text", "Test");
        json.put("date", new Date());

        Message message = new Message(json);
        System.out.println(message.getDate());

        assertEquals(message.getName(), "Jack");
        assertEquals(message.getText(), "Test");
    }

    @Test
    public void testMessageNullJSON(){

        Message message = new Message(null);

        assertEquals(message.getName(), "Server");
        assertEquals(message.getText(), "Error");

    }

    @Test
    public void testMessageNullMerge(){

        JSONObject json = new JSONObject();
        json.put("name", "Jack");
        json.put("date", new Date());

        Message message = new Message(json);

        System.out.println(message.getText());

        assertEquals(message.getName(), "Server");
        assertEquals(message.getText(), "Error");

    }


}
