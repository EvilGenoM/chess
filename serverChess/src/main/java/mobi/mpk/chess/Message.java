package mobi.mpk.chess;

import org.json.simple.JSONObject;

import java.util.Date;

public class Message {

    private String name;
    private String text;
    private Date date;

    public Message(JSONObject json){

        try {

            String name = (String)json.get("name");
            String text = (String)json.get("text");
            Date date = (Date)json.get("date");

            checkNullMargin(name, text, date);

        } catch (NullPointerException ex){

            fillMessage("Server", "Error", new Date());
            System.out.println(ex);

        }

    }

    private void checkNullMargin(String name, String text, Date date){

        if(name == null || text == null || date == null){
            fillMessage("Server", "Error", new Date());
        } else {
            fillMessage(name, text, date);
        }

    }

    private void fillMessage(String name, String text, Date date){

        this.name = name;
        this.text = text;
        this.date = date;

    }

    public JSONObject getJson(){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", this.name);
        jsonObject.put("text", this.text);
        jsonObject.put("date", this.date);

        return jsonObject;
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
