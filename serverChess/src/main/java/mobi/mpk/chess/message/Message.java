package mobi.mpk.chess.message;

import org.json.simple.JSONObject;

import java.util.Calendar;
import java.util.Date;

public interface Message {

    JSONObject getJson();

    void checkIntegeryData(String userName);

    String getName();

    String getText();

    void setText(String text);

    Date getDate();

    void setDate(Date date);

}
