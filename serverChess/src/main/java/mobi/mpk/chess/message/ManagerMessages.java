package mobi.mpk.chess.message;

import org.json.simple.JSONObject;
import java.util.Calendar;

public class ManagerMessages {

    private String name;
    private String text;
    private TypeMessage type;

    public ManagerMessages(JSONObject json){

        try {

            String name = (String)json.get("name");
            String text = (String)json.get("text");
            TypeMessage type = (TypeMessage)json.get("type");

            checkNullMargin(name, text, type);

        } catch (NullPointerException ex){

            fillManagerMessages("Server", "Error", TypeMessage.command);
            System.out.println(ex);

        }

    }

    private void checkNullMargin(String name, String text, TypeMessage type){

        if(name == null || text == null){
            fillManagerMessages("Server", "Error", TypeMessage.command);
        } else {
            fillManagerMessages(name, text, type);
        }

    }

    private void fillManagerMessages(String name, String text, TypeMessage type){

        this.name = name;
        this.text = text;
        this.type = type;

    }

    public Message getMessage(){

        if(this.type == TypeMessage.stroke){
            return new MessageStroke(this.name, this.text);
        } else {
            return new MessageCommand(this.name, this.text);
        }

    }

}
