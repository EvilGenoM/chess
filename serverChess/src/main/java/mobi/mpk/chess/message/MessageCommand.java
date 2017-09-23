package mobi.mpk.chess.message;

import org.json.simple.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class MessageCommand implements Message{

    private String name;
    private String text;
    private Date date;
    private TypeMessage type;

    public MessageCommand(String name, String text, Date date){
        this.name = name;
        this.text = text;
        this.date = date;
        this.type = TypeMessage.command;
    }

    public MessageCommand(String name, String text){
        this.name = name;
        this.text = text;
        this.date = new Date();
        this.type = TypeMessage.command;
    }

    public void checkIntegeryData(String userName){

        if(!this.name.equals(userName)){

            this.name = userName;

        }

    }

    @Override
    public JSONObject getJson() {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("text", text);
        json.put("date", date);
        json.put("type", type);

        return json;

    }

    public String getName() {

        return name;

    }

    public String getText() {

        return text;

    }

    public void setText(String text) {

        this.text = text;

    }

    public Date getDate() {

        return date;

    }

    public void setDate(Date date) {

        this.date = date;

    }

}
