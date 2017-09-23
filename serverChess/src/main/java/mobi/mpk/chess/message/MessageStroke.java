package mobi.mpk.chess.message;

import org.json.simple.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class MessageStroke implements Message {

    private String name;
    private String text;
    private Date date;
    private TypeMessage type;

    public MessageStroke(String name, String text, Date date){

        this.name = name;
        this.text = text;
        this.date = new Date();
        this.type = TypeMessage.command;

    }

    public MessageStroke(String name, String text){

        this.name = name;
        this.text = text;
        this.date = new Date();
        this.type = TypeMessage.command;

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

    @Override
    public void checkIntegeryData(String userName) {

        if(!this.name.equals(userName)){

            this.name = userName;

        }

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }


}
